#include "mainwin.h"

Mainwin::Mainwin(int width, int height) : _canvas{new Canvas(width,height)} {
  set_default_size(width, height);
  add(*_canvas);
  _canvas->show();
}

Mainwin::~Mainwin() { }
Canvas* Mainwin::canvas() const {return _canvas;}
