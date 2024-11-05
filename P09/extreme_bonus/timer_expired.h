#ifndef __TIMER_EXPIRED_H__
#define __TIMER_EXPIRED_H__

#include <stdexcept>

class Timer_expired : public std::runtime_error {
  public:
    Timer_expired();
};

#endif
