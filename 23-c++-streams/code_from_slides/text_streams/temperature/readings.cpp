#include "readings.h"

#include <sstream>
#include <fstream>

Readings::Readings(std::istream& ist) {
    Reading reading;
    // Request a failure exception if the ist stream goes bad
    ist.exceptions (ist.exceptions() | std::ifstream::badbit);
    while(ist >> reading) {  // Using our overloaded >> operator for Reading
        _readings.push_back(reading);
    }
    // Because the eof state also sets the fail state, we must check eof only
    if(!ist.eof()) throw std::ifstream::failure("Error reading temperatures");
}

int Readings::size() {
    return _readings.size();
}

// Operator [] is the subscript operator
// We can index data from a Readings object as if it were an array or vector!
Reading& Readings::operator[](int index) {
    return _readings.at(index); // throws std::out_of_range if needed
}

// Generate our graph representation using an output string stream
// We stream text to the oss object, then get everything we streamed back
//   using its str() method. It may be cleared and reused with oss.str("");
std::string Readings::graph() {
    std::ostringstream oss; // Use a stream to format a string
    for(auto r : _readings) {
        oss << r << ' ';
        for (int j=0; j<r.temp()/2; j++) oss << '#';
        oss << '\n';
    }
    return oss.str();
}

