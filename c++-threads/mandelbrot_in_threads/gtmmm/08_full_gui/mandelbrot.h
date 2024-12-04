#ifndef __MANDELBROT_H
#define __MANDELBROT_H

#include <complex>
#include <mutex>
#include <vector>
#include "canvas.h"

class Mandelbrot {
  public:
    Mandelbrot(int width = 1000, int height = 1000, int icount = 60, int nthreads = 16, bool pool = 1, bool shuffle = 1);
    virtual ~Mandelbrot();
    Mandelbrot(const Mandelbrot&) = delete;            // per Rule of 3
    Mandelbrot& operator=(const Mandelbrot&) = delete; // per Rule of 3

    void size(std::pair<int, int> value);
    std::pair<int, int> size();
    void icount(int value);
    int icount();
    void scale(double value);
    double scale();
    void translate(std::pair<double, double> value);
    std::pair<double, double> translate();
    void nthreads(int value);
    int nthreads();
    
    void generate(Canvas* canvas);  // Do the Mandelbrot calculation

  protected:
    void calculate_point (int x, int y);
    void calculate_rows ();
    void calculate_rows (int y1, int y2);
    
  private:
    bool _delta;     // true when any data has changed
    
    int _width;      // image x size (adjust for runtime)
    int _height;     // image y size (adjust for runtime)
    int _icount;     // iteration count
    
    double _scale;    // used to zoom in on the Mandelbrot set
    double _x_offset; // added to x to translate view
    double _y_offset; // added to y to translate view
    
    int _nthreads;   // number of threads
    bool _pool;      // use a thread pool instead of y ranges
    bool _shuffle;   // shuffle rows for fade-in effect
    std::vector<int> _rows;
    int _row;        // used to coordinate threads
    std::mutex m;    // used to coordinate generation threads
    Canvas* _canvas; // where to draw the image
};

#endif
