#include <ostream>
#include "41_person.h"

Person::Person(std::string name) : _name{name} {LOG("Person::Person(" + name + ")");}

// std::string Person::to_string() const {return _name;}

std::ostream& operator<<(std::ostream& ost, const Person& person) {
    ost << person._name;
    return ost;
}

