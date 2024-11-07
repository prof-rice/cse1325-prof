#include <iostream>
#include <vector>

int main() {
    std::vector<std::string>* v = new std::vector<std::string>
        {"This", "will", "end", "badly"};
    for(auto s : *v) std::cout << s << ' '; 
    std::cout << std::endl;

    // Evading C++-style static_cast's protection with void* (VERY bad idea!)
    void* v3 = v;
    std::string* s3 = static_cast<std::string*>(v3);
    std::cout << *s3 << std::endl;
}
