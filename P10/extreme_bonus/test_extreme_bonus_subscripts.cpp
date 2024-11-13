#include "purse.h"

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
    
    // ========================================================================
    // Constructors and operator <<
    if(verbose) std::cout << "#### Testing Subscripts\n\n";
    
    // Correct subscripts (OK to use # instead of £)
    {
        Purse purse{1, 5, 7};
        if(purse["£"] != 1 || purse["s"] != 5 || purse["d"] != 7) {
            std::cerr << "FAIL: Invalid subscript values\n" 
                      << "    Expected: 1  5  7\n"
                      << "    Actual:   " << purse["£"] << "  " 
                                          << purse["s"] << "  " 
                                          << purse["d"] << std::endl;
            result |= vector;
        }
    }
    // Incorrect subscripts
    {
        try {
            Purse purse{1, 5, 7};
            int incorrect = purse["p"];
            std::cerr << "FAIL: Invalid subscript returned result\n" 
                      << "    Expected: exception\n"
                      << "    Actual:   " << incorrect << std::endl;
                result |= vector;
        } catch(std::exception e) {
        }
    }
    if(result != 0) 
        std::cerr << "FAIL: Error code " << result << std::endl;
    return result;
}
