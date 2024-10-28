#ifndef __PERSON_H
#define __PERSON_H

#include <ostream>
#include "logger.h"

class Person {
  public:
    Person(std::string name);
    virtual std::string to_string() const;
    friend std::ostream& operator<<(std::ostream& ost, const Person& person);
  protected:
    std::string _name;
};
#endif
