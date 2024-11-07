#include <iostream>

int x = 0;	// global variable – always avoid these
int y = 0;	// another global variable

void f() {
    int x;          // local scope variable (Note – now there are two x’s)
    x = 7;          // local x, not the global x
    int& fx = x;    // keep a reference (sorta like a pointer) to f's x
    std::cout << "f's x = " << x << " but global x = " << ::x << std::endl;
    {
        int x = y;  // another local x, initialized by the global y
                    // (Now there are three x’s)
        std::cout << "Before increment, nested x = " << x 
                  << ", while f's x = " << fx 
                  << ", while global x = " << ::x << std::endl;
        ++x;        // increment the local x in this scope
        std::cout << "After  increment, nested x = " << x 
                  << ", while f's x = " << fx 
                  << ", while global x = " << ::x << std::endl;
	}
    std::cout << "Now, f's x = " << x << " but global x = " << ::x << std::endl;
}
int main() {
  std::cout << "global x = " << x << std::endl;
  f();
  std::cout << "global x = " << x << std::endl;
}
