#ifndef __DATE_H
#define __DATE_H

#include "month.h"

#include <iostream>

class Date {
  public:
    Date(int year = 1970, Month month = Month::Jan, int day = 1);
    
    // Stream I/O operators
    friend std::ostream& operator<<(std::ostream& os, const Date& date);
    friend std::istream& operator>>(std::istream& is, Date& date);
    
    // Comparison operators
    // auto operator<=>(const Point& other) const = default;
    
    /* Pre-C++ 20 implementation */
    inline bool operator==(const Date& rhs) {return (compare(rhs) == 0);}
    inline bool operator!=(const Date& rhs) {return (compare(rhs) != 0);}
    inline bool operator< (const Date& rhs) {return (compare(rhs) <  0);}
    inline bool operator<=(const Date& rhs) {return (compare(rhs) <= 0);}
    inline bool operator> (const Date& rhs) {return (compare(rhs) >  0);}
    inline bool operator>=(const Date& rhs) {return (compare(rhs) >= 0);} 
    // */
    
    // Pre-and Post-Increment
    Date& operator++();    // Pre-increment
    Date  operator++(int); // Post-increment (the parameter is ignored)
    
    // Addition 
    Date  operator+(int n);   // date + n, the number of days past the current date
    friend Date operator+(int n, Date& date); // ditto, but n + date
    
    // Compound addition
    Date& operator+=(int n);  // Number of days past the current date
    
  private:
    int compare(const Date& rhs);                    // For non-spaceship case only
    static int days_in_month(Month month, int year); // For data validation on input
    
    int _year;
    Month _month;
    int _day;
};

#endif
