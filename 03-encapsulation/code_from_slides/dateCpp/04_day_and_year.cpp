#include <iostream>

enum Month {January =  1, February =  2, March     =  3, 
            April   =  4, May      =  5, June      =  6, 
            July    =  7, August   =  8, September =  9, 
            October = 10, November = 11, December  = 12};
std::string to_string[13] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                 "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
struct Date {
    int year;
    Month month;
    int day;
};

int main() {
    Date birthday{1950, December, 30};  // Not mine!
    std::cout << birthday.month << '/' 
              << birthday.day   << '/' 
              << birthday.year  << std::endl;
}
