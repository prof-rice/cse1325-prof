#include <iostream>
#include "17_date.h"

int main() {
    Date moon{1969, JUL, 20};
    Date space{1961, APR, 12};
    std::cout << moon.to_string() << std::endl;
    std::cout << space.to_string() << std::endl;
}
