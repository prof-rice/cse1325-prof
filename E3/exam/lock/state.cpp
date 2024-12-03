#include "state.h"

std::ostream& operator<<(std::ostream& ost, const State& state) {
    return ost << ((state == State::OPEN) ? "open" : "closed");
}
