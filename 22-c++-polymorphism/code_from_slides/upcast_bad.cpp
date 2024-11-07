#include <iostream>

class Superclass {
  public:
    virtual std::string who_am_i() {
        return "Superclass";
    }
};

class Subclass : public Superclass {
  public:
    std::string who_am_i() override {
        return "Subclass";
    }
};

int main() {
    Subclass subclass{};
    std::cout << "Subclass   variable, Subclass object: " << subclass.who_am_i() << std::endl;

    // upcast
    Superclass superclass = subclass;
    std::cout << "Superclass variable, Subclass object: " << superclass.who_am_i() << std::endl;
}
