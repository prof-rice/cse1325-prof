#ifndef __MAINWIN_H
#define __MAINWIN_H

#include <gtkmm.h>
#include "canvas.h"
#include "mandelbrot.h"

const std::string TITLE = "Mandelbrot Magic"; 
const std::string VERSION = "0.7.0";
const std::string COPYRIGHT = "2021";

enum class Gen {WAIT, GENERATE, EXIT};

class Mainwin : public Gtk::Window {
  public:
    Mainwin(int width = 1000, int height= 1000);
    virtual ~Mainwin();                          // per Rule of 3
    Mainwin(const Mainwin&) = delete;            // per Rule of 3
    Mainwin& operator=(const Mainwin&) = delete; // per Rule of 3
    Canvas* canvas() const;
  protected:
    void on_scale_value_changed();
    void on_generate_click();
    void on_about_click();
    void on_quit_click();
  private:
    Canvas* _canvas;
    Mandelbrot* _mandelbrot;
    
    Gtk::Scale* _scale;
    Gtk::Label* _scale_label;
    
    Gen _generate; // controls generate thread
    std::thread* _gthread;  // generate thread
};
#endif
