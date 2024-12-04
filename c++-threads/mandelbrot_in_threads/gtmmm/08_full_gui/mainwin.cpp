#include "mainwin.h"
#include <cmath>

Mainwin::Mainwin(int width, int height) 
  : _canvas{new Canvas(width,height)},
    _mandelbrot{new Mandelbrot{width, height}},
    _generate{Gen::WAIT} {
    
    set_default_size(width, height);
    set_title("Mandelbrot Magic");
  
    // Put a vertical box container as the Window contents
    Gtk::Box *vbox = Gtk::manage(new Gtk::VBox);
    add(*vbox);

    // /////// ////////////////////////////////////////////////////////////////
    // M E N U
    // Add a menu bar as the top item in the vertical box
    Gtk::MenuBar *menubar = Gtk::manage(new Gtk::MenuBar);
    vbox->pack_start(*menubar, Gtk::PACK_SHRINK, 0);

    //     F I L E
    // Create a File menu and add to the menu bar
    Gtk::MenuItem *menuitem_file = Gtk::manage(new Gtk::MenuItem("_File", true));
    menubar->append(*menuitem_file);
    Gtk::Menu *filemenu = Gtk::manage(new Gtk::Menu());
    menuitem_file->set_submenu(*filemenu);

    //         Q U I T
    // Append Quit to the File menu
    Gtk::MenuItem *menuitem_quit = Gtk::manage(new Gtk::MenuItem("_Quit", true));
    menuitem_quit->signal_activate().connect([this] {this->on_quit_click();});
    filemenu->append(*menuitem_quit);

    //     H E L P
    // Create a Help menu and add to the menu bar
    Gtk::MenuItem *menuitem_help = Gtk::manage(new Gtk::MenuItem("_Help", true));
    menubar->append(*menuitem_help);
    Gtk::Menu *helpmenu = Gtk::manage(new Gtk::Menu());
    menuitem_help->set_submenu(*helpmenu);

    //           A B O U T
    // Append About to the Help menu
    Gtk::MenuItem *menuitem_about = Gtk::manage(new Gtk::MenuItem("_About", true));
    menuitem_about->signal_activate().connect([this] {this->on_about_click();});
    helpmenu->append(*menuitem_about);

    // ///////////// //////////////////////////////////////////////////////////
    // T O O L B A R
    // 
    // Add a toolbar to the vertical box below the menu
    // Gtk::Toolbar *toolbar = Gtk::manage(new Gtk::Toolbar);
    // vbox->pack_start(*toolbar, Gtk::PACK_SHRINK, 0);
    
    Gtk::Box* toolbar = Gtk::manage(new Gtk::HBox{false, 5});
    vbox->pack_start(*toolbar, Gtk::PACK_SHRINK, 0);
    
    //     S C A L E
    // Add a Gtk::Scale to zoom in on the Mandelbrot image
    Gtk::Label* l_scale = Gtk::manage(new Gtk::Label{"Zoom: "});
    toolbar->pack_start(*l_scale, Gtk::PACK_SHRINK, 0);
    
    _scale_label = Gtk::manage(new Gtk::Label{"1.00"});
    toolbar->pack_start(*_scale_label, Gtk::PACK_SHRINK, 0);
    
    _scale = Gtk::manage(new Gtk::Scale);
    _scale->set_range(0.31622776601, 10.0);
    _scale->set_increments(0.1, 1.0);
    _scale->set_draw_value(false);
    _scale->signal_value_changed().connect([this] {this->on_scale_value_changed();});
    toolbar->add(*_scale);

    //     X - O F F S E T
    // Add a Gtk::Scale to offset the the Mandelbrot image on the X axis
    Gtk::Label* l_xoff = Gtk::manage(new Gtk::Label{"X Offset: "});
    toolbar->pack_start(*l_xoff, Gtk::PACK_SHRINK, 0);
    
    _xoff_label = Gtk::manage(new Gtk::Label{"0"});
    toolbar->pack_start(*_xoff_label, Gtk::PACK_SHRINK, 0);
    
    _xoff = Gtk::manage(new Gtk::Scale);
    _xoff->set_range(-100, 100.0);
    _xoff->set_increments(0.1, 10.0);
    _xoff->set_draw_value(false);
    _xoff->signal_value_changed().connect([this] {this->on_xoff_value_changed();});
    toolbar->add(*_xoff);

    //     Y - O F F S E T
    // Add a Gtk::Scale to offset the the Mandelbrot image on the Y axis
    Gtk::Label* l_yoff = Gtk::manage(new Gtk::Label{"Y Offset: "});
    toolbar->pack_start(*l_yoff, Gtk::PACK_SHRINK, 0);
    
    _yoff_label = Gtk::manage(new Gtk::Label{"0"});
    toolbar->pack_start(*_yoff_label, Gtk::PACK_SHRINK, 0);
    
    _yoff = Gtk::manage(new Gtk::Scale);
    _yoff->set_range(-100, 100.0);
    _yoff->set_increments(0.1, 10.0);
    _yoff->set_draw_value(false);
    _yoff->signal_value_changed().connect([this] {this->on_xoff_value_changed();});
    toolbar->add(*_yoff);
    
    //     I C O U N T
    // Add an icount spin button
    _icount = Gtk::manage(new Gtk::SpinButton);
    _icount->set_range(0.0, 1000.0);
    _icount->set_increments(1.0, 20.0);
    _icount->set_value(_mandelbrot->icount());
    _icount->signal_value_changed().connect([this] {this->on_icount_value_changed();});
    toolbar->pack_start(*_icount, Gtk::PACK_SHRINK, 0);
    
    //     A U T O G E N E R A T E
    // Add an autoautogen Mandelbrot icon
    Gtk::Image* autogen_image = Gtk::manage(new Gtk::Image{"autogen.png"});
    _autogen_button = Gtk::manage(new Gtk::ToggleToolButton(*autogen_image));
    _autogen_button->set_tooltip_markup("Regenerate the image on changes");
    _autogen_button->set_active(false);
    toolbar->pack_start(*_autogen_button, Gtk::PACK_SHRINK, 0);

    //     G E N E R A T E
    // Add a generate Mandelbrot icon
    Gtk::Image* generate_image = Gtk::manage(new Gtk::Image{"generate.png"});
    Gtk::ToolButton *generate_button = Gtk::manage(new Gtk::ToolButton(*generate_image));
    generate_button->set_tooltip_markup("Generate the image");
    generate_button->signal_clicked().connect([this] {this->on_generate_click();});
    toolbar->pack_start(*generate_button, Gtk::PACK_SHRINK, 0);

    // /////////////////////////// ////////////////////////////////////////////
    // C A N V A S   D I S P L A Y
    _canvas->set_hexpand(true);
    _canvas->set_vexpand(true);
    vbox->add(*_canvas);

    // Make the box and everything in it visible
    vbox->show_all();
    
    // Launch thread to poll for generate events
    _gthread = new std::thread([&] {
        while(_generate != Gen::EXIT) {
            std::this_thread::sleep_for(std::chrono::milliseconds(100));
            if(_generate == Gen::GENERATE) {
                _mandelbrot->generate(_canvas);
                _generate = Gen::WAIT;
            }
        }
    });

    // Set initial view    
    _xoff->set_value(0);
    _yoff->set_value(-22.4);
    _scale->set_value(1.0);
}

