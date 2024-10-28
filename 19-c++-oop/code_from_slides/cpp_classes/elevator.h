#ifndef __ELEVATOR_H
#define __ELEVATOR_H

using namespace std;

class Elevator {
  public:
    Elevator();
    Elevator(int starting_floor);
    void move(int target_floor);
    static int get_floors_traversed();
  private:
    static int floors_traversed;  // declaration only
    int current_floor;
};

#endif
