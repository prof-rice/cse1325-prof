#include "clock.h"

#include <iostream>
#include <iomanip>

Clock::Clock(int hours, int minutes, int seconds)
    : _hours{hours}, _minutes{minutes}, _seconds{seconds} { 
    if (hours   < 0 || hours   > 23) 
        throw std::out_of_range{"Invalid hours: " + std::to_string(hours)};
    if (minutes < 0 || minutes > 59) 
        throw std::out_of_range{"Invalid minutes: " + std::to_string(minutes)};
    if (seconds < 0 || seconds > 59) 
        throw std::out_of_range{"Invalid seconds: " + std::to_string(seconds)};
}
Clock::~Clock() { }
void Clock::print() {
    std::cout << std::setfill('0') 
              << std::setw(2) << _hours   << ':'
              << std::setw(2) << _minutes << ':'
              << std::setw(2) << _seconds;
}
void Clock::tic() {
    if(++_seconds > 59) {
        _seconds -= 60;
        if(++_minutes > 59) {
            _minutes -= 60;
            _hours = ++_hours % 24;
        }
    }
}
