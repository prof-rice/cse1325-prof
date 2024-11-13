#include <vector>
#include <iostream>

typedef std::vector<int> Integers;

int main() {
  Integers v = {1, 2, 3, 4, 5};
  Integers::iterator it = v.begin();
  do {
      std::cout << *it << std::endl; 
  } while(++it != v.end());
}

