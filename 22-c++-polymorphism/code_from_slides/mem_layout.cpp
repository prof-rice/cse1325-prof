#include <iostream>

class Parent{
public:
    int a, b;
    virtual void foo(){std::cout << "parent" << std::endl;}
};

class Child : public Parent {
public:
    int c, d;
    virtual void foo()
      {std::cout << "child" << std::endl;}
};

int main() {
    Parent p; p.foo();
    Child c; c.foo();

    std::cout << "Parent Offset a = " << (size_t)&p.a - (size_t)&p << std::endl;
    std::cout << "Parent Offset b = " << (size_t)&p.b - (size_t)&p << std::endl;

    std::cout << "Child Offset a = " << (size_t)&c.a - (size_t)&c << std::endl;
    std::cout << "Child Offset b = " << (size_t)&c.b - (size_t)&c << std::endl;
    std::cout << "Child Offset c = " << (size_t)&c.c - (size_t)&c << std::endl;
    std::cout << "Child Offset d = " << (size_t)&c.d - (size_t)&c << std::endl;
}

