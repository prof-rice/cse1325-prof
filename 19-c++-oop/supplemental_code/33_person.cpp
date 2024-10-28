#include <ostream>
#include "33_person.h"

Person::Person(std::string name) : _name{name} {LOG("Person::Person(" + name + ")");}

std::string Person::to_string() const {return _name;}

