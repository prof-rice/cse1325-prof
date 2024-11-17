#include "vehicle.h"

Vehicle::Vehicle(std::string name) : _name{name} { }
std::string Vehicle::name() {return _name;}

std::ostream& operator<<(std::ostream& ost, const Vehicle& vehicle) {
    return ost << vehicle._name;
}
