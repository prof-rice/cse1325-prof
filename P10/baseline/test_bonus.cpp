// WARNING: This test will NOT work at the Extreme Bonus level!

#include "purse.h"

#include <sstream>
#include <iostream>

int main(int argc, char* argv[]) {
    bool verbose = false;
    if(argc > 1) {
        std::string arg1{argv[1]};
        if(arg1 == "-h") {
            std::cout << "usage: " << argv[0] << " [-v]" << std::endl;
            return 0;
        } else if (arg1 == "-v") {
            verbose = true;
        } else {
            std::cerr << "illegal option: " << arg1 << std::endl;
            return -1;
        }
    }
    
    int result = 0;
    int vector = 1;
    
    Purse expected;
    Purse actual;
    
    // ========================================================================
    // Operator >>
    if(verbose) std::cout << "#### Testing Operator >>\n\n";
    
    // Default constructor
    {
        expected = Purse{2, 17, 10};
        std::istringstream iss{"#2 17s10d "};
        iss >> actual;
        if(iss.fail()) {
            std::cerr << "FAIL: Input stream failed\n";
            result |= vector;
        }
        if(iss.bad()) {
            std::cerr << "FAIL: Input stream went bad\n";
            result |= vector;
        }
        if(iss.eof()) {
            std::cerr << "FAIL: End of file on input stream\n";
            result |= vector;
        }
        if(actual != expected) {
            std::cerr << "FAIL: Streaming in operator >>\n" 
                      << "    Expected: " << expected << "\n"
                      << "    Actual:   " << actual   << std::endl;
            result |= vector;
        }
    }
    if(result != 0) 
        std::cerr << "FAIL: Error code " << result << std::endl;
    return result;
}
