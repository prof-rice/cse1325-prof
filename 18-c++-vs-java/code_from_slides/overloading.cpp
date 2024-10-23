#include <iostream>
#include <vector>

void print(int i) {std::cout << i << std::endl;}
void print(std::vector<int> is) {for(int i : is) print(i);}

int main() {
    print(rand() % 100);
    std::vector<int> is;
    for(int i=0; i<10; ++i) is.push_back(rand() % 100);
    print(is);
}
    
