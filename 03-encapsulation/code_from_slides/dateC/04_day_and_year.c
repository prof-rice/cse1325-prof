#include <stdio.h>

enum Month {January =  1, February =  2, March     =  3, 
            April   =  4, May      =  5, June      =  6, 
            July    =  7, August   =  8, September =  9, 
            October = 10, November = 11, December  = 12};

const char* to_string[] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                               "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

struct Date {
    int year;
    enum Month month;
    int day;
};

int main() {
    struct Date birthday = {1950, December, 30};
    printf("%s %d, %d\n", 
        to_string[birthday.month], birthday.day, birthday.year);
}
 
