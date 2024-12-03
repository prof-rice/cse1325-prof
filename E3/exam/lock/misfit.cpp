#include "misfit.h"

const std::string msg {"Wrong key for lock"};
Misfit::Misfit() : std::runtime_error{msg} { }
