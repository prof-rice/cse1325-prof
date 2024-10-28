#include <iostream>
#include <vector>
#include <map>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month) {
    std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return v[month];
}

struct Date {
    int year;
    Month month;
    int day;
};
std::string to_string(Date date) {
    return std::to_string(date.year) + " "
         +      to_string(date.month) + " "
         + std::to_string(date.day);
} 

int main() {
    Date moon{1969, JUL, 20};
    Date space{12, APR, 1961};
    std::cout << to_string(moon) << std::endl;
    std::cout << to_string(space) << std::endl << std::endl;
    ++moon.day;
    ++space.day;
    std::cout << to_string(moon) << std::endl;
    std::cout << to_string(space) << std::endl;
}
