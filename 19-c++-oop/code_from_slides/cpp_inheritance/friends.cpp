#include <iostream>

class Base {
  public:
    Base() : _i{42} { }
    friend class Derived;
    int i() {return -1;}
  private:
    int _i;
};

class Derived : public Base {
  public:
    Derived() : Base() { }
    int i() {return Base::_i;}
};

int main() {
    Derived d;
    std::cout << d.i() << std::endl; 
}
