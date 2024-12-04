#include <iostream>
#include <thread>
#include <mutex>

std::mutex m;
int i = 0;

void makeACallFromPhoneBooth() {
    m.lock(); // person grabs the phone booth door and locks it, all others wait
    std::cout << i << " talks on phone" << std::endl;
    i++; //no other thread can access variable i until m.unlock() is called
    m.unlock(); // person releases the door handle and unlocks the door
}

int main() {
    std::thread person1(makeACallFromPhoneBooth); // Despite appearances, as we saw
    std::thread person2(makeACallFromPhoneBooth); // earlier, it is not clear who will
    std::thread person3(makeACallFromPhoneBooth); // reach the phone booth first!

    person1.join(); // person1 finished their phone call and joins the crowd
    person2.join(); // person2 finished their phone call and joins the crowd
    person3.join(); // person3 finished their phone call and joins the crowd
}

