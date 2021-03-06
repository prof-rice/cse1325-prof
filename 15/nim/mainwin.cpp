#include "mainwin.h"

Mainwin::Mainwin() {

    // /////////////////
    // G U I   S E T U P
    // /////////////////

    set_default_size(400, 200);
    set_title("Nim");

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

    //         N E W   G A M E
    // Append New to the File menu
    Gtk::MenuItem *menuitem_new = Gtk::manage(new Gtk::MenuItem("_New Game", true));
    menuitem_new->signal_activate().connect([this] {this->on_new_game_click();});
    filemenu->append(*menuitem_new);

    //         S A V E   G A M E
    // Append Save As... to the File menu
    Gtk::MenuItem *menuitem_save_as = Gtk::manage(new Gtk::MenuItem("Save _As", true));
    menuitem_save_as->signal_activate().connect([this] {this->on_save_as_click();});
    filemenu->append(*menuitem_save_as);

    //         O P E N   G A M E
    // Append Open... to the File menu
    Gtk::MenuItem *menuitem_open = Gtk::manage(new Gtk::MenuItem("_Open", true));
    menuitem_open->signal_activate().connect([this] {this->on_open_click();});
    filemenu->append(*menuitem_open);

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

    //           R U L E S
    // Append Rules to the Help menu
    Gtk::MenuItem *menuitem_rules = Gtk::manage(new Gtk::MenuItem("_Rules", true));
    menuitem_rules->signal_activate().connect([this] {this->on_rules_click();});
    helpmenu->append(*menuitem_rules);

    //           A B O U T
    // Append About to the Help menu
    Gtk::MenuItem *menuitem_about = Gtk::manage(new Gtk::MenuItem("_About", true));
    menuitem_about->signal_activate().connect([this] {this->on_about_click();});
    helpmenu->append(*menuitem_about);

    // ///////////// //////////////////////////////////////////////////////////
    // T O O L B A R
    // Add a toolbar to the vertical box below the menu
    Gtk::Toolbar *toolbar = Gtk::manage(new Gtk::Toolbar);
    vbox->add(*toolbar);

    //     N E W   G A M E
    // Add a new game icon
    Gtk::ToolButton *new_game_button = Gtk::manage(new Gtk::ToolButton(Gtk::Stock::NEW));
    new_game_button->set_tooltip_markup("Create a new game, discarding any in progress");
    new_game_button->signal_clicked().connect([this] {this->on_new_game_click();});
    toolbar->append(*new_game_button);

    //     O N E   S T I C K
    // Add an icon for taking one stick - NEW
    Gtk::Image* button1_image = Gtk::manage(new Gtk::Image{"button1_on.png"});
    button1 = Gtk::manage(new Gtk::ToolButton(*button1_image));
    button1->set_tooltip_markup("Select one stick");
    button1->signal_clicked().connect([this] {this->on_button_click(1);});
    toolbar->append(*button1);

    //     T W O   S T I C K S
    // Add an icon for taking two sticks - NEW
    Gtk::Image* button2_image = Gtk::manage(new Gtk::Image{"button2_on.png"});
    button2 = Gtk::manage(new Gtk::ToolButton(*button2_image));
    button2->set_tooltip_markup("Select two sticks");
    button2->signal_clicked().connect([this] {this->on_button_click(2);});
    toolbar->append(*button2);

    //     T H R E E   S T I C K S
    // Add an icon for taking three sticks - NEW
    Gtk::Image* button3_image = Gtk::manage(new Gtk::Image{"button3_on.png"});
    button3 = Gtk::manage(new Gtk::ToolButton(*button3_image));
    button3->set_tooltip_markup("Select three sticks");
    button3->signal_clicked().connect([this] {this->on_button_click(3);});
    toolbar->append(*button3);

    //     C O M P U T E R   P L A Y E R
    // Add a toggle button to enable computer to play as Player 2
    Gtk::Image *robot_image = Gtk::manage(new Gtk::Image{"freepik_robot.png"});
    computer_player = Gtk::manage(new Gtk::ToggleToolButton(*robot_image));
    computer_player->set_tooltip_markup("Enable for computer to be Player 2");
    computer_player->signal_clicked().connect([this] {this->on_computer_player_click();});
    Gtk::SeparatorToolItem *sep1 = Gtk::manage(new Gtk::SeparatorToolItem());
    toolbar->append(*sep1);
    toolbar->append(*computer_player);

    //     Q U I T
    // Add a icon for quitting
    Gtk::ToolButton *quit_button = Gtk::manage(new Gtk::ToolButton(Gtk::Stock::QUIT));
    quit_button->set_tooltip_markup("Exit game");
    quit_button->signal_clicked().connect([this] {this->on_quit_click();});
    Gtk::SeparatorToolItem *sep = Gtk::manage(new Gtk::SeparatorToolItem());
    sep->set_expand(true);  // The expanding sep forces the Quit button to the right
    toolbar->append(*sep);
    toolbar->append(*quit_button);

    // /////////////////////////// ////////////////////////////////////////////
    // S T I C K S   D I S P L A Y
    // Provide a text entry box to show the remaining sticks
    sticks = Gtk::manage(new Gtk::Label());
    // sticks->set_has_frame(false);
    sticks->set_hexpand(true);
    sticks->set_vexpand(true);
    vbox->add(*sticks);
    
    // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
    // Provide a status bar for game messages
    msg = Gtk::manage(new Gtk::Label());
    msg->set_hexpand(true);
    vbox->add(*msg);

    // Make the box and everything in it visible
    vbox->show_all();

    // Start a new game
    on_new_game_click();
}

Mainwin::~Mainwin() { }

// /////////////////
// C A L L B A C K S
// /////////////////

