#include <iostream>
#include <vector>

int main() {
    std::vector<std::string>* v = new std::vector<std::string>
        {"This", "will", "end", "badly"};
    for(auto s : *v) std::cout << s << ' '; 
    std::cout << std::endl;

    // C++-style static cast - generates a compile error even with pointers
    // Disaster avoided!
    std::string* s = static_cast<std::string*>(v);
    std::cout << *s << std::endl;
}
