#include "canvas.h"

Canvas::Canvas(int width, int height) : _width{width}, _height{height} {
    pixbuf = Gdk::Pixbuf::create(Gdk::COLORSPACE_RGB, false, 8, width, height);
    pixbuf->fill(0); // Initialize the pixbuf to black
}

void Canvas::set_pixel(int x, int y, guchar color) {
   Gdk::Pixbuf & image = *pixbuf.operator->(); // just for convenience

   if ( ! image.get_colorspace() == Gdk::COLORSPACE_RGB ) return;
   if ( ! image.get_bits_per_sample() == 8 ) return;
   if ( !( x>=0 && y>=0 && x<image.get_width() && y<image.get_height() ) ) return;

   int offset = y*image.get_rowstride() + x*image.get_n_channels();
   guchar * pixel = &image.get_pixels()[ offset ]; // get pixel pointer
   pixel[0] = color; // set the color

   // NOTE: Assumes rows are generated left to right (0 to _width-1)
   if(x == _width-1) queue_draw(); // redraw after modify
}

bool Canvas::on_draw(const Cairo::RefPtr<Cairo::Context>& cr) {
    // Create a Cairomm context to manage our drawing
    Gtk::Allocation allocation = get_allocation();

    const double width = allocation.get_width();
    const double height = allocation.get_height();
    //cr->translate(width / 2, height / 2);

    Gdk::Cairo::set_source_pixbuf(cr, pixbuf,
      (width - pixbuf->get_width())/2, (height - pixbuf->get_height())/2);

    // Apply the colors to the window
    cr->paint();

    // Drawing was successful
    return true;
}

