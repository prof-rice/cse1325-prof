#include "elevator.h"
#include <vector>
#include <iostream>

using namespace std;

int main() {
    Elevator a, b, c;  // 3 elevators
    vector<int> requests = {3,2,9,1,11,5,1,1,1};  // Must be multiple of 3!
    for (int i = 0; i < requests.size() ; i += 3) {
        a.move(requests[i]);
        b.move(requests[i+1]);
        c.move(requests[i+2]);
    }
    cout << Elevator::get_floors_traversed() << " floors traversed" << endl;
}
