#include <queue>
#include <iostream>

class compare {
  public:
    bool operator()(int lhs, int rhs){
        if((lhs%3)==(rhs%3)) return lhs<rhs;
        return (lhs%3)<(rhs%3);
    }
};
int main() {
    std::priority_queue<int, std::vector<int>, compare> s;
    for(int i=0; i<=5; s.push(i++));
    while(!s.empty()) {std::cout << s.top() << '\n'; s.pop();}
}

