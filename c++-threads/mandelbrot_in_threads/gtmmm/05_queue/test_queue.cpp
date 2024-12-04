#include "queue.h"
#include <iostream>

int main() {
    Queue<int> q;
    q.push(1);
    q.push(2);
    q.push(3);
    while(auto e = q.pop()) std::cout << *e << ' ';
}
/*
    while(true) {
        auto e = q.pop();
        if((bool)e) std::cout << *e << ' ';
        else break;
    }
*/
