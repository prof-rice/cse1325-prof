#include <iostream>
#include "02_date.h"

int main() {
    // stream a month to std::cout using operator<<
    Month m;
    std::cout << "Enter a month (3-chars): ";
    std::cin >> m;
    std::cout << "Welcome to " << m << std::endl;
}
