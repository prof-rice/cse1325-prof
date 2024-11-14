#include <algorithm>
#include <iostream>
#include <iomanip>
#include <vector>

int main() {
    // Fill an array
    std::vector<int> v;
    for(int i=0; i<20; ++i) v.push_back(i);
    std::cout << "Original:   ";
    for(auto i : v) std::cout << std::setw(3) << i;
    std::cout << std::endl;

    // Shuffle the ints randomly
    std::random_shuffle(v.begin(), v.end());
    std::cout << "Shuffled:   ";
    for(auto i : v) std::cout << std::setw(3) << i;
    std::cout << std::endl;

    // Sort them back into order
    std::sort(v.begin(), v.end());
    std::cout << "Sorted:     ";
    for(auto i : v) std::cout << std::setw(3) << i;
    std::cout << std::endl;

    // Sort first 25 elements in reverse order using lambda compare function
    // std::sort(v.begin(), v.begin()+10, [ ] (int lhs, int rhs) {return rhs < lhs;});
    // std::cout << "Rev sort ½: ";
    // for(auto i : v) std::cout << std::setw(3) << i;
    // std::cout << std::endl;
}
