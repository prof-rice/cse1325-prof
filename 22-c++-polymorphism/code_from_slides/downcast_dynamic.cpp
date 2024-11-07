#include <iostream>

class Superclass {
  public: virtual void hi() {std::cout << "Superclass" << std::endl;}
};

class A : public Superclass {
  public: void hi() override {std::cout << "A" << std::endl;}
};

class B : public Superclass {
  public: void hi() override {std::cout << "B" << std::endl;}
};

int main() {
  Superclass* a = new A;       // Superclass variable points to subclass object (polymorphism!)

  A* a1 = (A*)(a);             // Compiles, perfectly valid
  if (a1 == nullptr) std::cout << "a1 is null" << std::endl;
  else a1->hi();

  A* a2 = static_cast<A*>(a);  // Compiles, perfectly valid
  if (a2 == nullptr) std::cout << "a2 is null" << std::endl;
  else a2->hi();

  A* a3 = dynamic_cast<A*>(a); // Compiles, perfectly valid but a little slower
  if (a3 == nullptr) std::cout << "a3 is null" << std::endl;
  else a3->hi();

                               // Now (incorrectly!) cast A object to B variable
  B* b1 = (B*)(a);             // Compiles, but undefined - A is not a B
  if (b1 == nullptr) std::cout << "b1 is null" << std::endl;
  else b1->hi();

  B* b2 = static_cast<B*>(a);  // Compiles, but undefined - A is not a B
  if (b2 == nullptr) std::cout << "b2 is null" << std::endl;
  else b2->hi();

  B* b3 = dynamic_cast<B*>(a); // ERROR - A is not a B, b3 is null
  if (b3 == nullptr) std::cout << "b3 is null" << std::endl;
  else b3->hi();
}
