#include<iostream>
 
class A {
  public: 
    A()  { std::cout << "A's constructor called" << std::endl;}
    ~A() { std::cout << "A's destructor called" << std::endl;}
};
 
class B {
  public: 
    B()  {std::cout << "B's constructor called" << std::endl;}
    ~B() {std::cout << "B's destructor called" << std::endl;}
};
 
class C: public A, public B {
  public: 
    C()  {std::cout << "C's constructor called" << std::endl;}
    ~C() {std::cout << "C's destructor called" << std::endl;}
};
 
int main() {
    C c;
}
