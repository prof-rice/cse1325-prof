#include <iostream> // which includes <string>

enum Month {JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC};

std::string to_string[12] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                             "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

// QUESTION: Does our to_string SHADOW std::to_string? 
//   Or is this a naming conflict?  Let's explore!

// Let's roll back to, and modify, 20_test_shadow.cpp - using arrays.
// to_string array in main now SHADOWS our to_string array in global above,
//   because they have the SAME NAME in the SAME NAMESPACE but in NESTED SCOPES.

int main() {
   std::string to_string[12] = {"January", "February", "March",
                                "April", "May", "June",
                                "July", "August", "September",
                                "October", "November", "December"};
    std::cout << std::to_string(1970) + ' ' 
               +      to_string[JAN] + ' '
               + std::to_string(1) << std::endl;
}
