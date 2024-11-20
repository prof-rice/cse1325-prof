#ifndef __DATE_H
#define __DATE_H

#include <iostream>

class Date {
  public:
    Date(int year = 1970, int month = 1, int day = 1);
    friend std::ostream& operator<<(std::ostream& ost, const Date& date);
    friend std::istream& operator>>(std::istream& ist,       Date& date);

// Determine at compile time if <=> is supported by this compiler
#ifdef __cpp_impl_three_way_comparison
    auto operator<=>(const Date&) const = default;
// If not, revert to the explicit definition of all 6 comparison operators
#else
    inline bool operator==(const Date& date) const {return (compare(date) == 0);}
    inline bool operator!=(const Date& date) const {return (compare(date) != 0);}
    inline bool operator< (const Date& date) const {return (compare(date) <  0);}
    inline bool operator<=(const Date& date) const {return (compare(date) <= 0);}
    inline bool operator> (const Date& date) const {return (compare(date) >  0);}
    inline bool operator>=(const Date& date) const {return (compare(date) >= 0);}
#endif

  private:
    int _year;
    int _month;
    int _day;
    
    int compare(const Date& date) const;
};

#endif
