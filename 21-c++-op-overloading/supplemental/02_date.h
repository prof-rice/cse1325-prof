#ifndef __DATE_H
#define __DATE_H

#include <iostream>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month);

std::ostream& operator<<(std::ostream& ost, Month month);
// Add a FUNCTION that overloads the >> operator for type Month
std::istream& operator>>(std::istream& ist, Month& month);

class Date {
    int year;
    Month month;
    int day;
  public:
    Date(int y, Month m, int d);
    std::string to_string();
};

#endif
