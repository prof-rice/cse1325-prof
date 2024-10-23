#include <iostream>
#include <iomanip>
#include <vector>
#include <chrono>

// Create shorter aliases
using time_point = std::chrono::steady_clock::time_point;
constexpr auto now = &std::chrono::steady_clock::now;

double elapsed_time(time_point start, 
                    time_point finish) {
    return (finish - start).count() / 1000000000.0;
}

int main() {
    std::cout << "Enter some event names, and I'll time them!\n" 
              << "Press Control-d to exit" << std::endl;

    std::vector<time_point> times;
    std::vector<std::string> events;
    
    times.push_back(now());
    events.push_back("Begin");
    
    std::string line;
    while(std::cin) {
        std::getline(std::cin, line);
        times.push_back(now());
        events.push_back(line);
    }
    
    std::cout << std::setw(20) << "Event Description" 
              << std::setw(15) << "From Start" 
              << std::setw(15) << "From Previous" << std::endl;
    
    std::cout << std::fixed << std::setprecision(3);
    for(int i=1; i<times.size(); ++i) {   
        std::cout << std::setw(20) << events[i] 
                  << std::setw(15) << elapsed_time(times[0],   times[i]) 
                  << std::setw(15) << elapsed_time(times[i-1], times[i]) 
                  << " seconds" << std::endl;
    }
}

