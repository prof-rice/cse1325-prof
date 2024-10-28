#include "complex.h"
#include <iostream>
using namespace std;

int main() {
  Complex c{3.0, 4.0};
  cout << c.magnitude() << endl;
}
