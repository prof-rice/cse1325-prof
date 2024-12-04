#include "mainwin.h"
#include <iostream>

int main (int argc, char* argv[])  {
    // Instance the main window (gtkmm aborts if argc > 1)
    auto app = Gtk::Application::create(argc, argv, "edu.uta.cse1325.mm");
    Mainwin win{1000, 1000};
    
    // Run the GUI
    int result = app->run(win);
    
    // Return the GUI result to the OS
    return result;
}
