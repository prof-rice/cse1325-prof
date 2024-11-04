#include "date.h"

int main() {
    Date date;
    while(std::cin) {
        std::cout << "\nEnter a valid date! (year month day): ";
        try {
            std::cin >> date;
            std::cout << "You entered " << date << std::endl;
        } catch(...) {
            std::cerr << "That wasn't a valid date!" << std::endl;
        }
    }
}

