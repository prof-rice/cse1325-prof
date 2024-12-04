#include "pixel.h"

Pixel::Pixel(int x, int y, guchar color)
  : _x{x}, _y{y}, _color{color} { }
int Pixel::x() {return _x;}
int Pixel::y() {return _y;}
guchar Pixel::color() {return _color;}

