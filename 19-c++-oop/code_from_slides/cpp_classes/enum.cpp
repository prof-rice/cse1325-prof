#include <iostream>

enum Month {January = 1,  February = 2,  March = 3, 
           April = 4,    May = 5,       June = 6, 
           July = 7,     August = 8,    September = 9, 
           October = 10, November = 11, December = 12};

 int main() {
   Month month = January;
   std::cout << "January is " << month
       << ", May is " << May
       << ", and December is " << December
       << "." << std::endl;
 }
