#include <iostream>
#include <vector>
#include "17_date.h"

Date::Date(int y, Month m, int d) : year{y}, month{m}, day{d} {
    if (31 < d || d < 1) {
        std::cerr << "Invalid day: " << std::to_string(d) << std::endl; 
        exit(1);
    }
}
std::string Date::to_string() {
    return std::to_string(year) + " "
         +    ::to_string(month) + " "
         + std::to_string(day);
} 

std::string to_string(Month month) {
    std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return v[month];
}


