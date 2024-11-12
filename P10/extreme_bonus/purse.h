#ifndef __PURSE_H
#define __PURSE_H

#include <iostream>

class Purse {
  public:
    Purse(int pounds=0, int shillings=0, int pence=0);

    friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
    friend std::istream& operator>>(std::istream& ist,       Purse& purse);

// Determine at compile time if <=> is supported by this compiler
#ifdef __cpp_impl_three_way_comparison
    auto operator<=>(const Purse&) const = default;
// If not, revert to the explicit definition of all 6 comparison operators
#else
    inline bool operator==(const Purse& rhs) {return (compare(rhs) == 0);}
    inline bool operator!=(const Purse& rhs) {return (compare(rhs) != 0);}
    inline bool operator< (const Purse& rhs) {return (compare(rhs) <  0);}
    inline bool operator<=(const Purse& rhs) {return (compare(rhs) <= 0);}
    inline bool operator> (const Purse& rhs) {return (compare(rhs) >  0);}
    inline bool operator>=(const Purse& rhs) {return (compare(rhs) >= 0);}
#endif
    
    Purse& operator++();
    Purse operator++(int);

    Purse operator+(const Purse& purse);
    Purse operator-(const Purse& purse);

    Purse& operator+=(const Purse& purse);
    Purse& operator-=(const Purse& purse);

    int& operator[](std::string type);
  private:
    void rationalize();
    static std::string pound_utf8;   // Holds a Unicode (2-byte) £
    
    // Only need if <=> is not available (could wrap in preprocessor, too)
    int compare(const Purse& purse); 
    
    int _pounds;
    int _shillings;
    int _pence;
};

#endif
