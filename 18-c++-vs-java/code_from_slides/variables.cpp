#include <iostream>

class Coordinate {
    int x, y;
  public: 
    Coordinate(int x, int y) {this->x = x; this->y = y;}
    Coordinate() {Coordinate(0,0);}
    friend std::ostream& operator<<(std::ostream& ost, const Coordinate c) {
        ost << "(" << c.x << "," << c.y << ")";
        return ost;
    }
};

int main() {
    int x = 3;          // primitive - 3 is on the stack
    int y = 4;          // primitive - 4 is on the stack
    Coordinate c(x, y); // object - (3,4) is on the stack (not possible in Java)
    Coordinate& cr = c; // reference to (alias of) c - same object
    Coordinate* cp = &c; // pointer to same object
    Coordinate* c2 = new Coordinate(4, 3); // point to new object on the heap
    std::cout << x << " and " << y << " makes " << c 
        << " and also " << cr 
        << " as well as " << *cp 
        << " and " << *c2 << " on the heap!" << std::endl;
}
