#ifndef __LOCK_H
#define __LOCK_H

#include "key.h"
#include "state.h"

class Lock {
  public:
    Lock(const Key& key);
    void close();
    void open(const Key& key);
//    bool operator==(const Lock& lock);
//    bool operator<(const Lock& lock);
//    friend std::ostream& operator<<(std::ostream& ost, const Lock& lock);
  private:
    const Key _key;
    State _state;
};

#endif
