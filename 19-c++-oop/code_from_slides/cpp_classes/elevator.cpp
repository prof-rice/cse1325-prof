#include "elevator.h"
#include <cstdlib>

// This is the constructor bodies, including the initialization list
// The first constructor delegates to the second constructor
Elevator::Elevator() : Elevator{1} { }
Elevator::Elevator(int starting_floor) : current_floor{starting_floor} { }

// Both of the above could be replaced with one using a default parameter
// Elevator::Elevator(int starting_floor = 1) : current_floor{starting_floor} { }

// This is the body for the move method
void Elevator::move(int target_floor) {
    floors_traversed += abs(target_floor - current_floor);
    current_floor = target_floor;
}

// This is the implemenation of static method get_floors_traversed()
int Elevator::get_floors_traversed() {return floors_traversed;}

// This allocates a memory location for the static variable in the class
int Elevator::floors_traversed = 0;


