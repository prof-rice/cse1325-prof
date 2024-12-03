#include "lock.h"
#include "key.h"
#include "misfit.h"

#include <map>
#include <vector>
#include <ctime>

const int NUM_LOCKS = 10;

int main() {
    srand(time(NULL));
    std::vector<Lock> locks;  locks.reserve(NUM_LOCKS);
    std::vector<Key> keys;    keys.reserve(NUM_LOCKS);
    
    for(int i=0; i<NUM_LOCKS; ++i) {
        keys.push_back(Key{});
        locks.push_back(Lock{keys.back()});
    }
    
    std::sort(keys.begin(), keys.end());
    
    std::cout << "Enter a lock number between 0 and " << NUM_LOCKS-1
              << " and I'll find the matching key on my ring!" << std::endl;
    int lock_index = 0;
    while(std::cin) {
        std::cout << "Lock number? ";
        std::cin >> lock_index;
        Lock& lock = locks[lock_index];
        for(int i=0; i<NUM_LOCKS; ++i) {
            try {
                lock.open(keys[i]);
                std::cout << "Lock " << lock_index << " is opened by key " << i << std::endl;
                break;
            } catch(Misfit e) {
            }
        }
    }
}
