#include <iostream>
#include <vector>

class Rando {
  public:
    Rando() {
        std::cerr << "Constructing v" << std::endl;
        v = new std::vector<int>;
        for(int i=0; i< 100; ++i) v->push_back(rand() % 100);
    }
    ~Rando() {
        std::cerr << "Destructing v" << std::endl;
        delete v;
    }
    void printv() {
        for(int i : *v) 
            std::cout << i << ' ';
        std::cout << std::endl;
    }
  private:
    std::vector<int>* v;
};

int main() {
    Rando r;
    r.printv();
}
