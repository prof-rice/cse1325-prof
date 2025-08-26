#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

enum Month {January =  1, February =  2, March     =  3, 
            April   =  4, May      =  5, June      =  6, 
            July    =  7, August   =  8, September =  9, 
            October = 10, November = 11, December  = 12};

char* to_string[] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                         "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

struct Date {
    int year;
    enum Month month;
    int day;
};

bool invalid_date(struct Date* date) {
    return (date->day < 1 || date->day > 31);
}

char* date_to_char_ptr(struct Date* date) {
    if(date == NULL) return NULL;
    char* month = to_string[date->month];
    size_t size = sizeof(int) * 2 + strlen(month) + 3;
    char *buffer = (char*)malloc(size);
    if (buffer == NULL) return NULL;
    
    sprintf(buffer, "%d %s %d", date->year, month, date->day);
    
    return buffer;
}

int main() {
    struct Date space = {1961, April, 12};
    if(invalid_date(&space)) printf("BAD DATE: %s\n", date_to_char_ptr(&space));
    printf("First human in space: %s\n", date_to_char_ptr(&space));
    ++space.day;
    printf("...and the day after: %s\n\n", date_to_char_ptr(&space));

    struct Date moon = {20, July, 1969};
    if(invalid_date(&moon)) printf("BAD DATE: %s\n", date_to_char_ptr(&moon));
    printf("First human on the moon: %s\n", date_to_char_ptr(&moon));
    ++moon.day;
    printf("...and the day after: %s\n\n", date_to_char_ptr(&moon));
}
 
