#include <iostream>
#include <fstream>

int main(int argc, char* argv[]) {
    std::ofstream ofs {std::string{argv[1]}};
    if (!ofs) throw std::runtime_error{"can’t open output file"};
    ofs << "Writing this to " << argv[1] << std::endl;
}
