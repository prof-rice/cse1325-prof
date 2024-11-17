#ifndef __PICKUP_
#define __PICKUP_

#include "vehicle.h"

const double BED_WIDTH = 5.2;
const double BED_DEPTH = 1.9; 

class Pickup : public Vehicle {
  public:
    Pickup(std::string name, double bed_length);
    double cargo_space() override;
  private:
    double _bed_length; // feet - 5' wide, 2' high
};

#endif
