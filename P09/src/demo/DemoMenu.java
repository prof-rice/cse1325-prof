package demo;

import java.util.List;
import java.util.ArrayList;

import menu.Menu;
import menu.MenuItem;

public class DemoMenu {
    public DemoMenu() {
        String clearScreen = "\n".repeat(80);  // Scroll all text off display
        String title = "Demo Menu";            // The title of the menu
        title += '\n' + "=".repeat(title.length()) + '\n'; // Add underline
        menu = new Menu(
          new Object[] {clearScreen, title},   // pre - print above the menu
          new Object[] {this, "\nSelection?"}, // post - print below menu / result
//                      Menu Text       Method to Call
//                      -------------   --------------
          new MenuItem("Exit\n",        () -> endApp()),
          new MenuItem("Enter String",  () -> enterString()), // lambda
          new MenuItem("Select String", this::selectString),
          new MenuItem("Remove String", this::removeString)   // method ref
        );
        menu.run(); // Start the main loop
    }
    public static void main(String[] args) {
        new DemoMenu(); // Run this application's main loop
    }
    public void endApp() {
        menu.result = null; // signal end of main loop
    }
    public void enterString() {
        String s = Menu.getString("Enter a String: ");
        if(s != null) strings.add(s);
    }
    private void selectString() {
        Integer index = Menu.selectItemFromArray("Add predefined string: ", predefinedStrings);
        if(index != null) strings.add(predefinedStrings[index]);
    }
    public void removeString() {
        Integer index = Menu.selectItemFromList("Remove which string? ", strings);
        if(index != null) menu.result.append("\nRemoved \"" + strings.remove(index.intValue()) + '"');
    }

    // Called by "this" (2nd Menu parameter "post" above) to display our data
    @Override
    public String toString() {  
        return Menu.listToString("List of Strings\n---------------\n", strings, '•');
    }
    private List<String> strings = new ArrayList<>(); // the data
    private Menu menu;                                // the main menu
    private String[] predefinedStrings = new String[]{"No guts, no glory.", "Prove them wrong.",
        "Try. Fail. Fail better.", "No pressure, no diamonds.", "Broken crayons still color.", 
        "He who is brave is free.", "Leap and the net will appear.", "Boom, baby!"};
}
