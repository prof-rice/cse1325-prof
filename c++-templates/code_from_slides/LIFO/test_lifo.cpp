#include "lifo.h"
#include <iostream>

void test_strings() {  // Basic test – push some text in, pop it back out
  LIFO<std::string> lifo;
  lifo.push("Hello");
  lifo.push("Goodbye");
  if (lifo.pop() != "Goodbye")
    std::cerr << "FAIL: std::string 'Goodbye' did not pop" << std::endl;
  if (lifo.pop() != "Hello")
    std::cerr << "FAIL: std::string 'Hello' did not pop" << std::endl;
}

void test_bool_methods() { // Verify is_full / is_empty + non-default constructor
  LIFO<std::string> lifo{3};
  if (!lifo.is_empty())
    std::cerr << "FAIL: New bool LIFO was not empty" << std::endl;
  if (lifo.is_full())
    std::cerr << "FAIL: New bool LIFO was full" << std::endl;
  lifo.push("Larry");
  lifo.push("Curly");
  lifo.push("Moe");
  if (lifo.is_empty())
    std::cerr << "FAIL: Full bool LIFO was empty" << std::endl;
  if (!lifo.is_full())
    std::cerr << "FAIL: Full bool LIFO was not full" << std::endl;
}

void test_underflow() { // Verify runtime exception on underflow
  LIFO<double> lifo;
  lifo.push(1);
  lifo.pop();
  try {
    lifo.pop();
    std::cerr << "FAIL: Underflow did not produce exception" << std::endl;
  } catch(...) {
  }
}

void test_overflow() {  // Verify runtime exception on overflow
  LIFO<int> lifo{3};

  lifo.push(1);
  lifo.push(2);
  lifo.push(3);
  try {
    lifo.push(4);
    std::cerr << "FAIL: Overflow did not produce exception" << std::endl;
  } catch(...) {
  }
}

// Since our deleted copy constructor and copy assignment operator tests
// cause compile errors if “successful”, we wrap them in preprocessor conditionals.
// See the Makefile for how to set this as part of the build!

#ifdef _TEST_DELETES_
void copy_constructor(LIFO<int> x) {
  std::cout << x.pop() << std::endl;
}

void test_copy_constructor_and_assignment() {  // Verify no copies
  LIFO<int> lifo1;
  lifo1.push(1);
  copy_constructor(lifo1);
  LIFO<int> lifo2;
  lifo2 = lifo1;
}
#endif

int main() {  // Run the regression tests!
  test_strings();
  test_bool_methods();
  test_underflow();
  test_overflow();
}
