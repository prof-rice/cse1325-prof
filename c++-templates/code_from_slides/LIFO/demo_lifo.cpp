#include "lifo.h"
#include <iostream>
#include <ostream>
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

template<class T>
void inspect(LIFO<T>& lifo) {
    std::cout << "LIFO: ";
    for (int i=0; i<=lifo._top; ++i) std::cout << lifo._lifo[i] << ' ';
    std::cout << std::endl;
}

int main() {
    std::cout << "Using int" << std::endl << "=========" << std::endl;
    {
        LIFO<int> lifo;
        inspect(lifo);
        lifo.push(3); std::cout << "Push 3, "; inspect(lifo);
        lifo.push(1); std::cout << "Push 1, "; inspect(lifo);
        lifo.push(4); std::cout << "Push 4, "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        lifo.push(1); std::cout << "Push 1, "; inspect(lifo);
        lifo.push(5); std::cout << "Push 5, "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
    }
    std::cout << std::endl;

    std::cout << "Using string" << std::endl << "============" << std::endl;
    {
        LIFO<std::string> lifo;
        inspect(lifo);
        lifo.push("Now"); std::cout << "Push Now, "; inspect(lifo);
        lifo.push("is"); std::cout << "Push is, "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        lifo.push("the"); std::cout << "Push the, "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        lifo.push("time"); std::cout << "Push time, "; inspect(lifo);
        lifo.push("for"); std::cout << "Push for, "; inspect(lifo);
        lifo.push("all"); std::cout << "Push all, "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
    }
    std::cout << std::endl;

    std::cout << "Using custom class Coordinate" << std::endl << "=============================" << std::endl;
    {
        LIFO<Coordinate> lifo;
        inspect(lifo);
        lifo.push(Coordinate(1,5,2)); std::cout << "Push (1,5,2), "; inspect(lifo);
        lifo.push(Coordinate(3,18,7)); std::cout << "Push (3,18,7), "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        lifo.push(Coordinate(42,7,3)); std::cout << "Push (42,7,3), "; inspect(lifo);
        lifo.push(Coordinate(3,7,42)); std::cout << "Push (3,7,42), "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
        std::cout << "Pop " << lifo.pop() << ", "; inspect(lifo);
    }
}        
