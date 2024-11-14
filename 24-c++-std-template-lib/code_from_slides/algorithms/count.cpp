#include <algorithm>
#include <iterator>
#include <iostream>
#include <vector>

int main() {
    std::vector<int> v;
    for(int i=0; i<100; ++i) {
        v.push_back(std::rand()%10);
        std::cout << v.back() << ' ';
    }
    std::cout << std::endl;

    int target;
    std::cout << "What shall we count today? ";
    while(std::cin >> target) {
        int number = std::count(v.begin(), v.end(), target);
        std::cout << "Found " << number << " elements matching " << target << "\nNext? ";
    }
    std::cout << std::endl;
}
