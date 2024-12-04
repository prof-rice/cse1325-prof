#include <iostream>
#include <thread>

// The function we want to execute on the new thread.
void task1() {
    for(int i=0; i<10; ++i) std::cout << "Thread count " << i << std::endl;
}
int main() {
    // Constructs the new thread and runs it. Does not block execution.
    std::thread t1{task1};
    // Main thread continues in parallel
    for(int i=0; i<10; ++i) std::cout << "Main count " << i << std::endl;
    // Makes the main thread wait for the new thread to finish execution, 
    // therefore blocks its own execution.
    t1.join();
}

