#include "mandelbrot.h"
#include <thread>
#include <algorithm>
#include <random>       // std::default_random_engine
#include <chrono>       // std::chrono::system_clock

const int MAX_COLOR = 255;

Mandelbrot::Mandelbrot(int width, int height, int icount, int nthreads, bool pool, bool shuffle) 
  : _width{width}, _height{height}, _icount{icount}, _row{0}, _nthreads{nthreads}, _pool{pool} {
  
  // This simply randomizes the order of row processing for better visual effect
  // Set shuffle false to calculate in order
  for(int i=0; i<_height; ++i) _rows.push_back(i);
  if (shuffle) {
      unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
      std::shuffle(_rows.begin(), _rows.end(), std::default_random_engine(seed));
  }
}
  
void Mandelbrot::generate(Canvas* canvas) {
    _canvas = canvas;
    
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
}

Mandelbrot::~Mandelbrot() {}

void Mandelbrot::calculate_rows () {
    int y;
    while(true) {
/*
        // BUG: If we break within the lock, we deadlock. Simplest solution: lock_guard!
        m.lock();
        if(_row >= _rows.size()) break;  // <=====  BUG BUG BUG BUG BUG
        y = _rows[_row++]; 
        m.unlock(); // access the next available row

        A std::lock_guard grabs the lock in the constructor, and releases it in the destructor
        So when we go out of scope normally, via break, or even an exception, the lock is released!
*/
        {  // Scope of the lock
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
    std::complex<double> point{static_cast<double>(x) / static_cast<double>(_width)  - 1.5, 
                               static_cast<double>(y) / static_cast<double>(_height) - 0.5};
    std::complex<double> z(0, 0);
    int iterations = 0;
    while (std::abs(z) < 2 && iterations++ <= _icount) z = z*z + point;
    // _values[y*_width+x] = (iterations < _icount) ? (MAX_COLOR*iterations)/_icount : 0;
    s.lock();
    _canvas->set_pixel(x, y, (iterations < _icount) ? (MAX_COLOR*iterations)/_icount : 0);
    s.unlock();
}


