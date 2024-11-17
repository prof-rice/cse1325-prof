#ifndef __VEHICLE_
#define __VEHICLE_

#include <iostream>

class Vehicle {
  public:
    Vehicle(std::string name);
    std::string name();
    virtual double cargo_space() = 0; // cubic feet
    friend std::ostream& operator<<(std::ostream& ost, const Vehicle& vehicle);
  private:
    std::string _name;
};



#endif
