#ifndef __MAINWIN_H
#define __MAINWIN_H

#include <gtkmm.h>
#include "canvas.h"

class Mainwin : public Gtk::Window {
  public:
    Mainwin(int width = 500, int height= 500);
    virtual ~Mainwin();
    Canvas* canvas() const;
  private:
    Canvas* _canvas;
};
#endif
