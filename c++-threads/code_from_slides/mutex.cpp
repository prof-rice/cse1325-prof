#include <iostream>
#include <thread>
#include <mutex>

static const int num_threads = 50;
static const int num_decrements = 5000;

int counter = num_threads * num_decrements;

std::mutex m;

// This is the code to be run as threads
void decrementer() {
    for (int i=num_decrements; i > 0; --i) {
        m.lock(); --counter; m.unlock();
    }
}
    
int main() {
    //Launch a group of threads
    std::thread t[num_threads];
    for (int i = 0; i < num_threads; ++i) t[i] = std::thread(decrementer);

    //Join the threads with the main thread
    for (int i = 0; i < num_threads; ++i) t[i].join();

    std::cout << "This should be 0: " << counter << std::endl;
    return counter;
}

