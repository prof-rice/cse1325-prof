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

std::string date_to_string(Date date) {
    return std::to_string(date.year) + " "
         +      to_string[date.month] + " "
         + std::to_string(date.day);
} 


int main() {
    Date birthday{1950, December, 30};  // Not mine!
    std::cout << date_to_string(birthday)  << std::endl;
}
