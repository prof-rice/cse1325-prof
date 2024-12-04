#ifndef __MANDELBROT_H
#define __MANDELBROT_H

#include <complex>
#include <mutex>
#include <vector>
#include "canvas.h"

class Mandelbrot {
  public:
    Mandelbrot(int width = 1920, int height = 1080, int icount = 60, int nthreads = 1, bool pool = 1, bool shuffle = 0);
    ~Mandelbrot();
    Mandelbrot(const Mandelbrot&) = delete;            // per Rule of 3
    Mandelbrot& operator=(const Mandelbrot&) = delete; // per Rule of 3
    void generate(Canvas* canvas);  // Do the Mandelbrot calculation

  protected:
    void calculate_point (int x, int y);
    void calculate_rows ();
    void calculate_rows (int y1, int y2);
    
  private:
    int _width;      // image x size (adjust for runtime)
    int _height;     // image y size (adjust for runtime)
    int _icount;     // iteration count
    int _nthreads;   // number of threads
    bool _pool;      // use a thread pool instead of y ranges
    std::vector<int> _rows;
    int _row;        // used to coordinate threads
    std::mutex m;    // used to coordinate generation threads
    std::mutex s;    // used to coordinate setting threads
    Canvas* _canvas; // where to draw the image
};

#endif
