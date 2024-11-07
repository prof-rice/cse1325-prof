#include <iostream>
#include <vector>

int main() {
    std::vector<std::string>* v = new std::vector<std::string>
        {"This", "will", "end", "badly"};
    for(auto s : *v) std::cout << s << ' '; 
    std::cout << std::endl;

    // C-style downcast with pointers – compiles! What could go wrong?
    std::string* s = (std::string*)(v);
    std::cout << *s << std::endl;
}
