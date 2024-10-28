#include <cstdlib>
#include <vector>
#include <iostream>
using namespace std;

class Elevator {
  public:
    Elevator();
    void move(int target_floor);
    static int get_floors_traversed();
  private:
    static int floors_traversed;  // declaration only (for static variable)
    int current_floor;
};

int Elevator::floors_traversed = 0;  // definition (for static variable)
Elevator::Elevator() : current_floor{1} { }
void Elevator::move(int target_floor) {
    floors_traversed += abs(target_floor - current_floor);
    current_floor = target_floor;
}
int Elevator::get_floors_traversed() {return floors_traversed;}

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
