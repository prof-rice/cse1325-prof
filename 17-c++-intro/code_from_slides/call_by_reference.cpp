#include <iostream>

// call-by-value (send the function a reference to the argument’s value)
int f(int& a) { a = a+1; return a; }


int main() {
	int xx = 0;
	std::cout << f(xx) << '\n';   // writes 1
	std::cout << xx << '\n';      // writes 1; f() DOES change xx
	int yy = 7;
	std::cout << f(yy) << '\n';   // writes 8;
	std::cout << yy << '\n';      // writes 8; f() DOES change yy
}
