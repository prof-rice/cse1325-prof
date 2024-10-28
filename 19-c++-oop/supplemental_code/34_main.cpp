#include <iostream>
#include "34_student.h"
#include <vector>

int main() {
    std::vector<Person*> people;
    people.push_back(new Person{"Professor Rice"});
    people.push_back(new Student{"Encyclopedia Brown", 4.0});
    for(Person* p : people) 
        std::cout << p->to_string() << std::endl;
}

