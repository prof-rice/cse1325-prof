#include <iostream>
#include <fstream>
#include <cstring>
#include "mandelbrot.h"

int main (int argc, char* argv[])  {
    // Specify default image size, iteration count, and filename 
    // Usually, width == height to avoid distortion
    // Higher iteration counts (up to 255) increase resolution
    int width = 1000;
    int height = 1000;
    int icount = 60;
    int nthreads = 1;
    std::string image = "image.ppm";
    
    // Parse the command line, overwriting defaults as needed
    try {
        if(argc > 1 && !strcmp(argv[1], "-h")) {
            std::cerr << "usage: " << argv[0] << " [width [height [icount [nthreads [image]]]]]"
                << "\n  width x height is the size of the image in pixels (default " << width << 'x' << height
                << ")\n  icount is the resolution of pixels (default " << icount
                << ")\n  nthreads is number of threads (default " << nthreads
                << ")\n  image is the filename to generate in PPM 3 format (default " << image
                << ")\n";
            return 0;
        }
        if(argc > 1) width  = std::atoi(argv[1]);
        if(argc > 2) height = std::atoi(argv[2]);
        else height = width;
        if(argc > 3) icount = std::atoi(argv[3]);
        if(argc > 4) nthreads = std::atoi(argv[4]);
        if(argc > 5) image  = std::string(argv[5]);
    } catch(std::exception& e) {
        std::cerr << "Invalid arguments: -h for usage\n";
        return -2;
    }
    
    // Show the image to be generated
    std::cout << "\n\n  width: " << width 
              << "  height: " << height
              << "  icount: " << icount 
              << "  threads: " << nthreads
              << std::endl;
    
    // Instance a Mandelbrot fractal and write it to the file
    std::ofstream output{image};
    if(output) {
        Mandelbrot m{width, height, icount, nthreads};
        output << m << std::endl;
        std::cout << "  wrote: " << image << std::endl;
        return 0;
    } else {
        std::cerr << "Could not open " << image << std::endl;
        return -1;
    }
}
