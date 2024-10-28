#include <iostream>

enum Month {January = 1, February, March,     April,   May,      June, 
           July,         August,   September, October, November, December};

 int main() {
   Month month = January;
   std::cout << "January is " << month
       << ", May is " << May
       << ", and December is " << December
       << "." << std::endl;
 }
 

