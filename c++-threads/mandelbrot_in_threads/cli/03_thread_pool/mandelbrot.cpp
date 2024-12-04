#include "mandelbrot.h"
#include <thread>
#include <vector>

const int MAX_COLOR = 255;

Mandelbrot::Mandelbrot(int width, int height, int icount, int nthreads) 
  : _width{width}, _height{height}, _icount{icount}, _row{0} {

    _values = new int[_width * _height];
    std::vector<std::thread*> threads;
    
    for(int i=0; i<nthreads; ++i) 
        threads.push_back(new std::thread{[this] {this->calculate_rows();}});
    
    for(auto t : threads) t->join();
}

Mandelbrot::~Mandelbrot() {delete[] _values;}

void Mandelbrot::calculate_rows () {
    int y;
    while(true) {
        m.lock(); y = _row++; m.unlock(); // access the next available row
        if (y >= _height) break;
        for (int x = 0; x < _width; x++) {
            calculate_point(x, y);
        }
    }
}

void Mandelbrot::calculate_point (int x, int y)  {
    std::complex<double> point{static_cast<double>(x) / static_cast<double>(_width)  - 1.5, 
                               static_cast<double>(y) / static_cast<double>(_height) - 0.5};
    std::complex<double> z(0, 0);
    int iterations = 0;
    while (std::abs(z) < 2 && iterations++ <= _icount) z = z*z + point;
    _values[y*_width+x] = (iterations < _icount) ? (MAX_COLOR*iterations)/_icount : 0;
}

std::ostream& operator<<(std::ostream& ost, const Mandelbrot& mandelbrot) {
    ost << "P3\n" << mandelbrot._width << ' ' << mandelbrot._height << ' ' << MAX_COLOR << '\n';
    for (int i = 0; i < mandelbrot._width * mandelbrot._height; i++) {
             ost << mandelbrot._values[i] << ' ' << 0 << ' ' << 0 << "\n";
    }
    return ost;
}

