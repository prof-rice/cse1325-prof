#include <set>
#include <iostream>

int main(int argc, char* argv[]) {
    std::set<std::string> words;
    for(int i=1; i<argc; ++i)
        words.insert(std::string{argv[i]});
    std::cout << "Here are the unique arguments in alphabetical order:" << std::endl;
    for(auto word : words)
        std::cout << "  " << word << std::endl;
}

