#include <vector>
#include <iostream>

int main() {
  std::vector<int> v = {1, 2, 3, 4, 5};

  // Old school - 3-term counted loop
  for(int i=0; i<v.size(); ++i) std::cout << v[i] << " ";
  std::cout << std::endl;

  // Verbose school (but more techically accurate) - 3-term counted loop
  for(std::vector<int>::size_type i=0; i<v.size(); ++i) std::cout << v[i] << " ";
  std::cout << std::endl;

  // Verbose school - 1-term for-each loop
  for(std::vector<int>::value_type i : v) std::cout << i << " ";
  std::cout << std::endl;

  // Classic school - 1-term for-each loop with known type
  for(int& i: v) std::cout << i << " ";
  std::cout << std::endl;

  // Auto school - 1-term for-each loop where the compiler figures out the type
  for(auto& i : v) std::cout << i << " ";
  std::cout << std::endl;

  // Explicit school - iterator is a nested class inside vector that returns 
  // a pointer to a vector item (or the address past the last item v.end())
  for(std::vector<int>::iterator p = v.begin(); p!=v.end(); ++p) std::cout << *p << " ";
  std::cout << std::endl;
}

