#include <iostream>
#include <bitset>
 
int main()
{
    // Create and manipulate a 16-bit bitset
    std::bitset<16> bitset1;
    std::cout << "Default 16-bit constructor: " << bitset1 << std::endl;

    bitset1.set();
    std::cout << "After set(): " << bitset1 << std::endl;

    for (int i=0; i<bitset1.size(); i+= 2) bitset1.reset(i);
    std::cout << "After resetting even bits: " << bitset1 << std::endl;

    bitset1.flip();
    std::cout << "After flipping bits: " << bitset1 << std::endl;

    for (int i=0; i<bitset1.size(); i+= 3) {
        std::cout << "Bit " << i << " is " 
                  << (bitset1[i] ? "set" : "reset") // or use bitset1.test(i)
                  << std::endl; 
    }
    std::cout << bitset1.count() << " bits are now set" 
              << std::endl << std::endl;
 
    // Create a 32-bit bitset with explicit initialization
    std::bitset<32> bitset2{0xFEEDFACE};
    std::cout << "Initialized 32-bit constructor:" << bitset2 << std::endl;
 
    // Create a 13-bit bitset with string initialization
    std::bitset<13> bitset3(std::string("1001110100101"));
    std::cout << "String-initialized 13-bit constructor:" << bitset3 << std::endl;
 
}
