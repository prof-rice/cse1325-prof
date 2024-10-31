#include <iostream>


class A {
  public:
    virtual void m() {std::cout << "m of A" << std::endl;}
};

class B : public A {
  public:
    virtual void m() override {std::cout << "m of B" << std::endl;}
};

class C : public A { };
    
class D : public B, public C { };

int main() {
  D d;
  d.m();
}
