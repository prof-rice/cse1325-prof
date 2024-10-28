#include <ostream>
#include "32_person.h"

Person::Person(std::string name) : _name{name} { }

std::string Person::to_string() const {return _name;}

