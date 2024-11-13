#include <iostream>
#include <vector>
#include <map>

typedef std::vector<int> Grades;
std::ostream& operator<<(std::ostream& ost, const Grades& grades) {
    for (int grade : grades) ost << grade << ' ';
    return ost;
}

typedef std::string Student;
typedef std::map<Student, Grades> Gradebook;
std::ostream& operator<<(std::ostream& ost, const Gradebook& gradebook) {
//  for (const auto& [student, grades] : gradebook)
//      std::cout << "Student " << student << " grades: " << grades << std::endl;
    for(auto it = gradebook.cbegin(); it != gradebook.cend(); ++it)
        std::cout << "Student " << it->first << " grades: " << it->second << std::endl;
    return ost;
}

int main() {
    Gradebook gradebook = {
        {"Li",     {100,98}        },
        {"Ajay",   {98,88,92,100}  },
        {"Juan",   {91,73,110,100} },
        {"Sophia", {77,69,75,84,91}},
    };

    std::cout << gradebook << std::endl;
}
