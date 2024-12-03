#ifndef __KEY_H
#define __KEY_H

#include <iostream>

class Key {
  public:
    Key();
//#ifdef __cpp_impl_three_way_comparison
//    auto operator<=>(const Key&) const = default;
//#else
    inline bool operator==(const Key& rhs) const {return (compare(rhs) == 0);}
    inline bool operator!=(const Key& rhs) const {return (compare(rhs) != 0);}
    inline bool operator< (const Key& rhs) const {return (compare(rhs) <  0);}
    inline bool operator<=(const Key& rhs) const {return (compare(rhs) <= 0);}
    inline bool operator> (const Key& rhs) const {return (compare(rhs) >  0);}
    inline bool operator>=(const Key& rhs) const {return (compare(rhs) >= 0);}
//#endif
  private:
    int _code;

//#ifndef __cpp_impl_three_way_comparison
    int compare(const Key& key) const;
//#endif
};

#endif
