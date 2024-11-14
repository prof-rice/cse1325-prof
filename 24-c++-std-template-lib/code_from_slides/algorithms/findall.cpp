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
        auto it_next = v.begin();
        while(it_next != v.end()) {
            auto it = std::find(it_next, v.end(), target);
            if(it == v.end()) break;
            else std::cout << "Found " << target << " at v["
                       << std::distance(v.begin(), it) << "]\n";
            it_next = it+1;
        }
        std::cout << "Next search? ";
    }
    std::cout << std::endl;
}
