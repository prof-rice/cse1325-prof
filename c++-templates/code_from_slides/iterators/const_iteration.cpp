#include <vector>
#include <iostream>

typedef std::vector<int> Integers;

int main() {
  const Integers v = {1, 2, 3, 4, 5};
  Integers::const_iterator it = v.cbegin();
  do {
      std::cout << *it << std::endl; 
  } while(++it != v.cend());
}

