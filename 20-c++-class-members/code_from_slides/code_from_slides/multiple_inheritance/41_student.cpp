#include <ostream>
#include "41_student.h"

Student::Student(std::string name, double gpa) : Person{name}, _gpa{gpa} {
LOG("Student::Student(" + name + "," + std::to_string(gpa) + ")");}

// std::string Student::to_string() const {return _name + " (" + std::to_string(_gpa) + ")";}

std::ostream& operator<<(std::ostream& ost, const Student& student) {
    ost << (Person)student << " (" << student._gpa << ")";
    return ost;
}

