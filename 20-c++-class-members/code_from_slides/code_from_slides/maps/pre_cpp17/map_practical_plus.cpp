#include <iostream>
#include <vector>
#include <map>

typedef std::string Student;
typedef std::vector<int> Grades;

std::ostream& operator<<(std::ostream& ost, Grades& grades) {
    for (int grade : grades) ost << grade << ' ';
    return ost;
}

int main() {
    std::map<Student, Grades> gradebook;

    gradebook["Li"] = {100,98};
    gradebook["Ajay"] = {98,88,92,100};
    gradebook["Juan"] = {91,73,110,100};
    gradebook["Sophia"] = {77,69,75,84,91};

    for (auto student : gradebook) {
        std::cout << "Student " << student.first << " grades: " << student.second << std::endl;
    }
}

