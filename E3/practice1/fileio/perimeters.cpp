#include <iostream>
#include <fstream>
#include <sstream>

int main(int argc, char* argv[]) {
    if(argc != 2) {
        std::cerr << "usage: " << argv[0] << " <filename>" << std::endl;
        return -1;
    }
    std::ifstream ifs{std::string{argv[1]}};
    if(!ifs) {
        std::cerr << "Open failed" << std::endl;
        return -2;
    }
    std::string line;
    std::string name;
    int side;
    while(std::getline(ifs, line)) {
        std::istringstream iss{line};
        iss >> name;
        int sum = 0;
        while(iss >> side) sum += side;
        std::cout << name << ": " << sum << std::endl;
    }
    if(!ifs.eof()) std::cerr << "Bad data file" << std::endl;
}
