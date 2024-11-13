#include <algorithm>
#include <iterator>
#include <map>
#include <iostream>
#include <iomanip>

typedef std::string Last;
typedef std::string First;

int main() {
    std::map<Last, First> americans {
        {"Washington", "George"},
        {"Ginsburg", "Ruth Bader"},
        {"Muhammad", "Ibtihaj"},
        {"Turing", "Alan"},
        {"Bull", "Sitting"},
        {"Reagan", "Ronald"},
        {"Roosevelt", "Eleanor"},
        {"Anthony", "Susan B."},
        {"Carver", "George Washington"},
        {"Chavez", "Cesar"},
        {"Tubman", "Harriet"},
        {"Lincoln", "Abraham"},
        {"Jackson", "Ketanji Brown"},
        {"Einstein", "Albert"},
        {"Nadella", "Satya"},
        {"Curie", "Marie"},
        {"Ride", "Sally"},
        {"Su", "Lisa"},
    };
    const int per_line = 3;
    int people_counter = 0;
    for(auto& [last, first] : americans) {
        std::cout << std::left << std::setw(27) << (last + ", " + first)
            << ((++people_counter % per_line == 0) ? "\n" : "");
    }
    
    Last target;
    std::cout << "\nWho shall we find today (last name)? ";
    while(std::getline(std::cin, target)) {
        auto it = americans.find(target);
        if(it == americans.end()) 
            std::cout << target << " not found!\n\nNext? ";
        else 
            std::cout << it->second << " " << it->first << "\n\nNext? ";
    }
    std::cout << std::endl;
}
