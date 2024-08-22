// C++ include files work much like C, except we no longer use .h for system libraries
// these are similar in function to C's stdio.h
#include <iostream>
#include <fstream>

// The C++ main function is identical to C
int main(int argc, char* argv[]) {

    // C++'s std::string is like C's char* but far more flexible
    std::string filename = "test_cpp_file_io.cpp";
    std::string file{filename};
    
    // C++'s input file stream (ifstream) is fopen, fget, and fclose in one, with much more!
    std::ifstream ist{file};
    
    // If the input file stream isn't "good" (!ist), report an error (throw an exception)
    if (!ist) throw std::runtime_error{"can’t open input file " + file};

    // C++'s getline is very similar to C's getline
    // C++ normally "streams text out to the console" (cout) using the << operator
    // C++'s endl is a \n but also forces (flushes) all text to the console immediately
    std::cout << "Here's the contents of my source file (" + filename + "):\n" << std::endl;
    std::string s;
    while (std::getline(ist, s)) std::cout << "  " << s << std::endl;
}

