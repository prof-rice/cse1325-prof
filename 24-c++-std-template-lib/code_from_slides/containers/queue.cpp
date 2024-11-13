#include <queue>
#include <iostream>

int main() {
    std::queue<int> s;
    for(int i=1; i<=5; s.push(i++));
    while(!s.empty()) {std::cout << s.front() << '\n'; s.pop();}
}

