#include <queue>
#include <iostream>

class Bug {
  public:
    Bug() : Bug("default", 0) { }
    Bug(std::string desc, int prio) : description{desc}, priority{prio} { }
    friend std::ostream& operator<<(std::ostream& ost, const Bug bug) {
        ost << bug.description << " (priority " << bug.priority << ")";
        return ost;
    }
    bool operator()(Bug& lhs, Bug& rhs){
        if (lhs.priority == rhs.priority) return lhs.description < rhs.description;
        return lhs.priority < rhs.priority;
    }
  private:
    std::string description;
    int priority;
};

int main() {
    std::priority_queue<Bug, std::vector<Bug>, Bug> s;
    for(int i=0; i<=9; ++i) s.push(Bug{"Bug "+std::to_string(i), rand()%5});
    while(!s.empty()) {std::cout << s.top() << '\n'; s.pop();}
}

