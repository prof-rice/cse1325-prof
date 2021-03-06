#ifndef __MAINWIN_H
#define __MAINWIN_H

#include <gtkmm.h>
#include "canvas.h"

class Mainwin : public Gtk::Window {
  public:
    Mainwin(int width = 1000, int height= 1000);
    virtual ~Mainwin();
    Canvas* canvas() const;
  private:
    Canvas* _canvas;
};
#endif
