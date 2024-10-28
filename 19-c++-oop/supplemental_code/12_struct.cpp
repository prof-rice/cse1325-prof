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

int main() {
    Date date{1969, JUL, 20};
    std::cout << date.year << ' '
              << to_string(date.month) << ' '
              << date.day << std::endl;
}
