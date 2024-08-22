// C++ include files work much like C, except we no longer use .h for system libraries
// This is similar in function to C's stdio.h
#include <iostream>

// The C++ main function is identical to C
int main() {

    // Create a standard string string (kinda like a char*) containing all valid grades
    std::string grades = "ABCDFI";
    
    // Create a standard string string to hold the grade entered by the user
    std::string grade;
    
    // Loop until break
    while(true) {
    
        // Unformatted print without newline to the console display (std::cout)
        std::cout << "What grade would you like in CSE1325? ";
        
        // Read a line of text into standard string grade
        std::cin >> grade;
        
        // Make the first char of grade (grade[0]) uppercase (toupper), and
        //   if included in the grades std::streing (grades.find) 
        //   break out of the while loop
        if (grades.find(toupper(grade[0])) != std::string::npos) break;
        
        // Otherwise, print an error message and newline to the error console (std::cerr)
        std::cerr << "Sorry, we have no " << grade << " grade!" << std::endl;
    }
    
    // Print an encouraging message with newline to the console display (std::cout)
    std::cout << "Here's hoping for your " << grade << "!" << std::endl;
}
