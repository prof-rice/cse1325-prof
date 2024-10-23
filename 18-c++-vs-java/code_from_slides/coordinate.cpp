#include "coordinate.h"
#include <cstdlib>
#include <cassert>

Coordinate::Coordinate(int x, int y) : _x{x}, _y{y} { }
int Coordinate::x( ) const {
    return _x; 
}
int Coordinate::y( ) const {
    return _y;
}
Coordinate Coordinate::operator*(const int i) {
    return Coordinate{_x*i, _y*i};
}
std::ostream& operator<<(std::ostream& ost, const Coordinate& c) {
    ost << '(' << c.x() << ',' << c.y() << ')';
    return ost;
}

