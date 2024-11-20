#include "date.h"

#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>

#include <map>

typedef double Temp;

int main(int argc, char* argv[]) {
  try {
    std::string usage = "usage: " + std::string{argv[0]} + " <datafile>";
    if(argc != 2) {
        std::cerr << usage << std::endl;
        exit(-1);
    }
    std::string filename{argv[1]};
    if(filename == "-h") {
        std::cout << usage << std::endl;
        exit(0);
    }
    
    std::ifstream ist{filename};
    if (!ist) throw std::runtime_error{"Can’t open input file " + filename};
    std::map<Date, Temp> temps;
    
    std::string s;
    std::string field;
    Date date;
    int year, month, day;
    double temp;
    
    while(ist) {
        if(std::getline(ist, s)) {
            std::istringstream iss{s};
            for(int i=0; i<4; ++i) std::getline(iss, field, ',');
            if(field != "Dallas Ft Worth") throw std::runtime_error{"bad field: " + field};
            std::getline(iss, field, ',') ; month = stoi(field);
            std::getline(iss, field, ',') ; day   = stoi(field);
            std::getline(iss, field, ',') ; year  = stoi(field);
            std::getline(iss, field, '\n') ; temp  = stod(field);
            if(iss) temps[Date{year, month, day}] = temp;
        }
    }

    Date first;
    Date last;
    std::cout << std::fixed << std::setprecision(1);
    while(true) {
        std::cout << "Starting date to list (year month day): ";
        std::cin >> year >> month >> day; std::cin.ignore();
        if(!std::cin) break;
        first = Date{year, month, day};
        
        std::cout << "Ending   date to list (year month day): ";
        std::cin >> year >> month >> day; std::cin.ignore();
        if(!std::cin) break;
        last = Date{year, month, day};
        
        auto it = temps.find(first);
        while(it != temps.end()) {
            date = it->first;
            if(date > last) break;
            temp = it->second;
            std::cout << date << " " << std::setw(6) << temp << std::endl;
            ++it;
        }
    }
  } catch(std::exception e) {
    std::cerr << "Program abort: " << e.what() << std::endl;
    exit(-2);
  }
}

