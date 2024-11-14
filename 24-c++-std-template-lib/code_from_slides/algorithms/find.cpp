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
    std::cout << "What shall we find today? ";
    while(std::cin >> target) {
        auto it = std::find(v.begin(), v.end(), target);
        if(it == v.end()) std::cout << target << " not found!" << std::endl;
        else std::cout << "Found first " << target << " at v["
                       << std::distance(v.begin(), it) << "]\nNext? ";
    }
    std::cout << std::endl;
}
