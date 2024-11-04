#include "month.h"

#include <map>

// ///////////////////////////////////////////////////////////
// Stream I/O Operators

// Stream out a Month object

const static std::map<Month, std::string> month_to_string {
    {Month::Jan, "January"},  {Month::Feb, "February"},  {Month::Mar, "March"},
    {Month::Apr, "April"},    {Month::May, "May"},       {Month::Jun, "June"},
    {Month::Jul, "July"},     {Month::Aug, "August"},    {Month::Sep, "September"},
    {Month::Oct, "October"},  {Month::Nov, "November"},  {Month::Dec, "December"},
};
    
std::ostream& operator<<(std::ostream& ost, const Month& month) {
    return ost << month_to_string.at(month); // throws std::out_of_range if invalid
}
/*

// The non-map approach
std::ostream& operator<<(std::ostream& ost, const Month& month) {
    if(month == Month::Jan) ost << "January";
    if(month == Month::Feb) ost << "February";
    if(month == Month::Mar) ost << "March";
    if(month == Month::Apr) ost << "April";
    if(month == Month::May) ost << "May";
    if(month == Month::Jun) ost << "June";
    if(month == Month::Jul) ost << "July";
    if(month == Month::Aug) ost << "August";
    if(month == Month::Sep) ost << "September";
    if(month == Month::Oct) ost << "October";
    if(month == Month::Nov) ost << "November";
    if(month == Month::Dec) ost << "December";
    return ost;
}

// OR

std::ostream& operator<<(std::ostream& ost, const Month& month) {
    switch(month) {
        case Month::Feb: ost << "February"; break;
        case Month::Mar: ost << "March"; break;
        case Month::Apr: ost << "April"; break;
        case Month::May: ost << "May"; break;
        case Month::Jun: ost << "June"; break;
        case Month::Jul: ost << "July"; break;
        case Month::Aug: ost << "August"; break;
        case Month::Sep: ost << "September"; break;
        case Month::Oct: ost << "October"; break;
        case Month::Nov: ost << "November"; break;
        case Month::Dec: ost << "December"; break;
    }
    return ost;
}

*/

// Stream in a month object
const static std::map<std::string, Month> month_records = {
    {"jan", Month::Jan}, {"feb", Month::Feb}, {"mar", Month::Mar},
    {"apr", Month::Apr}, {"may", Month::May}, {"jun", Month::Jun},
    {"jul", Month::Jul}, {"aug", Month::Aug}, {"sep", Month::Sep},
    {"oct", Month::Oct}, {"nov", Month::Nov}, {"dec", Month::Dec},
};

std::istream& operator>>(std::istream& is, Month& month) {
  std::string s; is >> s;                    // Read a string
  if(isdigit(s[0])) {                        // Numeric?
      int index = stoi(s) - 1;                   //Convert to index
      if(index < 0 || index > 11)                // Verify range
          throw std::out_of_range{"Invalid month: " + s};
      month = (Month) index;                     // Set month
  } else {                                   // String?
      for(char& c : s) c = (char) tolower(c);    // Force all lower case
      month = month_records.at(s);               // Look up month (or throw)
  }
  return is;
}

// Enums are ordered, and so comparison operators are pre-defined


// ///////////////////////////////////////////////////////////
// Pre- and post-increment operators

Month& operator++(Month& m) {   // Pre-increment, e.g., ++m
  switch(m) {
    case Month::Jan: m = Month::Feb; break;
    case Month::Feb: m = Month::Mar; break;
    case Month::Mar: m = Month::Apr; break;
    case Month::Apr: m = Month::May; break;
    case Month::May: m = Month::Jun; break;
    case Month::Jun: m = Month::Jul; break;
    case Month::Jul: m = Month::Aug; break;
    case Month::Aug: m = Month::Sep; break;
    case Month::Sep: m = Month::Oct; break;
    case Month::Oct: m = Month::Nov; break;
    case Month::Nov: m = Month::Dec; break;
    case Month::Dec: m = Month::Jan; break;
  }
  return m;
}
Month operator++(Month& m, int) {  // Post-increment, e.g., m++
  Month result{m};
  ++m;
  return result;
}


