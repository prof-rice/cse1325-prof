#ifndef __STOX_H
#define __STOX_H

#include <istream>
#include <sstream>
#include <stdexcept>

template<class T> 
T stox(const std::string& s) {
    std::istringstream is(s);
    T t;
    if (!(is >> t)) throw std::runtime_error{"stox failed for " + s};
    return t;
}
#endif
