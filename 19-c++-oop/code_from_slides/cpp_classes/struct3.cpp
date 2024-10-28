#include <iostream>
#include <exception>

struct Date {
    int year, month, day;
    Date(int year, int month, int day) {
        if (1 > month || month > 12) throw std::runtime_error{"Invalid month"};
        if (1 > day   ||   day > 31) throw std::runtime_error{"Invalid day"};
        this->year = year;
        this->month = month;
        this->day = day;
    }
};

int main() {
    Date birthday{1950, 12, 30};
    birthday.month = 14;
    std::cout << birthday.month << '/' 
              << birthday.day   << '/' 
              << birthday.year  << std::endl;
}
