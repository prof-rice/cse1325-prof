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
    Superclass* superclass = new Subclass{};
    std::cout << "Superclass variable, Subclass object: " << superclass->who_am_i() << std::endl;
    
    // Downcast directly
    Subclass* subclass = superclass;
    std::cout << "Subclass   variable, Subclass object: " << subclass->who_am_i() << std::endl;
}
