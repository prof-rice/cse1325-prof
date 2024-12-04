#include <iostream>
#include <thread>

int main() {
    // Show rough approximation of thread capacity
    std::cout << "Hardware concurrency is " << std::thread::hardware_concurrency() << std::endl;
}

