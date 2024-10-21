#include <string>
#include <iostream>
using namespace std;

int main() {
   cout << "What is your name and GPA? ";
   string first, last;
   double gpa;
   cin >> first >> last >> gpa;
   string name = first + ' ' + last;
   cout << "Hello " << name 
        << " (GPA " << gpa << ")!\n";
}
