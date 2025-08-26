#include <stdio.h>

enum Month {January =  1, February =  2, March     =  3, 
            April   =  4, May      =  5, June      =  6, 
            July    =  7, August   =  8, September =  9, 
            October = 10, November = 11, December  = 12};

const char* to_string[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

int main() {
    enum Month month = January;
    printf("January is %d,  May is %d, and December is %d\n", 
        month, May, December);
}
 
