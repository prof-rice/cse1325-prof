#include "month.h"

#include <map>
#include <regex>
#include <algorithm>

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
*/

// Stream in a month object
static const std::map<Month, std::regex> month_records {
    {Month::Jan, std::regex{R"(([Jj]an(uary)?(,)?)|(0)?1(,)?)"}},
    {Month::Feb, std::regex{R"(([Ff]eb(uary)?(,)?)|(0)?2(,)?)"}},
    {Month::Mar, std::regex{R"(([Mm]ar()ch?(,)?)|(0)?3(,)?)"}},
    {Month::Apr, std::regex{R"(([Aa]pr(il)?(,)?)|(0)?4(,)?)"}},
    {Month::May, std::regex{R"(([Mm]ay(,)?)|(0)?5(,)?)"}},
    {Month::Jun, std::regex{R"(([Jj]un(e)?(,)?)|(0)?6(,)?)"}},
    {Month::Jul, std::regex{R"(([Jj]ul(y)?(,)?)|(0)?7(,)?)"}},
    {Month::Aug, std::regex{R"(([Aa]ug(ust)?(,)?)|(0)?8(,)?)"}},
    {Month::Sep, std::regex{R"(([Ss]ep(tember)?(,)?)|(0)?9(,)?)"}},
    {Month::Oct, std::regex{R"(([Oo]ct(ober)?(,)?)|10(,)?)"}},
    {Month::Nov, std::regex{R"(([Nn]ov(ember)?(,)?)|11(,)?)"}},
    {Month::Dec, std::regex{R"(([Dd]ec(ember)?(,)?)|12(,)?)"}},
};
std::istream& operator>>(std::istream& is, Month& month) {
  std::string s; is >> s;
  for(auto& [mon, rx] : month_records) {
      if (std::regex_match(s, rx)) {
          month = mon; 
          s.clear(); 
          break;
      }
  }
  if (!s.empty()) 
      throw std::runtime_error{"Invalid month: " + s};
  return is;
}
/*
  // The vector approach
  std::vector<month_record> month_records =
  {
      {std::regex{R"(([Jj]an(uary)?(,)?)|(0)?1(,)?)"},   Month::Jan},
      {std::regex{R"(([Ff]eb(uary)?(,)?)|(0)?2(,)?)"},   Month::Feb},
      {std::regex{R"(([Mm]ar()ch?(,)?)|(0)?3(,)?)"},     Month::Mar},
      {std::regex{R"(([Aa]pr(il)?(,)?)|(0)?4(,)?)"},     Month::Apr},
      {std::regex{R"(([Mm]ay(,)?)|(0)?5(,)?)"},          Month::May},
      {std::regex{R"(([Jj]un(e)?(,)?)|(0)?6(,)?)"},      Month::Jun},
      {std::regex{R"(([Jj]ul(y)?(,)?)|(0)?7(,)?)"},      Month::Jul},
      {std::regex{R"(([Aa]ug(ust)?(,)?)|(0)?8(,)?)"},    Month::Aug},
      {std::regex{R"(([Ss]ep(tember)?(,)?)|(0)?9(,)?)"}, Month::Sep},
      {std::regex{R"(([Oo]ct(ober)?(,)?)|10(,)?)"},      Month::Oct},
      {std::regex{R"(([Nn]ov(ember)?(,)?)|11(,)?)"},     Month::Nov},
      {std::regex{R"(([Dd]ec(ember)?(,)?)|12(,)?)"},     Month::Dec},
  };

  std::string s; 
  is >> s;
  for(auto mr : month_records) {
      if (std::regex_match(s, mr.rx)) {
          month = mr.month; 
          s.clear(); 
          break;
      }
  }
  if (!s.empty()) 
      throw std::runtime_error{"Invalid month: " + s};
  return is;
}
// Enums are ordered, and so comparison operators are pre-defined

*/

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


