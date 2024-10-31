#include <iostream>
#include <vector>

int main(int argc, char* argv[]) {
    std::vector<std::string> numbers;
    std::vector<std::string>* words = new std::vector<std::string>{};
    
    for(int i=1; i<argc; ++i) {
        std::string s{argv[i]};
        if(isdigit(s[0])) numbers.push_back(s);
        else words->push_back(s);
        // (*words).push_back(s);
    }
    
    std::cout << "Numbers:\n";
    for(auto s : numbers) std::cout << s << '\n';
    std::cout << "\n\n";
    
    std::cout << "Words:\n";
    for(auto s : *words) std::cout << s << '\n';
    std::cout << "\n\n";
}
    
