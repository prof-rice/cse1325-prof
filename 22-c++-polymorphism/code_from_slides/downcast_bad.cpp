#include <iostream>
#include <vector>

int main() {
    std::vector<std::string> v{"This", "will", "end", "badly"};
    for(auto s : v) std::cout << s << ' '; 
    std::cout << std::endl;

    // C-style (unsafe) downcast – won't compile. C++ isn't THAT flexible!
    // std::string s = (std::string)(v);
    // std::cout << s << std::endl;
}
