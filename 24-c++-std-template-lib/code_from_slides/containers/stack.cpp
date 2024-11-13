#include <stack>
#include <iostream>

int main() {
    std::stack<int> s;
    for(int i=1; i<=5; s.push(i++));
    while(!s.empty()) {std::cout << s.top() << '\n'; s.pop();}
}

