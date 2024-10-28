#ifndef __STUDENT_H
#define __STUDENT_H

#include <ostream>
#include "40_person.h"

class Student : public Person {
  public:
    Student(std::string name, double gpa);
    std::string to_string() const override;
    friend std::ostream& operator<<(std::ostream& ost, const Student& student);
  private:
    double _gpa;
};
#endif
