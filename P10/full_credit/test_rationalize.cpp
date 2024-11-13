#include <iostream>

int main(int argc, char* argv[]) {
    int _pounds = atoi(argv[1]);
    int _shillings = atoi(argv[2]);
    int _pence = atoi(argv[3]);
    
    int p = _pence + 12 * _shillings + 240 * _pounds;
    std::cout << "Total pence: " << p << std::endl;
    std::cout << "£" << p / 240 << " ";
    p %= 240;
    std::cout << p / 12 << "s";
    std::cout << p % 12 << "p" << std::endl;
}
