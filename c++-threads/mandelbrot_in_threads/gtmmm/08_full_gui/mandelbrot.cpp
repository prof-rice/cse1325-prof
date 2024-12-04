#include "mandelbrot.h"
#include "pixel.h"
#include <thread>
#include <algorithm>
#include <random>       // std::default_random_engine
#include <chrono>       // std::chrono::system_clock

const int MAX_COLOR = 255;

Mandelbrot::Mandelbrot(int width, int height, int icount, int nthreads, bool pool, bool shuffle) 
  : _width{width}, _height{height}, _icount{icount}, _row{0}, 
    _shuffle{shuffle}, _nthreads{nthreads}, _pool{pool},
    _scale{1.0}, _x_offset{0.0}, _y_offset{0.0}
     {
  
}
  
void Mandelbrot::generate(Canvas* canvas) {

    _canvas = canvas;
    
    // This simply randomizes the order of row processing for better visual effect
    // Set shuffle false to calculate in order
    _rows.clear();
    for(int i=0; i<_height; ++i) _rows.push_back(i);
    if (_shuffle) {
        unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
        std::shuffle(_rows.begin(), _rows.end(), std::default_random_engine(seed));
    }
    
    while(true) {
        _delta = false;  // Watch for changes to data

        _row = 0;

        std::vector<std::thread*> threads;
    
        // These two lines are only used with the full credit approach (a range of y per thread)
        const int y_range = _height / _nthreads;
        int y = 0;
    
        // We can either use a thread pool (bonus approach) or allocate a range of y per thread (full credit approach)
        // Uncomment exactly ONE of the two "threads.push_back" lines below
        // Recommend commenting out std::shuffle line above with full credit approach!
        for(int i=0; i<_nthreads; ++i) {
            if (_pool) threads.push_back(new std::thread{[this] {this->calculate_rows();}});
            else threads.push_back(new std::thread{[this, y, y_range] {this->calculate_rows(y, std::min(y+y_range, _height-1));}});
            y += y_range + 1;
        }
        for(auto t : threads) t->join();
        if(!_delta) break;
    }
}

Mandelbrot::~Mandelbrot() {}

void Mandelbrot::calculate_rows () {
    int y;
    while(true) {
        {
            const std::lock_guard<std::mutex> lock(m); 
            if(_row >= _rows.size()) break;
            y = _rows[_row++]; 
        }
        for (int x = 0; x < _width; x++) {
            calculate_point(x, y);
        }
    }
}

void Mandelbrot::calculate_rows (int y1, int y2) {
    for (int y = y1; y <= y2; y++)  {
        for (int x = 0; x < _width; x++) {
            calculate_point(x, y);
        }
    }
}

void Mandelbrot::calculate_point (int x, int y)  {
    double xs = ((static_cast<double>(x) - _width/2 + _x_offset/_scale) / static_cast<double>(_width))  * _scale   - 1.5;
    double ys = ((static_cast<double>(y) - _height/2 + _y_offset/_scale) / static_cast<double>(_height))  * _scale  - 0.5;

    std::complex<double> point{xs, ys};

    std::complex<double> z(0, 0);
    int iterations = 0;
    while (std::abs(z) < 2 && iterations++ <= _icount) z = z*z + point;
    Pixel pixel{x, y, (iterations < _icount) ? (MAX_COLOR*iterations)/_icount : 0};
    _canvas->set_pixel(pixel);
}

// Dynamically resize, scale, and translate the set

void Mandelbrot::icount(int value) {
    const std::lock_guard<std::mutex> lock(m); 
    _icount = value;
    _delta = true; // signal that data changed
}
int Mandelbrot::icount() {return _icount;}
    
void Mandelbrot::size(std::pair<int, int> value) {
    const std::lock_guard<std::mutex> lock(m); 
    _width = value.first;
    _height = value.second;
    _delta = true; // signal that data changed
}
std::pair<int, int> Mandelbrot::size() {
    return std::make_pair(_width, _height);
}

void Mandelbrot::scale(double value) {
    const std::lock_guard<std::mutex> lock(m); 
    _scale = value;
    _delta = true; // signal that data changed
}
double Mandelbrot::scale() {return _scale;}

void Mandelbrot::translate(std::pair<double, double> value) {
    const std::lock_guard<std::mutex> lock(m); 
    _x_offset = value.first;
    _y_offset = value.second;
    _delta = true; // signal that data changed
}
std::pair<double, double> Mandelbrot::translate() {
    return std::make_pair(_x_offset, _y_offset);
}

void Mandelbrot::nthreads(int value) {
    const std::lock_guard<std::mutex> lock(m); 
    _nthreads = value;
    _delta = true; // signal that data changed
}
int Mandelbrot::nthreads() {return _nthreads;}

