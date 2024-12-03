#include "intensity.h"

#include <stdexcept>

Intensity::Intensity(int value)
    : _value{value} {
    if(value < 0 || value > 255)
        throw std::out_of_range{"Intensity must be between 0 and 255"};
}
int Intensity::value() const {
    return _value;
}

