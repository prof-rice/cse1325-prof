#ifndef __MONTH_H
#define __MONTH_H

#include <iostream>

enum class Month {Jan, Feb, Mar, 
                  Apr, May, Jun,
                  Jul, Aug, Sep, 
                  Oct, Nov, Dec};

// Constructors are pre-defined for enum class objects

// Stream I/O operators
std::ostream& operator<<(std::ostream& ost, const Month& month);
std::istream& operator>>(std::istream& is,        Month& month); 

// comparison operators are predefined for enum classes

// Pre- and post-increment operators
Month& operator++(Month& m); // Pre-increment
Month  operator++(Month& m, int); // Post-increment (the parameter is ignored)

#endif
