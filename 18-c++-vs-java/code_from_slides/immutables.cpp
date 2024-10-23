#include <iostream>

class Coordinate {
    int x, y;
  public: 
    Coordinate(int x, int y) {this->x = x; this->y = y;}
    Coordinate() {Coordinate(0,0);}
    void multiply(int by) {this->x *= by; this->y *= by;}
    friend std::ostream& operator<<(std::ostream& ost, const Coordinate c) {
        ost << "(" << c.x << "," << c.y << ")";
        return ost;
    }
};

void pass_by_value          (      Coordinate  c) {c .multiply(2);}
void pass_by_reference      (      Coordinate& c) {c .multiply(2);}
void pass_by_const_reference(const Coordinate& c) {}//c .multiply(2);}
void pass_by_pointer        (      Coordinate* c) {c->multiply(2);}

int main() {
    Coordinate c(3, 4); // object - (3,4) is on the stack
    pass_by_value(c);
    std::cout << "Pass by value           results in " << c << std::endl;
    pass_by_reference(c);
    std::cout << "Pass by reference       results in " << c << std::endl;
//  pass_by_const_reference(c);
//  std::cout << "Pass by const reference results in " << c << std::endl;
    pass_by_pointer(&c);
    std::cout << "Pass by pointer         results in " << c << std::endl;
}
