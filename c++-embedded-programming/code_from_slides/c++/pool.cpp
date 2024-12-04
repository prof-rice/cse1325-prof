#include <iostream>
#include <iomanip>
#include <array>

template<class T, int N> 
class Pool {
  public: 
    // get a T from the pool; return 0 if no free Ts
    T* get() {
        for (auto& t : items) {
            if (t.free) {t.free = false; return &t.value;}
        }
        return nullptr;
    }

    // return a T given out by get() to the pool
    void free(T* p) {
        for (auto& t : items) {
            if (p == &t.value) {t.free = true; break;}
        }
    }

  protected:

    // We can't assume T can be a base class, so we composite it
    class Item {
      public:
        Item() : free{true} { }
        T value;    // The value held in each pool slot 
        bool free;  // True if this pool slot is unused
    };

    // keep track of T[N] array (e.g., a list of free objects)
    std::array<Item, N> items;
};

template <class T, int N>
class Testable_pool : public Pool<T, N> {
  public:
    // For demo only - print the contents of the pool
    void show_pool() {
        std::cout << std::hex;
        for (auto& t : this->items) {
           if (t.free) std::cout << "-- ";
           else std::cout << std::setw(2) << t.value << ' ';
        }
        std::cout << std::endl;
    }
};
    
int main() {
    typedef int seg7_led;  // Manage a pool of 10 2-digit LEDs
    Testable_pool<seg7_led, 10> p;
    p.show_pool();

    int* i1 = p.get();
    *i1 = 42;
    int* i2 = p.get();
    *i2 = 17;
    int* i3 = p.get();
    *i3 = 0xFF;
    int* i4 = p.get();
    *i4 = 0xCC;
    p.show_pool();

    p.free(i1);
    p.free(i3);
    p.show_pool();

    int* i5 = p.get();
    *i5 = 0x4F;
    p.show_pool();
}    

