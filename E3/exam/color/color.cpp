#include "color.h"

#include <iomanip>

Color::Color(int red, int green, int blue)
    : Red(red), Green(green), Blue(blue) { }
std::ostream& operator<<(std::ostream& ost, const Color& color) {
    return ost << std::hex << std::setfill('0')
               << std::setw(2) << color.Red  ::value() << ":" 
               << std::setw(2) << color.Green::value() << ":" 
               << std::setw(2) << color.Blue ::value();
}
