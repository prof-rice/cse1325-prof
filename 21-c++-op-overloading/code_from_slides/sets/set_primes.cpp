#include <set>
#include <iostream>
#include <cmath>

// Returns true if "number" is a prime number
bool is_prime (int number) {
    if (number < 2) return false;
    for (int i=2; i <= std::sqrt(number); ++i) {
        if ((number % i) == 0) return false;
    }
    return true;
}

int main() {
    std::set<int> s;
    for(int i=1; i<=100; ++i) {int x = rand()%100; if(is_prime(x)) s.insert(x);}
    for(auto i : s) std::cout << i << '\n';
}

