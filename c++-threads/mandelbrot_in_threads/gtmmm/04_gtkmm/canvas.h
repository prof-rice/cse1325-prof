#ifndef __CANVAS_H
#define __CANVAS_H

#include <gtkmm.h>

class Canvas : public Gtk::DrawingArea {
  public:
    Canvas(int width, int height);
    void set_pixel(int x, int y, guchar color);
  protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr) override;
  private:  
    Glib::RefPtr<Gdk::Pixbuf> pixbuf;
    int _width;
    int _height;
};

#endif
