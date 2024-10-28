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
    switch (size) {
        case SMALL  : return "Small";
        case MEDIUM : return "Medium";
        case LARGE  : return "Large";
    }
    return "Unknown";
}

int main() {
    Month month = JUL;
    Size size = MEDIUM;
    std::cout << to_string(month) << std::endl;
    std::cout << to_string(size) << std::endl;
}
