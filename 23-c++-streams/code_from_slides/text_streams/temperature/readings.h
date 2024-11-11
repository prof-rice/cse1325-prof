#ifndef __READINGS_H
#define __READINGS_H

#include "reading.h"

#include <string>
#include <vector>

class Readings {
  public:
    Readings(std::istream& ist);     // Construct object from any istream
    int size();                      // Number of readings 
    Reading& operator[](int index);  // Access a reading with subscript
    std::string graph();             // Return char graph of data
  private:
    std::vector<Reading> _readings;
};

#endif
