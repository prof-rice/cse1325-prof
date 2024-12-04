#ifndef __PIXEL_H
#define __PIXEL_H

#include <gtkmm.h>

class Pixel  {
  public:
    Pixel(int x, int y, guchar color);
    int x();
    int y();
    guchar color();
  private:  
    int _x;
    int _y;
    guchar _color;
};

#endif
