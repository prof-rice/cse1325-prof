#include <iostream>
#include <vector>
#include <chrono>
#include <thread>

class Critter {
  public:
    Critter(int frequency) : _frequency{frequency}, _timer{0} { }
    void count() {if (++_timer > _frequency) _timer = 0;}
    virtual void speak() { if (!_timer) std::cout << "Generic critter sound!" << std::endl; }
  protected:
    int _frequency;
    int _timer;
};

class Cow : public Critter {
  public:
    Cow(int frequency) : Critter(frequency) { }
    void speak() override { if (!_timer) std::cout << "Moo! Mooooo!" << std::endl; }
};

class Dog : public Critter {
  public:
    Dog(int frequency) : Critter(frequency) { }
    void speak() override { if (!_timer) std::cout << "Woof! Woof!" << std::endl; }
};

class Chicken : public Critter {
  public:
    Chicken(int frequency) : Critter(frequency) { }
    void speak() override { if (!_timer) std::cout << "Cluck! Cluck!" << std::endl; }
};

int main() {
  std::vector<Critter*> critters = {new Dog{11},    new Dog{9},   new Dog{3},
                                    new Cow{7},     new Cow{13},
                                    new Chicken{2}, new Chicken{5}};

  std::cout << "W E L C O M E   T O   T H E   B A R N Y A R D !" << std::endl;
  for (int i=0; i<120; ++i) {
    for (auto c: critters) { c->count(); c->speak(); }
    std::this_thread::sleep_for(std::chrono::milliseconds(50));
  }
}
