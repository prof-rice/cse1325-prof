#include <iostream>
#include <vector>

int main(int args, char* argv[]) {
    std::vector<int> v; // on stack
    v.push_back(42); v.push_back(17);v.push_back(255);  
        v.push_back(911); v.push_back(65535);
    for(auto i : v) std::cout << i << std::endl;
}
