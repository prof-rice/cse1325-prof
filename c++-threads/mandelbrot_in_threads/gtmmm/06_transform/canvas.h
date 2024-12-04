#ifndef __CANVAS_H
#define __CANVAS_H

#include <gtkmm.h>
#include "pixel.h"
#include "queue.h"

#include <thread>

class Canvas : public Gtk::DrawingArea {
  public:
    Canvas(int width, int height);
    virtual ~Canvas();
    Canvas(const Canvas&) = delete;            // per Rule of 3
    Canvas& operator=(const Canvas&) = delete; // per Rule of 3

    void monitor_queue(); // thread
    void set_pixel(Pixel pixel);
  protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr) override;
  private:  
    Glib::RefPtr<Gdk::Pixbuf> pixbuf;
    int _width;
    int _height;
    Queue<Pixel> q;
    bool q_active; // false to shut down _thread
    std::thread* _thread;
};

#endif
