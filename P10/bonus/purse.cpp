#include "purse.h"

#include <locale>
#include <codecvt>

Purse::Purse(int pounds, int shillings, int pence)
    : _pence{pence}, _shillings{shillings}, _pounds{pounds} {
    rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
    return ost << "£" << purse._pounds << " " 
               << std::to_string(purse._shillings) + "s"
               << std::to_string(purse._pence) + "d";
}
std::istream& operator>>(std::istream& ist, Purse& purse) {

    purse._pounds = 0;
    purse._shillings = 0;
    purse._pence = 0;
    
    std::string s;
    
    ist >> s; // read pounds
    if(s[0] == '#') {
        purse._pounds = stoi(s.substr(1));
        ist >> s; // read shillings and pence
    }
    int pos = s.find('s');
    if(pos != std::string::npos) {
        purse._shillings = stoi(s);
        s = s.substr(pos+1); // remove shillings
    }
    pos = s.find('d');
    if(pos != std::string::npos) {
        purse._pence = stoi(s);
    }
    return ist;

/*
    // Check for #
    ist >> s;
    if(ist && !s.empty() && s[0] == '#') {
        purse._pounds = stoi(s.substr(1));
        ist >> s;
    } else {
        ist.setstate(std::ios::failbit); // Set stream state to fail
    }
    if(ist && !s.empty() && isdigit(s[0])) {
        int pos = s.find('s');
        if(pos != std::string::npos) {
            purse._shillings = stoi(s.substr(0,pos));
            s = s.substr(pos+1);
        }
    } else {
        ist.setstate(std::ios::failbit); // Set stream state to fail
    }
    if(ist && !s.empty() && isdigit(s[0])) {
        int pos = s.find('d');
        if(pos != std::string::npos) {
            purse._pence = stoi(s.substr(0,pos));
        }
    } else {
        ist.setstate(std::ios::failbit); // Set stream state to fail
    }
    return ist;
*/
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

