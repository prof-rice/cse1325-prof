#include "lock.h"
#include "misfit.h"

Lock::Lock(const Key& key)
    : _key{key}, _state{State::OPEN} { 
}
void Lock::close() {
    _state = State::CLOSED;
}
void Lock::open(const Key& key) {
    if(key != _key) throw Misfit{};
    _state = State::OPEN;
}
/*
std::ostream& operator<<(std::ostream& ost, const Lock& lock);
bool Lock::operator==(const Lock& lock) {
    return _key == lock._key;
}
bool Lock::operator<(const Lock& lock) {
    return _key < lock._key;
}
*/
