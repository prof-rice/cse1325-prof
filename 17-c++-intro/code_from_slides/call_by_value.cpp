#include <iostream>

// call-by-value (send the function a copy of the argument’s value)
int f(int a) { a = a+1; return a; }


int main() {
	int xx = 0;
	std::cout << f(xx) << '\n';   // writes 1
	std::cout << xx << '\n';      // writes 0; f() DOES NOT change xx
	int yy = 7;
	std::cout << f(yy) << '\n';   // writes 8;
	std::cout << yy << '\n';      // writes 7; f() DOES NOT change yy
}
