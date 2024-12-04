#include <iostream>
#include <ostream>
#include <cmath>
#include "to_string.h"
#include "stox.h"

class Coordinate {
    int _x, _y, _z;
  public:
    Coordinate(int x=0, int y=0, int z=0) : _x{x}, _y{y}, _z{z} { }
    double magnitude() {return sqrt(static_cast<double>(_x*_x+_y*_y+_z*_z));}
    friend std::ostream& operator<<(std::ostream& ost, const Coordinate& c) {
        ost << '(' << c._x << ',' << c._y << ',' << c._z << ')';
        return ost;
    }
    friend std::istream& operator>>(std::istream& ist, Coordinate& c) {
        char a;
        ist >> a; // (
        ist >> c._x;
        ist >> a; // ,
        ist >> c._y;
        ist >> a; // ,
        ist >> c._z;
        ist >> a; // )
        return ist;
    }
};

int main() {
    Coordinate c{3,4,5};
    std::string c_string = to_string(c);
    std::cout << "to_string: " << c_string << std::endl;

    Coordinate new_c = stox<Coordinate>("(42,7,3)");
    std::cout << "stox<Coordinate>: " << new_c << std::endl;
}
