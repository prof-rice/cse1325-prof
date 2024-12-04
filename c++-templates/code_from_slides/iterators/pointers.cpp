#include <iostream>

int main() {
  int v[] = {1, 2, 3, 4, 5};
  int* pv = v;
  int* v_end = v+5;
  do {
      std::cout << *pv << std::endl; 
  } while(++pv != v_end);
}

