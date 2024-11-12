#include "purse.h"

#include <locale>
#include <codecvt>

Purse::Purse(int pounds, int shillings, int pence)
    : _pence{pence}, _shillings{shillings}, _pounds{pounds} {
    rationalize();

    // Create an 8-bit byte string representing £
    if(pound_utf8.empty()) {
        std::wstring_convert<std::codecvt_utf8<wchar_t>> converter;
        std::wstring pound = L"£";
        pound_utf8 = converter.to_bytes(pound);
    }
}

std::string Purse::pound_utf8;

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
//  This simpler answer is perfectly acceptable
/*
    return ost << "£" << purse._pounds << " " 
               << purse._shillings + "s"
               << purse._pence + "d";
*/
    // This version only prints non-zero values unless all are 0
    if(purse._shillings != 0 ||
       purse._pence     != 0 ||
       purse._pence     != 0) {

        if(purse._pounds != 0) {
            ost << "£" << purse._pounds;
            if(purse._shillings != 0 || purse._pence != 0) ost << " ";
        }
        if(purse._shillings != 0) ost << purse._shillings << "s";
        if(purse._pence     != 0) ost << purse._pence     << "d";
    } else {
        ost << "£0";
    }
    return ost;
}
std::istream& operator>>(std::istream& ist, Purse& purse) {

    purse._pounds = 0;
    purse._shillings = 0;
    purse._pence = 0;
    
    std::string s;
    
    // Check for actual £
    ist >> s;
    if(ist && s.length()>2 && s.substr(0,2) == purse.pound_utf8) {
        purse._pounds = stoi(s.substr(2));
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
    
    // The simplified version (still full bonus points!)
    /*
    ist >> s;
    if(s[0] == '#') {
        purse._pounds = stoi(s.substr(1));
        ist >> s;
    }
    int pos = s.find('s');
    if(pos != std::string::npos) {
        purse._shillings = stoi(s.substr(0,pos));
        s = s.substr(pos+1);
    }
    int pos = s.find('d');
    if(pos != std::string::npos) {
        purse._pence = stoi(s.substr(0,pos));
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
int& Purse::operator[](std::string type) {
    if(type == pound_utf8) return _pounds;
    if(type == "s")        return _shillings;
    if(type == "d")        return _pence;
    throw std::out_of_range{"Purse subscript not £, s, or d: " + type};
}

void Purse::rationalize() {
   int p = _pence + 12 * _shillings + 240 * _pounds;
   _pounds = p / 240;
   p %= 240;
   _shillings = p / 12;
   _pence = p % 12;
}

// Only need if <=> is not available (could wrap in preprocessor, too)
int Purse::compare(const Purse& purse) {
    int result = _pounds - purse._pounds;
    if(result == 0) result = _shillings - purse._shillings;
    if(result == 0) result = _pence - purse._pence;
    return result;
}


