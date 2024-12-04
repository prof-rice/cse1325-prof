#include "dvector.h"
#include <iostream>

typedef std::string Name;
typedef int Age;

int main() {
    Name name;
    Age age;
    DVector<Name, Age> ages;

    while(true) {
        std::cout << "Name? "; 
        std::getline(std::cin, name);
        if(name.empty()) break;

        std::cout << "Age? ";
        std::cin >> age; std::cin.ignore();

        ages.push_back(name, age);
    }

    for(int i=ages.size()-1; i>=0; --i) {
        std::cout << ages.at1(i) << " is "
                  << ages.at2(i) << " years old" << std::endl;
    }
}
