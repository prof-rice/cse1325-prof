#include "date.h"
#include <iostream>

int main() {
    Month m{Month::Nov};
    std::cout << m++ << ' ' << m++ << ' ' 
              << m << ' ' 
              << ++m << ' ' << ++m << ' ' << std::endl;
     
    for (Month m=Month::Aug; m != Month::Feb ; ++m) std::cout << m << ' ';
    std::cout << std::endl;

    {
    Date d{1950, Month::Dec, 30};   // Wrap Dec -> Jan
    std::cout << d++ << ' ' << d++ << ' ' 
              << d << ' ' 
              << ++d << ' ' << ++d << ' ' << std::endl;
    } {
    Date d{1900, Month::Feb, 27};   // Not leap year (100 year rule)
    std::cout << d++ << ' ' << d++ << ' ' 
              << d << ' ' 
              << ++d << ' ' << ++d << ' ' << std::endl;
    } {
    Date d{2000, Month::Feb, 27};   // Leap year (400 year rule)
    std::cout << d++ << ' ' << d++ << ' ' 
              << d << ' ' 
              << ++d << ' ' << ++d << ' ' << std::endl;
    } {
    Date d{2001, Month::Feb, 27};     // Not leap year
    std::cout << d++ << ' ' << d++ << ' ' 
              << d << ' ' 
              << ++d << ' ' << ++d << ' ' << std::endl;
    } {
    Date d{2004, Month::Feb, 27};    // Leap year (4 year rule)
    std::cout << d++ << ' ' << d++ << ' ' 
              << d << ' ' 
              << ++d << ' ' << ++d << ' ' << std::endl;
    } {
    std::cout << "3-term for loop:" << std::endl;
    for (Date d{2004, Month::Feb, 27}; d < Date{2004, Month::Mar, 3}; ++d) {
        std::cout << d << ' ';
    }
    std::cout << std::endl;
    } {
    while(true) {
        Date d;
        try {
            std::cout << "Enter a starting date (day month, year): ";
            std::cin >> d;
            int n;
            while(true) {
                std::cout << "The date is now " << d << ", add how many days? ";
                std::cin >> n;
                if (n<=0) break;
                //d = d + n;
                //d = n + d;
                d += n;
            }
            break;
        } catch(std::runtime_error e) {
            std::cerr << e.what() << std::endl;
            std::cin.ignore(4096, '\n');
        }
    }
    }
}
