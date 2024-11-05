#include "timer.h"

#include <stdexcept>

Timer::Timer(int hours, int minutes, int seconds)
    : Clock(hours, minutes, seconds) { }
void Timer::tic() {
    if(--_seconds <0) {
        _seconds += 60;
        if(--_minutes < 0) {
            _minutes += 60;
            _hours = --_hours % 24;
        }
    }
    if(_seconds == 0 && _minutes == 0 && _hours == 0) {
        throw std::runtime_error{"Timer expired"};
    }
};
