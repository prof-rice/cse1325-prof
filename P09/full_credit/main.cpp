#include "clock.h"
#include <iostream>

int main(int argc, char* argv[]) {
    if(argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        exit(-1); // or return -1
    }
    std::string input;
    try {
        Clock clock{atoi(argv[1]), atoi(argv[2]), atoi(argv[3])};
        std::cout << "\nEnter 'q' to quit.\n" << std::endl;
        while(input != "q") {
            std::cout << "The time is now ";
            clock.print();
            std::getline(std::cin, input);
            clock.tic();
        }
    } catch (std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        std::cin.clear();            // clear any input errors
        std::cin.ignore(2048, '\n'); // clear input buffer - technically should be
        // std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        // std::getline(std::cin, input); // will do the same thing
        return -2; // or exit(-2)
    }
    // return 0; // if you prefer
}
