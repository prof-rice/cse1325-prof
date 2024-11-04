#include <iostream>
#include <vector>
#include <map>

typedef std::string Student;
typedef int Grade;

typedef std::multimap<Student, Grade> Gradebook;
std::ostream& operator<<(std::ostream& ost, const Gradebook& gradebook) {
    for (const auto& [student, grade] : gradebook)
        std::cout << "Student " << student << " grade: " << grade << std::endl;
    return ost;
}

int main() {
    Gradebook gradebook = {
        {"Li",     100},
        {"Li",      98},
        {"Ajay",    98},
        {"Ajay",    88},
        {"Ajay",    92},
        {"Ajay",   100},
        {"Juan",    91},
        {"Juan",    73},
        {"Juan",   110},
        {"Juan",   100},
        {"Sophia",  77},
        {"Sophia",  69},
        {"Sophia",  75},
        {"Sophia",  91},
    };

    std::cout << gradebook << std::endl;
}
