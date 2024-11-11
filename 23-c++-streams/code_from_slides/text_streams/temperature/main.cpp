#include "readings.h"

#include <iostream>
#include <fstream>

int main(int argc, char* argv[]) {
    if(argc != 2) {                              // Argument validation
        std::cerr << "usage: " << argv[0] << " temps.txt" << std::endl;
        return -1;
    }
    std::string filename{argv[1]};               // Open data file for reading
    std::ifstream ifs{filename};
    if (!ifs) {
        std::cerr << "Invalid filename: " << filename << std::endl;
        return -2;
    }

    Readings readings{ifs};                      // Construct object from file
    std::cout << readings.graph() << std::endl;  // Print the graph
    
    Reading min = readings[0];                   // Calculate and print min / max
    Reading max = readings[0];                   // Yes, std::minmax exists...
    for(int i=1; i<readings.size(); ++i) {
        if(min.temp() < readings[i].temp()) min = readings[i];
        if(max.temp() > readings[i].temp()) max = readings[i];
   }
   std::cout << "Max temperature: " << max << std::endl;
   std::cout << "Min temperature: " << min << std::endl;    
}

