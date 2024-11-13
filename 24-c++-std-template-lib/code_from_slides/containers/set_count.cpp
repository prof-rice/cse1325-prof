#include <set>
#include <iostream>

int main(int argc, char* argv[]) {
    std::set<std::string> words;
    for(int i=1; i<argc; ++i)
        words.insert(std::string{argv[i]});

    std::string word;
    while(true) {
        std::cout << "Search for which word in arguments? ";
        std::cin >> word;
        if(word.empty()) break;
        std::cout << word << " is " << ((words.count(word) == 0) ? "not " : "")
                  << "in the argument list" << std::endl;
    }
}

