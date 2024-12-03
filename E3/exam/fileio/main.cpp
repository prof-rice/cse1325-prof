#include <map>
#include <iostream>
#include <fstream>

typedef std::string Location;
typedef int Population;

int main(int argc, char* argv[]) {
    if(argc < 2) {
        std::cerr << "Missing data file" << std::endl;
        return -3;
    }
    
    std::map<Location, Population> pop_map;
    
    std::ifstream ifs{std::string{argv[1]}};
    if(!ifs) {
        std::cerr << "Could not open " << argv[1] << std::endl;
        return -2;
    }
    
    Location location;
    Population population;
    while(std::getline(ifs, location, ':')) {
        ifs >> population; ifs.ignore();
        pop_map[location] = population;
    }
    
    if(!ifs.eof()) {
        std::cerr << "Error reading " << argv[1] << " after " << location << std::endl;
        return -1;
    }
    
    while(std::cin) {
        std::cout << "Enter city, ST: ";
        std::getline(std::cin, location);
        auto it = pop_map.find(location);
        if(it != pop_map.end())
            std::cout << location << " pop is " << it->second << std::endl;
        else
            std::cerr << location << " not found" << std::endl;
    }
}
