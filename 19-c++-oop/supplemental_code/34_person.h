#ifndef __PERSON_H
#define __PERSON_H

#include <ostream>
#include "logger.h"

class Person {
  public:
    Person(std::string name);
    virtual std::string to_string() const;
  protected:
    std::string _name;
};
#endif
