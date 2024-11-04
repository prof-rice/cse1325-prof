#include "date.h"
#include <map>
#include <exception>
// #include <algorithm>

// ///////////////////////////////////////////////////////////
// Constructors

Date::Date(int year, Month month, int day) : _year{year}, _month{month}, _day{day} {
    if (1 > day || day > days_in_month(month, year)) 
        throw std::runtime_error{"Invalid day: " + std::to_string(day)};
}

// ///////////////////////////////////////////////////////////
// Stream I/O Operators

// Stream out a date object
std::ostream& operator<<(std::ostream& os, const Date& date) {
    os << date._year << " " << date._month << " " << date._day;
    return os;
}

// Stream into an existing Date object
// Note the dependence on streaming in a Month (overloaded below)
std::istream& operator>>(std::istream& is, Date& date) {
    is >> date._year;
    is >> date._month;
    is >> date._day; 
    if (1 > date._day || date._day > date.days_in_month(date._month, date._year)) 
        throw std::runtime_error{"Invalid day: " + std::to_string(date._day)};
    return is;
}

// Support function that calcuates number of days in a month (data validation)
int Date::days_in_month(Month month, int year) {
    switch(month) {
        case Month::Apr:
        case Month::Jun:
        case Month::Sep:
        case Month::Nov: return 30;
        case Month::Feb: return ((year%400==0) || (year%4==0 && year%100!=0)) ? 29 : 28;
        default:         return 31;
    }
}

// ///////////////////////////////////////////////////////////
// Comparison operators

// Implement the comparison operators using a PRIVATE method
// compare returns -1 if this < rhs, 0 of this == rhs, and 1 if this > rhs
int Date::compare(const Date& rhs) {
    if(_year <rhs._year ) return -1;
    if(_year >rhs._year ) return  1;
    if(_month<rhs._month) return -1;
    if(_month>rhs._month) return  1;
    if(_day  <rhs._day  ) return -1;
    if(_day  >rhs._day  ) return  1;
    return 0;   
}

// ///////////////////////////////////////////////////////////
// Pre- and post-increment operators

Date& Date::operator++() {    // Pre-increment  
    ++_day;
  if (_day > days_in_month(_month, _year)) {
    if (_month == Month::Dec) {
      ++_year;
    }
    ++_month;
    _day = 1;
  }
  return *this;
}

Date Date::operator++(int) {  // Post-increment
  Date result{*this};
  ++(*this);
  return result;
}

// ///////////////////////////////////////////////////////////
// Addition

// date + n
Date Date::operator+(int n){  // Number of days past the current date
    Date d{*this};
    for ( ; n>0; --n) ++d;    // Horribly inefficient for large n! But concise…  
    // d += n;                // Alternate delegation to operator+=
    return d;
}

// n + date
Date operator+(int n, Date& date) {
    return date + n;
}

// ///////////////////////////////////////////////////////////
// Compound addition

Date& Date::operator+=(int n){    // Compound
    for ( ; n>0; --n) ++(*this);  // Horribly inefficient for large n!
    return *this;
}

