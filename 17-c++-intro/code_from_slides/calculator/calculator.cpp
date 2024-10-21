#include <iostream>

int main(int argc, char* argv[]) {
    try {
        if(argc % 2 != 0) throw new std::runtime_error("");
        int accumulator = atoi(argv[1]);
        int index = 2;
        while(index+1 < argc) {
            int operand = atoi(argv[index+1]);
            switch((unsigned char)argv[index][0]) {
                case '+': accumulator += operand; break;
                case '-': accumulator -= operand; break;
                case 'x': accumulator *= operand; break;
                case '÷': accumulator /= operand; break;
                default: throw new 
                    std::runtime_error(std::string("Bad operator ") 
                                      + argv[index]);
            }
            index += 2;
        }
        std::cout << accumulator << std::endl;
    } catch(...) {
        std::cerr << "usage: " << argv[0] << " n1 [op n2]..." << std::endl;
    }
}
