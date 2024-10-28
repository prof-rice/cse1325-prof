#include <iostream>
#include <vector>
#include <chrono>
#include <thread>

class Critter {
  public:
    Critter(int frequency) : _frequency{frequency}, _timer{0} { }
    void count() {if (++_timer > _frequency) _timer = 0;}
    void speak() { if (!_timer) std::cout << "Generic critter sound!" << std::endl; }
  protected:
    int _frequency;
    int _timer;
};
int main() {
  std::vector<Critter> critters{Critter{13}, Critter{11}, Critter{7}, Critter{3}};

  std::cout << "W E L C O M E   T O   T H E   B A R N Y A R D !" << std::endl;
  for (int i=0; i<120; ++i) {
    for (Critter& c: critters) { c.count(); c.speak(); }
    std::this_thread::sleep_for(std::chrono::milliseconds(50));
  }
}
