#include "date.h"

#include <iostream>
#include <sstream>

int main() {
    int result = 0;
    int vector = 1;
      
    // Default constructor and <<
    try {
        std::string expected;
        Date date; 
        std::ostringstream oss;
        oss << date;
        
        expected = "1970 January 1";
        if(oss.str() != expected) {
            result |= vector;
            std::cerr << "FAIL: Invalid default constructor or << operator"
                      << "\n  Expected: " << expected
                      << "\n  Actual:   " << oss.str()
                      << std::endl;
        }
    } catch(std::exception e) {
        std::cerr << "EXCEPTION in vector " << vector << "!\n" << e.what() << "\n" << std::endl;
        result |= vector;
    }
    vector <<= 1;
    
    // >> and != 
    try {
        Date date1;
        std::istringstream iss1{"2023 Apr 5"};
        iss1 >> date1;
        
        Date date2;
        std::istringstream iss2{"2023 4 5"};
        iss2 >> date2;
        
        Date expected{2023, Month::Apr, 5};
        if(date1 != expected || date2 != expected) {
             result |= vector;
             std::cerr << "FAIL: Invalid >> or != operator"
                       << "\n  Expected:     " << expected
                       << "\n  Actual (Apr): " << date1
                       << "\n  Actual (4):   " << date2
                       << std::endl;
        }
    } catch(std::exception e) {
        std::cerr << "EXCEPTION in vector " << vector << "!\n" << e.what() << "\n" << std::endl;
        result |= vector;
    }
    vector <<= 1;
    
          
    // ==, !=, <, <=, >, >=
    try {
        Date lesser{2023, Month::Apr, 5};
        Date greater{2023, Month::Apr, 6};

        if(lesser == greater) {
             result |= vector;
             std::cerr << "FAIL: Invalid == operator for"
                       << "\n  " << lesser << " == " << greater
                       << std::endl;
        }

        if(!(lesser != greater)) {
             result |= vector;
             std::cerr << "FAIL: Invalid != operator for"
                       << "\n  ! " << lesser << " != " << greater
                       << std::endl;
        }

        if(!(lesser < greater)) {
             result |= vector;
             std::cerr << "FAIL: Invalid < operator for"
                       << "\n  ! " << lesser << " < " << greater
                       << std::endl;
        }

        if(!(lesser <= greater)) {
             result |= vector;
             std::cerr << "FAIL: Invalid <= operator for"
                       << "\n  ! " << lesser << " <= " << greater
                       << std::endl;
        }

        if(lesser > greater) {
             result |= vector;
             std::cerr << "FAIL: Invalid > operator for"
                       << "\n  " << lesser << " > " << greater
                       << std::endl;
        }

        if(lesser >= greater) {
             result |= vector;
             std::cerr << "FAIL: Invalid >= operator for"
                       << "\n  " << lesser << " >= " << greater
                       << std::endl;
        }
    } catch(std::exception e) {
        std::cerr << "EXCEPTION in vector " << vector << "!\n" << e.what() << "\n" << std::endl;
        result |= vector;
    }

    vector <<= 1;
    
    // Pre- and post-increment
    try {
        const Date new_years_eve{2021, Month::Dec, 31};
        const Date new_years{2022, Month::Jan, 1};

        Date nye1{new_years_eve};
        Date nye2{new_years_eve};
    
        if(nye1++ != new_years_eve) {
             result |= vector;
             std::cerr << "FAIL: post-inc returned wrong date"
                       << "\n  " << nye1
                       << std::endl;
        }
        if(nye1   != new_years) {
             result |= vector;
             std::cerr << "FAIL: post-inc didn't update date"
                       << "\n  " << nye1
                       << std::endl;
        }
        if(++nye2 != new_years) {
             result |= vector;
             std::cerr << "FAIL: pre-inc didn't update date"
                       << "\n  " << nye2
                       << std::endl;
        }
    } catch(std::exception e) {
        std::cerr << "EXCEPTION in vector " << vector << "!\n" << e.what() << "\n" << std::endl;
        result |= vector;
    }

    vector <<= 1;
    

    // Addition / compound addition
    try {
        const Date christmas{2023, Month::Dec, 25};
        const Date valentine{2024, Month::Feb, 14};
    
        Date xmas = christmas;
        if(xmas + 51 != valentine) {
             result |= vector;
             std::cerr << "FAIL: date + n returned wrong date"
                       << "\n  " << xmas + 51 << " not " << valentine
                       << std::endl;
        }
        if(51 + xmas != valentine) {
             result |= vector;
             std::cerr << "FAIL: n + date returned wrong date"
                       << "\n  " << xmas + 51 << " not " << valentine
                       << std::endl;
        }
        xmas += 51;
        if(xmas != valentine) {
             result |= vector;
             std::cerr << "FAIL: date += n returned wrong date"
                       << "\n  " << xmas << " not " << valentine
                       << std::endl;
    }
    } catch(std::exception e) {
        std::cerr << "EXCEPTION in vector " << vector << "!\n" << e.what() << "\n" << std::endl;
        result |= vector;
    }
    vector <<= 1;

    if(result != 0) 
        std::cerr << "\nFAIL: Error Code " << result << std::endl;

    return result;
}
