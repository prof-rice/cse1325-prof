#include <iostream>


class A {
  public:
    virtual void m() {std::cout << "m of A" << std::endl;}
};

class B : virtual public A {
  public:
    virtual void m() override {std::cout << "m of B" << std::endl;}
};

class C : virtual public A { };
    
class D : public B, public C { };

int main() {
  D d;
  d.A::m();
  d.B::m();
  d.C::m();
}
