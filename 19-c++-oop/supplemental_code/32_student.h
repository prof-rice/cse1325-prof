#ifndef __STUDENT_H
#define __STUDENT_H

#include <ostream>
#include "32_person.h"

class Student : public Person {
  public:
    Student(std::string name, double gpa);
    std::string to_string() const override;
  private:
    double _gpa;
};
#endif
