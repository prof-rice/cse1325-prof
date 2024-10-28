#include <iostream>
#include <vector>
#include <map>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month) {
    std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return v[month];
}

class Date {
    int year;
    Month month;
    int day;
  public:
    Date(int y, Month m, int d) {
        if (d<1 || d>31) std::cerr << "ERROR: Invalid day" << std::endl;
        day = d;
        month = m;
        year = y;
    }
    std::string to_string() {
        return std::to_string(year) + " "
             +    ::to_string(month) + " "
             + std::to_string(day);
    } 
};

int main() {
    Date moon{1969, JUL, 20};
    // Date space{12, APR, 1961}; // Runtime: "Invalid day: 1961"
    std::cout << moon.to_string() << std::endl;
    // std::cout << space.to_string() << std::endl << std::endl;
    // ++moon.day; // Compiler: "error: ‘int Date::day’ is private"
    // ++space.day;
    // std::cout << to_string(moon) << std::endl;
    // std::cout << to_string(space) << std::endl;
}
