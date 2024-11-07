#include <iostream>

namespace Jack {
  class Glob { /*…*/ };     
  class Widget { /*…*/ };
}

class Foo {public: std::string speak() {return "Default!";}};  // In default namespace
class Bar { /*…*/ };

namespace Jack {
  class Foo {public: std::string speak() {return "Jack!";}};
  class Bar { /*…*/ }; // Jack contains 4 classes now
}

int main() {
    Foo f;
    Jack::Foo jf;
    std::cout << "Default namespace foo says " << f.speak() << std::endl;
    std::cout << "Jack's foo says " << jf.speak() << std::endl;
}
