#ifndef __TIMER_H__
#define __TIMER_H__

#include "clock.h"

class Timer : public Clock {
  public:
    Timer(int hours, int minutes, int seconds);
    void tic();
};

#endif
