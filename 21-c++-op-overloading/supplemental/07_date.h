#ifndef __DATE_H
#define __DATE_H

#include <iostream>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month);
Month& operator++(Month& m);      // Pre-increment
Month  operator++(Month& m, int); // Post-increment
Month& operator--(Month& m);      // Pre-decrement
Month  operator--(Month& m, int); // Post-decrement


std::ostream& operator<<(std::ostream& ost, Month month);
std::istream& operator>>(std::istream& ost, Month& month);

class Date {
  public:
    Date(int y, Month m, int d);
    Date();
    std::string to_string() const;
    
    Date operator+(int days);
    Date& operator+=(int days);
    
    inline bool operator==(const Date& rhs) {return (compare(rhs) == 0);}
    inline bool operator!=(const Date& rhs) {return (compare(rhs) != 0);}
    inline bool operator< (const Date& rhs) {return (compare(rhs) <  0);}
    inline bool operator<=(const Date& rhs) {return (compare(rhs) <= 0);}
    inline bool operator> (const Date& rhs) {return (compare(rhs) >  0);}
    inline bool operator>=(const Date& rhs) {return (compare(rhs) >= 0);}
    
    friend std::ostream& operator<<(std::ostream& ost, const Date& date);
    friend std::istream& operator>>(std::istream& ost, Date& date);
  private:
    int compare(const Date& rhs);
    int year;
    Month month;
    int day;
};

#endif
