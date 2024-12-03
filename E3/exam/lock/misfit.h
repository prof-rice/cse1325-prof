#ifndef __MISFIT_H
#define __MISFIT_H

#include <iostream>

class Misfit : public std::runtime_error {
  public:
    Misfit();
};

#endif
