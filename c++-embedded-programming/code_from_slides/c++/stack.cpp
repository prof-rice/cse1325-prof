#include <iostream>
#include <iomanip>
#include <array>

template<class T, int N> 
class Stack {
  public: 
    Stack() : next{stack.begin()} {stack.fill(T{});}

    // get next T from the stack; return 0 if no free Ts
    T* get() {
        if (next != stack.end()) return &(*next++);
        else return nullptr;
    }

    // return the most recent T given out by get() to the stack
    void free() {
        if (next != stack.begin()) {--next; *next = T{};}
    }

  protected:

    std::array<T, N> stack;
    typename std::array<T, N>::iterator next;
};

template <class T, int N>
class Testable_stack : public Stack<T, N> {
  public:
    // For demo only - print the contents of the stack
    void show_stack() {
        int stack_elements = this->stack.size();
        std::cout << std::hex;
        for (auto t = this->stack.begin(); t != this->next; ++t) 
            {std::cout << std::setw(2) << *t << ' '; --stack_elements;}
        while(stack_elements--) std::cout << "-- ";
        std::cout << std::endl;
    }
};
    
int main() {
    typedef int seg7_led;  // Manage a stack of 10 2-digit LEDs
    Testable_stack<seg7_led, 10> p;
    p.show_stack();

    int* i1 = p.get();
    *i1 = 42;
    int* i2 = p.get();
    *i2 = 17;
    int* i3 = p.get();
    *i3 = 0xFF;
    int* i4 = p.get();
    *i4 = 0xCC;
    p.show_stack();

    p.free();
    p.free();
    p.show_stack();

    int* i5 = p.get();
    *i5 = 0x4F;
    p.show_stack();
}    

