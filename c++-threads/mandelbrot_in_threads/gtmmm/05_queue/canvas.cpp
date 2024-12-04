#include "canvas.h"

Canvas::Canvas(int width, int height) : _width{width}, _height{height}, q_active{true} {
    pixbuf = Gdk::Pixbuf::create(Gdk::COLORSPACE_RGB, false, 8, width, height);
    pixbuf->fill(0); // Initialize the pixbuf to black
    _thread = new std::thread{[this] {this->monitor_queue();}};  // Begin watching for incoming pixels
}

Canvas::~Canvas() {
    q_active = false; // Signal queue thread to exit
    _thread->join();  // Join the exiting thread
}

void Canvas::set_pixel(Pixel pixel) {
    q.push(pixel);
}

void Canvas::monitor_queue() {
    Gdk::Pixbuf& image = *pixbuf.operator->(); 
    while(q_active) {  // Exit when Canvas is deleted
        // Wait between checking for new pixels
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
        
        // Process all pixels available
        bool updated = false;
        while(auto opt = q.pop()) {
           Pixel pixel = *opt; // Extract the pixel
           int x = pixel.x();
           int y = pixel.y();
           guchar color = pixel.color();

           if ( ! image.get_colorspace() == Gdk::COLORSPACE_RGB ) continue;
           if ( ! image.get_bits_per_sample() == 8 ) continue;
           if ( !( x>=0 && y>=0 && x<image.get_width() && y<image.get_height() ) ) continue;

           int offset = y*image.get_rowstride() + x*image.get_n_channels();
           guchar* gupixel = &image.get_pixels()[ offset ]; // get pixel pointer
           gupixel[0] = color; // set the color
           updated = true;
       }
       if(updated) queue_draw(); // redraw after burst of pixel updates
   }
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

