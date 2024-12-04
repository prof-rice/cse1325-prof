#include <iostream>

// NON-generic class
class Test {
  public:
    // GENERIC method
    template<class T>
    T get();
};

// Implementation (remember, must be in the HEADER file if you use one!)
template<class T>
T Test::get() {
    T t;
    return t;
}

// Using Test's generic method
int main() {
    Test t;
    std::cout << t.get<int>() << std::endl;
}
