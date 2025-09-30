import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// See MenuItem.java and Menu.java for the keys to this approach!
import menu.Menu;
import menu.MenuItem;

public class EclecticMenuItems {
    private String title;
    private String output;
    private ArrayList<Object> stuff;
    private Scanner in = new Scanner(System.in);
    private Menu menu;
    
    public EclecticMenuItems(String title) {
        this.title = title;
        this.stuff = new ArrayList<>();
        this.output = "";
        this.menu = new Menu(); // Our Menu is just a list of MenuItems!
                                // Each MenuItem encapsulates menu text and method.
        menu.addMenuItem(new MenuItem("Exit",               () -> endApp()));
        menu.addMenuItem(new MenuItem("Add an integer",     () -> addInt()));
        menu.addMenuItem(new MenuItem("Add a double",       () -> addDouble()));
        menu.addMenuItem(new MenuItem("Add a boolean",      () -> addBoolean()));
        menu.addMenuItem(new MenuItem("Add a char",         () -> addChar()));
        menu.addMenuItem(new MenuItem("Add a string",       () -> addString()));
        menu.addMenuItem(new MenuItem("List all items",     () -> listAllItems()));
        menu.addMenuItem(new MenuItem("Sort all items",     () -> sortAllItems()));
        menu.addMenuItem(new MenuItem("Move an item",       () -> moveItem()));
        menu.addMenuItem(new MenuItem("Swap two items",     () -> swapTwoItems()));
        menu.addMenuItem(new MenuItem("Search for an item", () -> searchForItem()));
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N   M E N U
    
    // Show the main menu and return the char selected
    private static String clearScreen = "\n".repeat(255);
    private Integer selectFromMenu() {
        System.out.println(clearScreen + title + "\n\n" + menu + '\n' + output);
        output = "";  // Printing the menu is really easy ^^^^
        return Menu.getInt("Selection? ");
    }
    
    // Method mdi() runs the menu system
    private static boolean running = true;
    public void mdi() {
        while(running) {
            try {
                // Select an item from the menu
                Integer i = selectFromMenu();
                if(i == null) continue;
                menu.run(i); // The "dispatch table" is now a single method call!
            } catch (Exception e) {
                print("#### Invalid command");
            } 
        }
    }
    private void endApp() {
        running = false;
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          R E S P O N D E R s
    // These methods implement each command offered in the menu
    private void addInt() { 
        Integer i = Menu.getInt("Enter an integer to add to your stuff: ");
        if(i != null) {stuff.add(i); listAllItems();}
    }
    private void addDouble() { 
        Double d = Menu.getDouble("Enter a double to add to your stuff: ");
        if(d != null) {stuff.add(d); listAllItems();}
    }
    private void addBoolean() { 
        Boolean b = Menu.getBoolean("Enter a Boolean to add to your stuff: ");
        if(b != null) {stuff.add(b); listAllItems();}
    }
    private void addChar() { 
        Character c = Menu.getChar("Enter a character to add to your stuff: ");
        if(c != null) {stuff.add(c); listAllItems();}
    }
    private void addString() { 
        String s = Menu.getString("Enter text to add to your stuff: ");
        if(s != null) {stuff.add(s); listAllItems();}
    }
     
    private void listAllItems() {
        for(int i=0; i<stuff.size(); ++i)
            print(String.format("%4d: %s", i, stuff.get(i)));
    }
    private void sortAllItems() { 
        Collections.sort(stuff, (Object a, Object b) -> a.toString().compareTo(b.toString()));
        listAllItems();
    }
    private void moveItem() { 
        int a = Menu.selectItemFromList("\nSelect number of item to move: ", stuff);
        Object from = stuff.get(a);
        System.out.println(from);
        int b = Menu.getInt("\nSelect destination number: ");
        if(a == b) return;
        if(b < 0 || b >= stuff.size()) 
            throw new IndexOutOfBoundsException("Invalid item number: " + b);
        if(a < b) b -= 1;
        stuff.remove(a);
        stuff.add(b, from);
        listAllItems();
    }
    private void swapTwoItems() { 
        int a = Menu.selectItemFromList("\nSelect first  item number: ", stuff);
        System.out.println(stuff.get(a));
        int b = Menu.getInt("\nSelect second item number: ");
        Collections.swap(stuff, a, b);
        listAllItems();
    }
    private void searchForItem() { 
        String toFind = Menu.getString("Enter text to find: ");
        for(int i=0; i<stuff.size(); ++i)
            if(stuff.get(i).toString().contains(toFind))
                print(String.format("%4d: %s", i, stuff.get(i)));
    }

    // /////////////////////////////////////////////////////////////////////////
    //                          U S E R   O U T P U T
    // Instead of System.out.println, which would put output ABOVE the menu,
    //   collect output in a String field and print it BETWEEN the menu
    //   and the prompt. This looks MUCH nicer!
    private void print(String s) {
        output += s + '\n';
    }
    
    
    // /////////////////////////////////////////////////////////////////////////
    //                          M A I N
    // Run an instance of the Eclectic Menu
    public static void main(String... args) {
        (new EclecticMenuItems("Test System")).mdi();
    }
}
