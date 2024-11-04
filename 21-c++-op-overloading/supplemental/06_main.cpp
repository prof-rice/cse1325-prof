#include <iostream>
#include "06_date.h"

int main() {
    // stream a month to std::cout using operator<<
    Date d1;
    int days;
    std::cout << "Enter date 1 (YYYY Mon DD): ";
    std::cin >> d1;
    while(true) {
        std::cout << "Enter days to advance: ";
        if(!(std::cin >> days)) break;
        d1 += days;
        std::cout << d1 << std::endl;
    }
}
