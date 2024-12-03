#ifndef __STATE_H
#define __STATE_H

#include <iostream>

enum class State{CLOSED, OPEN};
std::ostream& operator<<(std::ostream& ost, const State& state);


#endif
