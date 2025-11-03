#include <iostream>
#include <cmath>

class Coordinate {
    int _x, _y, _z;
  public:
    Coordinate(int x=0, int y=0, int z=0) : _x{x}, _y{y}, _z{z} { }
    double magnitude() {return sqrt(static_cast<double>(_x*_x+_y*_y+_z*_z));}
    friend std::ostream& operator<<(std::ostream& ost, const Coordinate& c) {
        ost << '(' << c._x << ',' << c._y << ',' << c._z << ')';
        return ost;
    }
};
bool operator>(Coordinate& lhs, Coordinate& rhs) {
    return lhs.magnitude() > rhs.magnitude();
}

template<class T>
T max(T lhs, T rhs) {
    if (lhs > rhs) return lhs; else return rhs;
}

int main() {
    std::cout << "The larger of 3 and 42 is " << max(3, 42) << std::endl;
    std::cout << "The larger of 3.1415 and 2.718 is " << max(3.1415, 2.718) << std::endl;
    std::cout << "The larger of (1,2,3) and (2,1,-4) is " 
              << max(Coordinate{1,2,3},Coordinate{2,1,-4}) << std::endl;
}
