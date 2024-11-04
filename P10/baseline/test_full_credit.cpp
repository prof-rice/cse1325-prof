// This test should pass at the Full Credit, Bonus, and BOTH Extreme Bonus levels
// Use the -v argument to show which class features are being tested,
//   so you can use it to test each operator as you write it
//   and ignore errors from operators you have not yet written.

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
    
    std::string expected;
    std::string actual;
    
    // ========================================================================
    // Constructors and operator <<
    if(verbose) std::cout << "#### Testing Constructors and operator <<\n\n";
    
    // Default constructor
    {
        std::string expected1 = "£0";
        std::string expected2 = "£0 0s0d";
        
        std::ostringstream oss;
        Purse purse;
        oss << purse;
        actual = oss.str();
        if(actual != expected1 && actual != expected2) {
            std::cerr << "FAIL: Default constructor or operator <<\n" 
                      << "    Expected: " << expected1 << "\n"
                      << "          or  " << expected2 << "\n"
                      << "    Actual:   " << actual   << std::endl;
            result |= vector;
        }
    }
    
    // Rational constructor
    {
        expected = "£3 4s5d";
        std::ostringstream oss;
        Purse purse{3, 4 , 5};
        oss << purse;
        actual = oss.str();
        if(actual != expected) {
            std::cerr << "FAIL: Default constructor or operator <<\n" 
                      << "    Expected: " << expected << "\n"
                      << "    Actual:   " << actual   << std::endl;
            result |= vector;
        }
    }
    
    // Irrational constructor
    {
        expected = "£12 13s6d";
        std::ostringstream oss;
        Purse purse{10, 52, 18};
        oss << purse;
        actual = oss.str();
        if(actual != expected) {
            std::cerr << "FAIL: Default constructor or operator <<\n" 
                      << "    Expected: " << expected << "\n"
                      << "    Actual:   " << actual   << std::endl;
            result |= vector;
        }
    }
    vector <<= 1;
    
    // ========================================================================
    // Comparison operators
    if(verbose) std::cout << "#### Testing Comparison operators\n\n";
    
    {
        Purse p0{2, 3, 5};
        Purse p0_2{2, 3, 5};
        Purse p1{2, 3, 6};
        Purse p2{2, 4, 2};
        Purse p3{3, 2, 1};
        Purse p3_2{3, 2, 1};
        
        if(!(p0 == p0_2)) {
            std::cerr << "FAIL: operator ==\n" 
                      << "    Expected: " << p0 << " == " << p0_2 << std::endl;
            result |= vector;
        }
        if(!(p0 != p1)) {
            std::cerr << "FAIL: operator !=\n" 
                      << "    Expected: " << p0 << " != " << p1 << std::endl;
            result |= vector;
        }
        if(!(p0 < p1)) {
            std::cerr << "FAIL: operator <\n" 
                      << "    Expected: " << p0 << " < " << p1 << std::endl;
            result |= vector;
        }
        if(!(p0 <= p1)) {
            std::cerr << "FAIL: operator <=\n" 
                      << "    Expected: " << p0 << " <= " << p1 << std::endl;
            result |= vector;
        }
        if(!(p0 <= p0_2)) {
            std::cerr << "FAIL: operator <=\n" 
                      << "    Expected: " << p0 << " <= " << p0_2 << std::endl;
            result |= vector;
        }
        if(!(p3 > p2)) {
            std::cerr << "FAIL: operator >\n" 
                      << "    Expected: " << p3 << " > " << p2 << std::endl;
            result |= vector;
        }
        if(!(p3 >= p2)) {
            std::cerr << "FAIL: operator >=\n" 
                      << "    Expected: " << p3 << " >= " << p2 << std::endl;
            result |= vector;
        }
        if(!(p3 >= p3_2)) {
            std::cerr << "FAIL: operator >=\n" 
                      << "    Expected: " << p3 << " >= " << p3_2 << std::endl;
            result |= vector;
        }
    }
    vector <<= 1;
    
    // ========================================================================
    // Pre- and Post-increment
    if(verbose) std::cout << "#### Testing Pre- and Post-increment\n\n";
    
    {
        Purse p1 {7, 19, 11};
        Purse p2 {8,  0,  0};
        Purse p3 {8,  0,  1};
        
        if(++p1 != p2) {
            std::cerr << "FAIL: pre-increment ++\n" 
                      << "    Expected: " << p2 << "\n"
                      << "    Actual:   " << p1 << std::endl;
            result |= vector;
        }
        Purse p1_2 = p1++;
        if(p1_2 != p2) {
            std::cerr << "FAIL: post-increment ++ returned value\n" 
                      << "    Expected: " << p2 << "\n"
                      << "    Actual:   " << p1_2 << std::endl;
            result |= vector;
        }
        if(p1 != p3) {
            std::cerr << "FAIL: post-increment ++ final value\n" 
                      << "    Expected: " << p3 << "\n"
                      << "    Actual:   " << p1 << std::endl;
            result |= vector;
        }
    }
    vector <<= 1;
    
    // ========================================================================
    // Addition and Subtraction
    if(verbose) std::cout << "#### Testing Addition and Subtraction\n\n";
    
    {
        Purse p1 {4, 11,  8};
        Purse p2 {3, 13,  5};
        Purse p3 {8,  5,  1};
        
        Purse p4 = p1 + p2;
        if(p4 != p3) {
            std::cerr << "FAIL: Addition\n" 
                      << "    Expected: " << p3 << "\n"
                      << "    Actual:   " << p4 << std::endl;
            result |= vector;
        }
        Purse p5 = p3 - p2;
        if(p5 != p1) {
            std::cerr << "FAIL: Subtraction\n" 
                      << "    Expected: " << p1 << "\n"
                      << "    Actual:   " << p5 << std::endl;
            result |= vector;
        }
    }
    vector <<= 1;
    
    // ========================================================================
    // Compound Addition and Subtraction
    if(verbose) std::cout << "#### Testing Compound Addition and Subtraction\n\n";
    
    {
        Purse p1 {4, 11,  8};
        Purse p2 {3, 13,  5};
        Purse p3 {8,  5,  1};
        Purse p4 {p1};
        
        p1 += p2;
        if(p1 != p3) {
            std::cerr << "FAIL: Compound addition\n" 
                      << "    Expected: " << p3 << "\n"
                      << "    Actual:   " << p1 << std::endl;
            result |= vector;
        }
        p1 -= p2;
        if(p1 != p4) {
            std::cerr << "FAIL: Compound subtraction\n" 
                      << "    Expected: " << p4 << "\n"
                      << "    Actual:   " << p1 << std::endl;
            result |= vector;
        }
    }
    vector <<= 1;
    
    if(result != 0) 
        std::cerr << "FAIL: Error code " << result << std::endl;
    return result;
}
