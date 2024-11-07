// IMPORTANT: You MUST install the FLTK to build this - see https://www.fltk.org/

#include <FL/Fl.H>
#include <FL/Fl_Window.H>
#include <FL/Fl_Button.H>

// Handle sending commands to child when button pressed
void HandleButton_CB(Fl_Widget*, void* data) {
    std::cout << static_cast<std::string*>(data) << std::endl; 
}

class MyApp {
  public:
    MyApp() {
        win = new Fl_Window(720, 486);
        Fl_Button a(10, 10, 20, 20, "A"); a.callback(HandleButton_CB, (void*)"a\n");
        Fl_Button b(30, 10, 20, 20, "B"); b.callback(HandleButton_CB, (void*)"b\n");
        Fl_Button c(50, 10, 20, 20, "C"); c.callback(HandleButton_CB, (void*)"c\n");
        Fl_Button q(70, 10, 20, 20, "q"); q.callback(CleanExit_CB,    (void*)"q\n");  
        win->end();
        win->show();
    }
};

// MAIN
int main() {
    MyApp app;
    return(Fl::run());
}