// COMBINED observer / callback
void Mainwin::on_button_click(int button) {
    // TODO: What to do with "impossible" out of sticks exception?
    nim->take_sticks(button);
    set_sticks();
}

void Mainwin::on_computer_player_click() {
    set_sticks();
}

void Mainwin::on_new_game_click() {
    nim = new Nim();
    set_sticks();
}

void Mainwin::on_quit_click() {
    close();
}

void Mainwin::on_rules_click() {
    Glib::ustring s = R"(
<span size='24000' weight='bold'>The Rules of Nim</span>
<span size='large'>Copyright 2017-2020 by George F. Rice - CC BY 4.0</span>

The two players alternate taking 1 to 3 sticks from the pile. The goal is to force your opponent to take the last stick (called mis??re rules).

If the computer button is up, it's a two player game. If down, the computer is always Player 2.)";
    Gtk::MessageDialog{*this, s, true}.run(); // 'true' as 3rd parameter enables Pango markup
}

void Mainwin::on_about_click() {
    Gtk::AboutDialog dialog;
    dialog.set_transient_for(*this); // Avoid the discouraging warning
    dialog.set_program_name("Nim");
    auto logo = Gdk::Pixbuf::create_from_file("128px-Pyramidal_matches.png");
    dialog.set_logo(logo);
    dialog.set_version("Version 1.2.0+");
    dialog.set_copyright("Copyright 2017-2020");
    dialog.set_license_type(Gtk::License::LICENSE_GPL_3_0);
    std::vector< Glib::ustring > authors = {"George F. Rice"};
    dialog.set_authors(authors);
    std::vector< Glib::ustring > artists = {
        "Logo by M0tty, licensed under CC BY-SA 3.0 https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg",
        "Robot by FreePik.com, licensed for personal and commercial purposes with attribution https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm"};
    dialog.set_artists(artists);
    dialog.run();
}

void Mainwin::on_save_as_click() {
    Gtk::FileChooserDialog dialog("Please choose a file",
          Gtk::FileChooserAction::FILE_CHOOSER_ACTION_SAVE);
    dialog.set_transient_for(*this);

    auto filter_nim = Gtk::FileFilter::create();
    filter_nim->set_name("NIM files");
    filter_nim->add_pattern("*.nim");
    dialog.add_filter(filter_nim);
 
    auto filter_any = Gtk::FileFilter::create();
    filter_any->set_name("Any files");
    filter_any->add_pattern("*");
    dialog.add_filter(filter_any);

    dialog.set_filename("untitled.nim");

    //Add response buttons the the dialog:
    dialog.add_button("_Cancel", 0);
    dialog.add_button("_Save", 1);

    int result = dialog.run();

    if (result == 1) {
        try {
            std::ofstream ofs{dialog.get_filename()};
            nim->save(ofs);
            ofs << computer_player->get_active() << std::endl;
            if(!ofs) throw std::runtime_error{"Error writing file"};
        } catch(std::exception& e) {
            Gtk::MessageDialog{*this, "Unable to save game"}.run();
        }
    }
}
//
// The user wants to open a drawing from the filesystem
//
void Mainwin::on_open_click() {
    Gtk::FileChooserDialog dialog("Please choose a file",
          Gtk::FileChooserAction::FILE_CHOOSER_ACTION_OPEN);
    dialog.set_transient_for(*this);

    auto filter_nim = Gtk::FileFilter::create();
    filter_nim->set_name("NIM files");
    filter_nim->add_pattern("*.nim");
    dialog.add_filter(filter_nim);
 
    auto filter_any = Gtk::FileFilter::create();
    filter_any->set_name("Any files");
    filter_any->add_pattern("*");
    dialog.add_filter(filter_any);

    dialog.set_filename("untitled.nim");

    //Add response buttons the the dialog:
    dialog.add_button("_Cancel", 0);
    dialog.add_button("_Open", 1);

    int result = dialog.run();

    if (result == 1) {
        try {
            delete nim;
            std::ifstream ifs{dialog.get_filename()};
            nim = new Nim{ifs};
            bool b;
            ifs >> b;
            computer_player->set_active(b);
            if(!ifs) throw std::runtime_error{"File contents bad"};
            set_sticks();
        } catch (std::exception& e) {
            Gtk::MessageDialog{*this, "Unable to open game"}.run();
        }
    }
}


// /////////////////
// U T I L I T I E S
// /////////////////

void Mainwin::set_sticks() {
    // s collects the status message
    Glib::ustring s = "";

    // If the robot is enabled and it's their turn, move the robot
    if (nim->sticks_left() > 0) {
        if (computer_player->get_active() && nim->current_player() == 2) {
           s += "Robot plays " + std::to_string(nim->optimal_move()) + ", ";
           nim->take_sticks(nim->optimal_move()); 
        }
    }

    // Report who's turn it is, or (if all sticks gone) who won
    if (nim->sticks_left() > 0) {
        s += "Player " + std::to_string(nim->current_player()) + "'s turn";
    } else {
        s += "<span size='16000' weight='bold'>Player " 
              +  std::to_string(3-nim->current_player()) 
              +  " wins!</span>";
    }

    // Display the collected status on the status bar
    msg->set_markup(s);

    // Update the visual display of sticks
    s = "<span size='24000' weight='bold'>";
    for(int i=0; i<nim->sticks_left(); ++i) s.append("| ");
    s.append("</span>  (" + std::to_string(nim->sticks_left()) + " sticks)");
    sticks->set_markup(s);

    // Set sensitivity of the human stick selectors so user can't make an illegal move
    button1->set_sensitive(nim->sticks_left() > 0);
    button2->set_sensitive(nim->sticks_left() > 1);
    button3->set_sensitive(nim->sticks_left() > 2);
}

