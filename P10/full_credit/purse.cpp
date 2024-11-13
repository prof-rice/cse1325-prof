#include "purse.h"

#include <locale>
#include <codecvt>

Purse::Purse(int pounds, int shillings, int pence)
    : _pence{pence}, _shillings{shillings}, _pounds{pounds} {
    rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
    // char poundSymbol = 156;
    // return ost << poundSymbol << purse._pounds << " "
    return ost << "£" << purse._pounds << " " 
               << purse._shillings << "s"
               << purse._pence << "d";
}

Purse& Purse::operator++() {
    _pence++;
    rationalize();
    return *this;
}
Purse Purse::operator++(int) {
    Purse original = *this;
    ++(*this);
    return original;
}
Purse Purse::operator+(const Purse& purse) {
    return Purse(_pounds    + purse._pounds, 
                 _shillings + purse._shillings, 
                 _pence     + purse._pence);
}
Purse Purse::operator-(const Purse& purse) {
    return Purse(_pounds    - purse._pounds, 
                 _shillings - purse._shillings, 
                 _pence     - purse._pence);
}
Purse& Purse::operator+=(const Purse& purse) {
    _pence     += purse._pence;
    _shillings += purse._shillings;
    _pounds    += purse._pounds;
    rationalize();
    return *this;
}
Purse& Purse::operator-=(const Purse& purse) {
    _pence     -= purse._pence;
    _shillings -= purse._shillings;
    _pounds    -= purse._pounds;
    rationalize();
    return *this;
}

void Purse::rationalize() {
   int p = _pence + 12 * _shillings + 240 * _pounds;
   _pounds = p / 240;
   p %= 240;
   _shillings = p / 12;
   _pence = p % 12;
}

#ifndef __cpp_impl_three_way_comparison
// Only need if <=> is not available (could wrap in preprocessor, too)
int Purse::compare(const Purse& purse) {
    int result = _pounds - purse._pounds;
    if(result == 0) result = _shillings - purse._shillings;
    if(result == 0) result = _pence - purse._pence;
    return result;
}
#endif

