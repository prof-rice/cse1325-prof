#include "vector.h"
#include <iostream>

int main() {
    // Test with int
    const int SIZE = 10;
    Vector<int> vi;
    for (int i=0; i<SIZE; ++i)
        vi.push_back(i*i);

    if (vi.back() != 81)
        std::cerr << "FAIL: v.back() is " << vi.back()
                      << " instead of 81" << std::endl;

    for (int i=vi.size()-1; i>=0; --i) {
        if (vi[i] != i*i) {
            std::cerr << "FAIL: stored " << vi[i]
                      << " instead of " << i*i << std::endl;
        }
    }

    vi[5] = 42;
    if (vi[5] != 42)
        std::cerr << "FAIL: set vi[5] to 42 but is " << vi[5]
                  << " instead" << std::endl;

    // Test with string
    const int SIZES = 5;
    Vector<std::string> vs{SIZES};
    vs.push_back("Hello, world!");
    vs.push_back("Farewell, cruel world!");

    if(vs[0] != "Hello, world!")
        std::cerr << "FAIL: v[0] was " << vs[0]
                  << "instead of 'Hello, world!'" << std::endl;
    if(vs[1] != "Farewell, cruel world!")
        std::cerr << "FAIL: v[0] was " << vs[1]
                  << "instead of 'Farewell, cruel world!'" << std::endl;

    vs[0] = "Hang in there, world!";
    if(vs[0] != "Hang in there, world!")
        std::cerr << "FAIL: v[0] was " << vs[0]
                  << "instead of 'Hang in there, world!'" << std::endl;

}
