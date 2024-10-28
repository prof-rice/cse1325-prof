#include <iostream>
#include <exception>

struct Date {
    int year, month, day;
};

void init_date(Date& date, int year, int month, int day) {
    // For now, throw std::runtime_error{"Invalid month"};
    //   simply means "abort the program with that message"
    // We'll get to handling exceptions in useful ways soon enough
    if (1 > month || month > 12) throw std::runtime_error{"Invalid month"};
    if (1 > day   ||   day > 31) throw std::runtime_error{"Invalid day"};
    date.year = year;
    date.month = month;
    date.day = day;
}

int main() {
    Date birthday;
    init_date(birthday, 12, 30, 1950);
    std::cout << birthday.month << '/' 
              << birthday.day   << '/' 
              << birthday.year  << std::endl;
}
