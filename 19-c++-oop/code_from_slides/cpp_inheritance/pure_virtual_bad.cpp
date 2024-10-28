#include <iostream>

class A {
  public:
    virtual void m() = 0;
};

class B : public A {
  public:
    virtual void x();
};

void B::x() {std::cout << "x of B" << std::endl;}

int main() {
  A a;
  B b;
  b.x();
}

