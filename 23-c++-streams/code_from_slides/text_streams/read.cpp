#include <iostream>
#include <fstream>

int main(int argc, char* argv[]) {
    std::ifstream ist{std::string{argv[1]}};	
    if (!ist) throw std::runtime_error{"can’t open input file"};

    std::string s;
    while (std::getline(ist, s)) std::cout << s << std::endl;
}
