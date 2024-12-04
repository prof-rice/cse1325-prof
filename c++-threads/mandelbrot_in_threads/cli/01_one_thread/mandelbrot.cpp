#include "mandelbrot.h"

const int MAX_COLOR = 255;

Mandelbrot::Mandelbrot(int width, int height, int icount, int nthreads) 
  : _width{width}, _height{height}, _icount{icount} {

    // Allocate memory to hold the image
    _values = new int[_width * _height];
    
    // Calculate the image
    for (int y = 0; y < _height; y++)  {
        calculate_rows(y, y);
    }
}

// Deallocate the memory when decontructed
Mandelbrot::~Mandelbrot() {delete[] _values;}

// We loop through the rows in a separate method, anticipating these will
//   be allocated to threads soon!
void Mandelbrot::calculate_rows (int y1, int y2) {
    for (int y = y1; y <= y2; y++)  {
        for (int x = 0; x < _width; x++) {
            calculate_point(x, y);
        }
    }
}

// For a single point, select a color from 0 to 255 base on "escape iterations"
void Mandelbrot::calculate_point (int x, int y)  {
    std::complex<double> point{static_cast<double>(x) / static_cast<double>(_width)  - 1.5, 
                               static_cast<double>(y) / static_cast<double>(_height) - 0.5};
    std::complex<double> z(0, 0);
    int iterations = 0;
    while (std::abs(z) < 2 && iterations++ <= _icount) z = z*z + point;
    _values[y*_width+x] = (iterations < _icount) ? (MAX_COLOR*iterations)/_icount : 0;
}

// Stream out a Plain Portable Pix Map (ppm) for the calculated image
std::ostream& operator<<(std::ostream& ost, const Mandelbrot& mandelbrot) {
    ost << "P3\n" << mandelbrot._width << ' ' << mandelbrot._height << ' '<< MAX_COLOR << '\n';
    for (int i = 0; i < mandelbrot._width * mandelbrot._height; i++) {
             ost << mandelbrot._values[i] << ' ' << 0 << ' ' << 0 << "\n";
    }
    return ost;
}

