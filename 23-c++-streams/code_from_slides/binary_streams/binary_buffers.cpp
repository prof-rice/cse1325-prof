#include <iostream>
#include <fstream>

int main() {
    const int BUFFER_SIZE = 1024;
    std::string filename; 
    std::cout << "Source file to copy: ";
    std::getline(std::cin, filename);

    std::ifstream ifs {filename,std::ios_base::binary};  // note: binary
    if (!ifs) {std::cerr << "Can't open " << filename << std::endl; return -1;}

    std::cout << "Target file for copy: ";
    std::getline(std::cin, filename);
    std::ofstream ofs {filename, std::ios_base::binary};	// note: binary
    if (!ofs) {std::cerr << "Can't open output file: aborted" << std::endl; return -2;}

    char buffer[BUFFER_SIZE];
    while(ifs) {
        ifs.read(buffer, BUFFER_SIZE);
        if (ifs.gcount()) {
            ofs.write(buffer, ifs.gcount());
            if (!ofs) {std::cerr << "File write error: aborted" << std::endl; return -4;}
        }
        std::cout << "Copied " << ifs.gcount() << " bytes" << std::endl;
    }
    if (!ifs.eof()) {std::cerr << "Source file read error" << std::endl; return -3;}
    return 0;
}
