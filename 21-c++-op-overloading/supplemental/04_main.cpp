#include <iostream>
#include "04_date.h"

int main() {
    // stream a month to std::cout using operator<<
    Date d1, d2;
    std::cout << "Enter date 1 (YYYY Mon DD): ";
    std::cin >> d1;
    std::cout << "Enter date 2 (YYYY Mon DD): ";
    std::cin >> d2;
    if(d1 == d2) std::cout << d1 << "==" << d2 << std::endl;
    if(d1 != d2) std::cout << d1 << "!=" << d2 << std::endl;
    if(d1 <  d2) std::cout << d1 << "< " << d2 << std::endl;
    if(d1 <= d2) std::cout << d1 << "<=" << d2 << std::endl;
    if(d1 >  d2) std::cout << d1 << "> " << d2 << std::endl;
    if(d1 >= d2) std::cout << d1 << ">=" << d2 << std::endl;
}
