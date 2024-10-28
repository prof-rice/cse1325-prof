#include <iostream>

class A {
  public:
    virtual void m() = 0;
};

class B : public A {
  public:
    virtual void x();
    virtual void m() override;
};

void B::x() {std::cout << "x of B" << std::endl;}
void B::m() {std::cout << "m of B" << std::endl;}

int main() {
  B b;
  b.x();
  b.m();
}

