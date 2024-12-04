#include "horse.h"
#include <chrono>
#include <thread>

Horse::Horse(std::string name, int speed, int track_length) : _name{name}, _speed{speed}, _position{track_length}, _running{true} { }

// The horses race to be first to grab the mutex and insert their name in the static _winner string!
std::mutex Horse::m;
std::string Horse::_winner = "";
std::string Horse::winner() {return _winner;}

// Getters
std::string Horse::name() {return _name;}
bool Horse::running() {return _running;}

// Representation of the horse on the racetrack
std::string Horse::view() {
    std::string result;
    for (int i = 0; i < _position; ++i) result += (i%5 == 0 ? ':' : '.');
    result += " " + _name;
    if (_winner == _name) result += " (WINNER!!!!!)";
    return result;
}

// The thread
void Horse::gallop() {
    _running = true;
    while (_winner.empty()) {
        std::this_thread::sleep_for(std::chrono::milliseconds(_speed + std::rand() % 200));
        if (_winner.empty() && (--_position <= 0)) {  // consider short-circuit evaluation
            m.lock(); 
            if (_winner.empty()) _winner = _name;
            m.unlock();
        }
    }
    _running = false;
}
