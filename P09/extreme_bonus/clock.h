#ifndef __CLOCK_H__
#define __CLOCK_H__

class Clock {
  public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock();
    void print();
    void tic();
  protected:
    int _hours;
    int _minutes;
    int _seconds;
};

#endif
