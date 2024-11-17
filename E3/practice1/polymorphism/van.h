#ifndef __VAN_
#define __VAN_

#include "vehicle.h"

class Van : public Vehicle {
  public:
    Van(std::string name, double capacity);
    double cargo_space() override;
  private:
    double _capacity; // cubic feet
};

#endif
