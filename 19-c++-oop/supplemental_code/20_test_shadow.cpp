#include <iostream> // which includes <string>

enum Month {JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC};

std::string to_string[12] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                             "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

// QUESTION: Does our to_string SHADOW std::to_string? 
//   Or is this a naming conflict?  Let's explore!

// to_string array does NOT shadow std::to_string,
//   first, because arrays cannot shadow functions
// NO naming conflict,
//   first, because std::to_string is in std:: rather than local namespace

int main() {
    std::cout << std::to_string(1970) + ' ' 
               +      to_string[JAN] + ' '
               + std::to_string(1) << std::endl;
}
