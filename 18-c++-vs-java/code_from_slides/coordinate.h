#ifndef __COORDINATE_H
#define __COORDINATE_H

#include <ostream>

class Coordinate {
  public:
    Coordinate(int x=0, int y=0); // default parameters!
    int x() const; //"const" means "I promise this method doesn't
    int y() const; //   change any fields"
    Coordinate operator*(int i);  // Overloading the * operator
  private:
    int _x;
    int _y;
};
// The operator<< function overrides the << operator
std::ostream& operator<<(std::ostream& ost, const Coordinate& c);

#endif
