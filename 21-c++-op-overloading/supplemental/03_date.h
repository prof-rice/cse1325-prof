#ifndef __DATE_H
#define __DATE_H

#include <iostream>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month);

std::ostream& operator<<(std::ostream& ost, Month month);
std::istream& operator>>(std::istream& ost, Month& month);

class Date {
  public:
    Date(int y, Month m, int d);
    Date();
    std::string to_string() const;
    friend std::ostream& operator<<(std::ostream& ost, const Date& date);
    friend std::istream& operator>>(std::istream& ost, Date& date);
  private:
    int year;
    Month month;
    int day;
};

#endif
