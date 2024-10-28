#include <iostream>

struct Date {
    int year, month, day;
};

int main() {
    Date birthday;
    birthday = {12, 30, 1950};
    std::cout << birthday.month << '/' 
              << birthday.day   << '/' 
              << birthday.year  << std::endl;
}
