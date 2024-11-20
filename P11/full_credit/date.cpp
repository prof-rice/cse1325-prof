#include "date.h"

#include <iomanip>

Date::Date(int year, int month, int day)
    : _year{year}, _month{month}, _day{day} { }

std::ostream& operator<<(std::ostream& ost, const Date& date) {
    char old_setfill = ost.fill();
    return ost << std::setfill('0') 
               << std::setw(4) << date._year  << '/'
               << std::setw(2) << date._month << '/'
               << std::setw(2) << date._day
               << std::setfill(old_setfill);
}

int Date::compare(const Date& date) const {
    if(_year  != date._year)  return _year  - date._year; 
    if(_month != date._month) return _month - date._month;
    if(_day   != date._day)   return _day   - date._day;
    return 0;
}
