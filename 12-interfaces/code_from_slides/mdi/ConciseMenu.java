import menu.Menu;
import menu.MenuItem;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;

// This is a very simple example demonstrating how to fully use the menu package.

public class ConciseMenu {

    // The constructor constructs the field, including the Menu object.
    //
    // Menu's constructor (the first 2 parameters may be an Object, Object[], or List):
    //    First parameter -   Text above the menu, usually the title
    //    Second parameter -  Text below the menu and result, usually the prompt
    //    Third+ parameters - One MenuItem object per item in your menu
    //
    // MenuItem's constructor
    //    First parameter -   The text to display in the menu
    //    Second parameter -  A method reference or lambda to run when this menu item is selected
    //
    // Once your fields (including Menu) are constructed, just call menu's run method!
    //
    public ConciseMenu() {
        Collections.addAll(strings, "Hello", "World", "and", "UTA"); // List from which to select items
        
        menu = new Menu( // Our actual menu
            "\n".repeat(80) + "Add Stuff\n=========",              // Text above the menu
            new Object[] {"Stuff\n-----", stuff, "\nSelection? "}, // Text below the menu
            new MenuItem("Quit", this::quit),                      // As many menu items as you like
            new MenuItem("Predefined string", this::pstring),
            new MenuItem("A custom string",   this::cstring),      // The method reference approach
            new MenuItem("A double",          () -> adouble())     // The lambda approach
        );
        
        menu.run();                                                // The main loop
    }
    
    // Because your constructor runs the menu, all main needs to do is construct this class.
    public static void main(String[] args) {
        new ConciseMenu();
    }
    
    // Don't forget a menu item to exit! To exit menu.run(), just set the result to null.
    private void quit() {
        menu.result = null;
    }
    // This is an example of selecting an item from a List. See the docs for options.
    // After adding the selection, method showStuff add the elements of stuff to menu.result.
    // (menu.run automatically adds menu.result after the menu.)
    private void pstring() {
        Integer index = Menu.selectItemFromList("Select an index: ", strings);
        stuff.add(strings.get(index));
        menu.result.append("\nSelected " + index + " from list of strings\n");
    }
    // This is an example of getting a string from the user. See the docs for options.
    private void cstring() {
        String s = Menu.getString("Enter any string): ");
        stuff.add(s);
        menu.result.append("\nEntered " + s + '\n');
    }
    // This is an example of getting a double from the user. See the docs for options.
    // Any primitive type can be requested from the user with a single static method call.
    private void adouble() {
        Double d = Menu.getDouble("Enter a double: ");
        stuff.add(d);
        menu.result.append("\nEntered " + d + '\n');
    }

    // Our fields, including our menu
    private List<String> strings = new ArrayList<>(); // List from which to select
    private List<Object> stuff   = new ArrayList<>(); // List of selections
    private Menu menu;
}
