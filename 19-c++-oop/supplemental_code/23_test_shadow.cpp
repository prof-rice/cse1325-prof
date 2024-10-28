#include <iostream> // which includes <string>

// Copy std::to_string to the local namespace
using std::to_string;

enum Month {JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC};

std::string to_string(int month) {
    std::string months[12] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return months[month-1];
}

// QUESTION: Does our to_string SHADOW std::to_string? 
//   Or is this a naming conflict?  Let's explore!

// Let's specify the month in our to_string by an int rather than a Month.
// Rather than shadowing std::to_string, NOW we have a NAMING CONFLICT,
//   because our to_string has THE SAME parametric signature as std's to_string,
//   and they are in the same namespace.

int main() {
    std::cout <<      to_string(1970) + ' ' 
               +      to_string(JAN) + ' '
               +      to_string(1) << std::endl;
}
