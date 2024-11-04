#include <iostream>
#include <vector>
#include <map>
#include "04_date.h"

// Used for converting between Month and its string representation
const std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
const std::map<std::string, Month> m = {
    {"JAN", JAN}, {"FEB", FEB}, {"MAR", MAR}, {"APR", APR}, {"MAY", MAY}, {"JUN", JUN},
    {"JUL", JUL}, {"AUG", AUG}, {"SEP", SEP}, {"OCT", OCT}, {"NOV", NOV}, {"DEC", DEC}
};

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



