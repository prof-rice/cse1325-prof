#include <iostream>

enum class Month { 
     Jan, Feb, Mar, 
     Apr, May, Jun,
     Jul, Aug, Sep, 
     Oct, Nov, Dec
};

std::string to_string(Month m) {
    switch(m) {
        case Month::Jan: return "January"; break;
        case Month::Feb: return "February"; break;
        case Month::Mar: return "March"; break;
        case Month::Apr: return "April"; break;
        case Month::May: return "May"; break;
        case Month::Jun: return "June"; break;
        case Month::Jul: return "July"; break;
        case Month::Aug: return "August"; break;
        case Month::Sep: return "September"; break;
        case Month::Oct: return "October"; break;
        case Month::Nov: return "November"; break;
        case Month::Dec: return "December"; break;
        default: return "Unknown";
    }
}

int main() {
   Month month{Month::Jan};
   std::cout << "January is "      << to_string(month)
           << ", May is "          << to_string(Month::May)
           << ", and December is " << to_string(Month::Dec)
           << "." << std::endl;
}
