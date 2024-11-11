#include "reading.h"
#include <iomanip>

Reading::Reading(int hour, double temp)
            : _hour{hour}, _temp{temp} {validate();}

// Chain to non-default constructor if preferred
// Reading::Reading() : Reading(0,0) { }

int Reading::hour() {return _hour;}
double Reading::temp() {return _temp;}

void Reading::validate() {
    if (_hour < 0 || 23 < _hour) 
         throw std::runtime_error{"Invalid hour: " + std::to_string(_hour)};
}

std::istream& operator>>(std::istream& ist, Reading& reading) {
  ist >> reading._hour >> reading._temp;
  reading.validate();
  return ist;
}

std::ostream& operator<<(std::ostream& ost, Reading& reading) {
    ost << std::setw(4) << reading._hour << ": " 
        << std::setw(6) << std::right << std::fixed 
                        << std::setprecision(1) << reading._temp; 

    return ost;
}

