#include <iostream>
#include <vector>
#include <map>

typedef std::string Student;
typedef std::vector<int> Grades;

std::ostream& operator<<(std::ostream& ost, const Grades& grades) {
    for (int grade : grades) ost << grade << ' ';
    return ost;
}

int main() {
    std::map<Student, Grades> gradebook = {
        {"Li",     {100,98}        },
        {"Ajay",   {98,88,92,100}  },
        {"Juan",   {91,73,110,100} },
        {"Sophia", {77,69,75,84,91}},
    };

    for (const auto& [student, grades] : gradebook) {
        std::cout << "Student " << student << " grades: " << grades << std::endl;
    }
}
