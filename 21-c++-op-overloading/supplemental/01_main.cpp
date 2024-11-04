#include <iostream>
#include "01_date.h"

int main() {
    // stream a month to std::cout using operator<<
    Month m{DEC};
    std::cout << m << std::endl;
    
    Date moon{1969, JUL, 20};
    Date space{1961, APR, 12};
    std::cout << moon.to_string() << std::endl;
    std::cout << space.to_string() << std::endl;
}
