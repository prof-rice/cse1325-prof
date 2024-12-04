#ifndef __MANDELBROT_H
#define __MANDELBROT_H

#include <complex>

class Mandelbrot {
  public:
    Mandelbrot(int width = 1920, int height = 1080, int icount = 60, int nthreads = 1);
    ~Mandelbrot();                                     // per Rule of 3
    Mandelbrot(const Mandelbrot&) = delete;            // per Rule of 3
    Mandelbrot& operator=(const Mandelbrot&) = delete; // per Rule of 3
    friend std::ostream& operator<<(std::ostream& ost, const Mandelbrot& mandelbrot);

  protected:
    void calculate_point (int x, int y);
    void calculate_rows (int y1, int y2);
    
  private:
    int _width;    // image x size (adjust for runtime)
    int _height;   // image y size (adjust for runtime)
    int _icount;   // iteration count
    int* _values;  // array containing color values at y*width+x
};

#endif
