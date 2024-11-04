#include <iostream>
#include "03_date.h"

int main() {
    // stream a month to std::cout using operator<<
    Date d;
    std::cout << "Enter a date (YYYY Mon DD): ";
    std::cin >> d;
    std::cout << "Welcome to " << d << std::endl;
}
