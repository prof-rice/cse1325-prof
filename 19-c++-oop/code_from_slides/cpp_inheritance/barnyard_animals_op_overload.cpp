#include <iostream>
#include <vector>
#include <chrono>
#include <thread>
#include <ostream>

class Critter {
  public:
    Critter(int frequency) : _frequency{frequency}, _timer{0} { }
    void count() {if (++_timer > _frequency) _timer = 0;}
    std::string speak() { if (!_timer) return "Generic critter sound!\n"; 
                     else return ""; }
  protected:
    int _frequency;
    int _timer;
};
std::ostream& operator<<(std::ostream& os, const Critter& critter) {
  os << critter.speak();
  return os;
}
int main() {
  std::vector<Critter> critters = {Critter{11}, Critter{9}, Critter{3}};

  std::cout << "W E L C O M E   T O   T H E   B A R N Y A R D !" << std::endl;
  for (int i=0; i<120; ++i) {
    for (auto& c: critters) { c.count(); std::cout << c; }
    std::this_thread::sleep_for(std::chrono::milliseconds(50));
  }
}
