#include <math.h>
auto answer() { return 42;}

int main() {
  auto x = 1;	      // 1 is an int, so x is an int
  auto y = 'c';       // ′c′ is a char, so y is a char
  auto d = 1.2;       // 1.2 is a double, so d is a double
  auto s = "Howdy";   // ″Howdy″ is a string literal of type const char[]
                      // so don’t do that until you know what it means!
  auto sq = sqrt(2);  // sq is the right type for the result of sqrt(2)
  auto duh;		   // error: no initializer for auto
}
