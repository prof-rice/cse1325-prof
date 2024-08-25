#include <iostream>

enum Month {January =  1, February =  2, March     =  3, 
            April   =  4, May      =  5, June      =  6, 
            July    =  7, August   =  8, September =  9, 
            October = 10, November = 11, December  = 12};
std::string to_string[13] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                 "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
struct Date {
    int year;
    Month month;
    int day;
};

std::string date_to_string(Date date) {
    return std::to_string(date.year) + " "
         +      to_string[date.month] + " "
         + std::to_string(date.day);
}

Date valid_date(int year, Month month, int day) {
    if (day<1 || day>31) {
        std::cerr << "ERROR: Invalid day" << std::endl;
        return Date{0, (Month)0, 0};
    }
    return Date{year, month, day};
}

int main() {
    Date space = valid_date(1961, April, 12);
    std::cout << "First human in space: "
              << date_to_string(space) << std::endl;
    ++space.day;
    std::cout << "...and the day after: "
              << date_to_string(space) << std::endl << std::endl;
    
    Date moon = valid_date(20, July, 1969);
    std::cout << "First human on the moon: "
              << date_to_string(moon) << std::endl;
    ++moon.day;
    std::cout << "...and the day after: "
              << date_to_string(moon) << std::endl << std::endl;

}

