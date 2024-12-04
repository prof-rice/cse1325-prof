#include <stdexcept>
#include <iostream>

using namespace std;

//
// Traffic light colors
//

enum class Traffic_light_color {GREEN, YELLOW, RED};
string ctos(Traffic_light_color color) {
  if (color == Traffic_light_color::GREEN) return "green";
  if (color == Traffic_light_color::YELLOW) return "yellow";
  if (color == Traffic_light_color::RED) return "red";
  throw runtime_error("ctos: invalid color");
}

// ////////////////////
// Events
// ////////////////////

// Event manager class - instance once for each event type
//   generate() will add an event to the queue
//   consume() will return true if an event was pending, false if not

class Event {
  public:
    void generate() {++_pending;}
    bool consume() {
      if (_pending > 0) {--_pending; return true;}
      return false;
    }
  private:
    int _pending = 0;
};

// The events for our traffic light system

Event e_enable_green_1;
Event e_enable_green_2;

// ////////////////////
// States
// ////////////////////

// The virtual base class for our states 
//   - derive each state type (class) from this
//   - instance a derived class each time a new state is entered
//   color() returns the current color of the associated traffic light
//   tic() is called once per second, and invokes the derived class' handle()
//   handle() returns the next (or same) state for this machine

class State {
  public:
    State(int seconds) : _seconds{seconds} { }
    virtual Traffic_light_color color() {throw runtime_error("State color");}

    State* tic() {
      if (_seconds > 0) --_seconds;
      return handle();
    }

  protected:
    virtual State* handle() {throw runtime_error("State handle");}
    int _seconds = 0;
};

// Provide every state access to every other state
// This works around the circular reference problem by allowing a state
//   to create the next state using just the text name of the next state
State* state_factory(string state);

// The state types defined in our machine - green, yellow, and red for 2 machines

class Green_1 : public State {
  public:
    Green_1() : State(27) { }
    Traffic_light_color color() override {
      return Traffic_light_color::GREEN;
    }
  protected:
    State* handle() override {
      if (_seconds <= 0) {
        return state_factory("Yellow_1");
      } else {
        return this;
      }
    }
};
  
class Yellow_1 : public State {
  public:
    Yellow_1() : State(3) { }
    Traffic_light_color color() override {
      return Traffic_light_color::YELLOW;
    }
  protected:
    State* handle() override {
      if (_seconds <= 0) {
        e_enable_green_2.generate();
        return state_factory("Red_1");
      } else {
        return this;
      }
    }
};

class Red_1 : public State {
  public:
    Red_1() : State(0) { }
    Traffic_light_color color() override {
      return Traffic_light_color::RED;
    }
  protected:
    State* handle() override {
      if (e_enable_green_1.consume()) {
        return state_factory("Green_1");
      } else {
        return this;
      }
    }
};

class Green_2 : public State {
  public:
    Green_2() : State(27) { }
    Traffic_light_color color() override {
      return Traffic_light_color::GREEN;
    }
  protected:
    State* handle() override {
      if (_seconds <= 0) {
        return state_factory("Yellow_2");
      } else {
        return this;
      }
    }
};
  
class Yellow_2 : public State {
  public:
    Yellow_2() : State(3) { }
    Traffic_light_color color() override {
      return Traffic_light_color::YELLOW;
    }
  protected:
    State* handle() override {
      if (_seconds <= 0) {
        e_enable_green_1.generate();
        return state_factory("Red_2");
      } else {
        return this;
      }
    }
};

class Red_2 : public State {
  public:
    Red_2() : State(0) { }
    Traffic_light_color color() override {
      return Traffic_light_color::RED;
    }
  protected:
    State* handle() override {
      if (e_enable_green_2.consume()) {
        return state_factory("Green_2");
      } else {
        return this;
      }
    }
};

// The state factory - given a text name of a state,
//   the factory returns a pointer to an actual instance of it

State* state_factory(string state) {
    if (state == "Green_1") return new Green_1{};
    if (state == "Green_2") return new Green_2{};
    if (state == "Yellow_1") return new Yellow_1{};
    if (state == "Yellow_2") return new Yellow_2{};
    if (state == "Red_1") return new Red_1{};
    if (state == "Red_2") return new Red_2{};
    throw runtime_error("state_factory: Invalid state: " + state);
}

//
// State machines
//

// This class represents one face of a traffic light
//   color() is the current color of light illuminated
//   tic() is called once pre second to advance the lights when ready
//     The tic is passed to the state object for this face of the traffic light

class Light { // Context
  public:
    Light(State* state) : _state{state} { }
    Traffic_light_color color() {return _state->color();}
    void tic() {
      State* _newstate = _state->tic();
      if (_newstate != _state) {
        delete _state;
        _state = _newstate;
      }
    }
  private:
    State* _state;
};

//////////
// Main //
//////////
int main() {

  // Instance two traffic light faces
  Light north_south{state_factory("Red_1")};
  Light east_west{state_factory("Red_2")};

  // Now generate an event to kick off the precession of lights
  e_enable_green_1.generate();

  // Run for 300 seconds (5 minutes)
  for (int i=0; i < 300; ++i) {

    // Show the color of each face of the traffic signal
    cout << i << ": " << ctos(north_south.color()) << " "
                      << ctos(east_west.color()) << endl;  

    // Generate a tic for each traffic light
    east_west.tic();
    north_south.tic();
  }
}
