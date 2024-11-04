#include <iostream>
#include <vector>
#include <map>
#include "06_date.h"

// Used for converting between Month and its string representation
const std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
const std::map<std::string, Month> m = {
    {"JAN", JAN}, {"FEB", FEB}, {"MAR", MAR}, {"APR", APR}, {"MAY", MAY}, {"JUN", JUN},
    {"JUL", JUL}, {"AUG", AUG}, {"SEP", SEP}, {"OCT", OCT}, {"NOV", NOV}, {"DEC", DEC}
};

const std::vector<int> days_in_month = {31, 28, 31, 30, 31, 30,
                                        31, 31, 30, 31, 30, 31};
                                        
// //////////////////////   DATE   ///////////////////////

Date::Date(int y, Month m, int d) : year{y}, month{m}, day{d} {
    if (31 < d || d < 1) {
        std::cerr << "Invalid day: " << std::to_string(d) << std::endl; 
        exit(1);
    }
}

// DEFAULT constructor constructs the start of Unix epoch
Date::Date() : Date(1970, JAN, 1) { }

std::string Date::to_string() const {
    return std::to_string(year) + " "
         +    ::to_string(month) + " "
         + std::to_string(day);
} 

// Add to date just duplicates this object,
//   adds to it, and returns it
Date Date::operator+(int days) {
    Date d{*this};
    d += days;
    return d;
}

Date& Date::operator+=(int days) {
    day += days;
    while(day > days_in_month[month]) {
        day -= days_in_month[month++];
        if (month == JAN) year++;
    }
    return *this;
}

// Implement the comparison operators using a PRIVATE method
// compare returns -1 if this<rhs, 0 of this==rhs, and 1 if this>rhs
int Date::compare(const Date& rhs) {
    if(year <rhs.year ) return -1;
    if(year >rhs.year ) return  1;
    if(month<rhs.month) return -1;
    if(month>rhs.month) return  1;
    if(day  <rhs.day  ) return -1;
    if(day  >rhs.day  ) return  1;
    return 0;   
}

// Implement the FUNCTION that overloads the << operator for type Date
std::ostream& operator<<(std::ostream& ost, const Date& date) {
    ost << date.to_string();
    return ost;
}
// Implement the FUNCTION that overloads the >> operator for type Date
std::istream& operator>>(std::istream& ist, Date& date) {
    int year, day;
    Month month;
    if (ist >> year >> month >> day) date = Date{year, month, day};
    return ist;
}

// //////////////////////   MONTH   ///////////////////////

Month& operator++(Month& m) {      // Pre-increment
    /* The down-and-dirty approach
    m = (month)(((int)m+1)%12);
    return m;
    */
    // The proper approach
    switch(m) {
        case JAN: m = FEB; return m;
        case FEB: m = MAR; return m;
        case MAR: m = APR; return m;
        case APR: m = MAY; return m;
        case MAY: m = JUN; return m;
        case JUN: m = JUL; return m;
        case JUL: m = AUG; return m;
        case AUG: m = SEP; return m;
        case SEP: m = OCT; return m;
        case OCT: m = NOV; return m;
        case NOV: m = DEC; return m;
        case DEC: m = JAN; return m;
    }
    // Handle the "impossible" case. "out_of_range" is an "exception".
    // We'll cover those soon - trust me for now.
    throw std::out_of_range("Invalid month: " + std::to_string((int)m));
}
Month  operator++(Month& m, int) { // Post-increment
    switch(m) {
        case JAN: m = FEB; return JAN;
        case FEB: m = MAR; return FEB;
        case MAR: m = APR; return MAR;
        case APR: m = MAY; return APR;
        case MAY: m = JUN; return MAY;
        case JUN: m = JUL; return JUN;
        case JUL: m = AUG; return JUL;
        case AUG: m = SEP; return AUG;
        case SEP: m = OCT; return SEP;
        case OCT: m = NOV; return OCT;
        case NOV: m = DEC; return NOV;
        case DEC: m = JAN; return DEC;
    }
    throw std::out_of_range("Invalid month: " + std::to_string((int)m));
}
Month& operator--(Month& m) {      // Pre-decrement
    switch(m) {
        case JAN: m = DEC; return m;
        case FEB: m = JAN; return m;
        case MAR: m = FEB; return m;
        case APR: m = MAR; return m;
        case MAY: m = APR; return m;
        case JUN: m = MAY; return m;
        case JUL: m = JUN; return m;
        case AUG: m = JUL; return m;
        case SEP: m = AUG; return m;
        case OCT: m = SEP; return m;
        case NOV: m = OCT; return m;
        case DEC: m = NOV; return m;
    }
    throw std::out_of_range("Invalid month: " + std::to_string((int)m));
}
Month  operator--(Month& m, int) { // Post-decrement
    switch(m) {
        case JAN: m = DEC; return JAN;
        case FEB: m = JAN; return FEB;
        case MAR: m = FEB; return MAR;
        case APR: m = MAR; return APR;
        case MAY: m = APR; return MAY;
        case JUN: m = MAY; return JUN;
        case JUL: m = JUN; return JUL;
        case AUG: m = JUL; return AUG;
        case SEP: m = AUG; return SEP;
        case OCT: m = SEP; return OCT;
        case NOV: m = OCT; return NOV;
        case DEC: m = NOV; return DEC;
    }
    throw std::out_of_range("Invalid month: " + std::to_string((int)m));
}

std::string to_string(Month month) {
    return v[month];
}

// Implement the FUNCTION that overloads the << operator for type Month
std::ostream& operator<<(std::ostream& ost, Month month) {
    ost << to_string(month);  // Note: Do NOT include a newline or endl
    return ost;
}

// Implement the FUNCTION that overloads the >> operator for type Month
std::istream& operator>>(std::istream& ist, Month& month) {
    std::string s;
    ist >> s;

    // If 1 or 2 chars, assume an int between 1 and 12
    // If out of range, std::stoi will abort ("invalid argument" exception)
    // If out of range, v.at will abort ("out_of_range" exception)
    if(0 < s.size() && s.size() < 3) s = v.at(std::stoi(s)-1);
    
    // Coerce the data down to 3 upper-case chars
    s.resize(3); // Force s to be 3 chars long (for e.g., "March")
    for(char& c : s) c = toupper(c);
    
    // Data validation - We use m.at(s) instead of m[s] because m.at(s)
    //   aborts ("out_of_range" exception) if s is invalid
    month = m.at(s);
    return ist;
}



