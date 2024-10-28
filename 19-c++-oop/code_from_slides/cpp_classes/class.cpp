#include <iostream>
#include <exception>

class Date {
  public:
    Date(int year, int month, int day) 
        : year{year}, month{month}, day{day} {
        if (1 > month || month > 12) throw std::runtime_error{"Invalid month"};
        if (1 > day   ||   day > 31) throw std::runtime_error{"Invalid day"};
    }
    void print_date() {
        std::cout << month << '/' << day << '/' << year << std::endl;
    }
  private:
    int year, month, day;
};

int main() {
    Date birthday{1950, 12, 30};
    //birthday.month = 14;   // ERROR: Private Data!
    birthday.print_date();
}
