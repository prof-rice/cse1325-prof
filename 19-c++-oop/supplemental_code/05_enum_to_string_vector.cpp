#include <iostream>
#include <vector>

enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
std::vector<std::string> to_string = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

int main() {
    Month month = JUL;
    std::cout << to_string[month] << std::endl;
}
