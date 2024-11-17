#include "van.h"

Van::Van(std::string name, double capacity)
  : Vehicle{name}, _capacity{capacity} { }
double Van::cargo_space() {return _capacity;}

