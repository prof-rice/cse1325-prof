#include <iostream> // which includes <string>

// Copy std::to_string to the local namespace
using std::to_string;

enum Month {JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC};

std::string to_string(Month month) {
    std::string months[12] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return months[(int)month];
}

// QUESTION: Does our to_string SHADOW std::to_string? 
//   Or is this a naming conflict?  Let's explore!

// Let's play troublemaker and move them into the same namespace.
// STILL, to_string *function* does NOT shadow std::to_string,
//   and NO naming conflict,
//   because our to_string has a different PARAMETRIC SIGNATURE than std's to_string

int main() {
    std::cout <<      to_string(1970) + ' ' 
               +      to_string(JAN) + ' '
               +      to_string(1) << std::endl;
}