Mainwin::~Mainwin() {
    _generate = Gen::EXIT;
    _gthread->join();
 }

Canvas* Mainwin::canvas() const {return _canvas;}

void Mainwin::on_scale_value_changed() {
    double sp = _scale->get_value();
    sp = std::max(0.1, sp*sp);
    _scale_label->set_text(std::to_string(sp).substr(0,4));
    _mandelbrot->scale(1.0/sp);
    
    // If in autogen mode, request a regenerate
    if(_autogen_button->get_active()) _generate = Gen::GENERATE;
}

void Mainwin::on_xoff_value_changed() {
    double x = -_xoff->get_value();
    x = abs(x) * abs(x) * ((x < 0.0) ? -1 : 1);
    _xoff_label->set_text(std::to_string(int{x}));

    double y = -_yoff->get_value();
    y = abs(y) * abs(y) * ((y < 0.0) ? -1 : 1);
    _yoff_label->set_text(std::to_string(int{y}));

    _mandelbrot->translate(std::make_pair(x, y));
    
    // If in autogen mode, request a regenerate
    if(_autogen_button->get_active()) _generate = Gen::GENERATE;
}

void Mainwin::on_icount_value_changed() {
    int i = _icount->get_value();
    _mandelbrot->icount(i);
    
    // If in autogen mode, request a regenerate
    if(_autogen_button->get_active()) _generate = Gen::GENERATE;

}

void Mainwin::on_generate_click() {
    _generate = Gen::GENERATE;
}

void Mainwin::on_about_click() {
    Gtk::AboutDialog dialog;
    dialog.set_transient_for(*this); // Avoid the discouraging warning
    dialog.set_program_name(TITLE);
    auto logo = Gdk::Pixbuf::create_from_file("mm_logo.png");
    dialog.set_logo(logo);
    dialog.set_version("Version " + VERSION);
    dialog.set_copyright("Copyright " + COPYRIGHT);
    dialog.set_license_type(Gtk::License::LICENSE_GPL_3_0);
    std::vector< Glib::ustring > authors = {"George F. Rice"};
    dialog.set_authors(authors);
    std::vector< Glib::ustring > artists = {
        "Icons made by  Freepik https://www.flaticon.com", 
    };
    dialog.set_artists(artists);
    dialog.run();
}

void Mainwin::on_quit_click() {
    close();
}


