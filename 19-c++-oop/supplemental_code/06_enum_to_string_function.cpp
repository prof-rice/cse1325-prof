#include <iostream>
#include <vector>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::string to_string(Month month) {
    std::vector<std::string> v = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    return v[month];
}

enum Size {SMALL, MEDIUM, LARGE};
std::string to_string(Size size) {
    std::vector<std::string> v = {"Small", "Medium", "Large"};
    return v[size];
}

int main() {
    Month month = JUL;
    Size size = MEDIUM;
    std::cout << to_string(month) << std::endl;
    std::cout << to_string(size) << std::endl;
}
