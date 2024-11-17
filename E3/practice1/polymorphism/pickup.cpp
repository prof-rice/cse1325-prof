#include "pickup.h"

Pickup::Pickup(std::string name, double bed_length) 
  : Vehicle{name}, _bed_length{bed_length} { }
double Pickup::cargo_space() {
    return _bed_length * BED_WIDTH * BED_DEPTH;
}

