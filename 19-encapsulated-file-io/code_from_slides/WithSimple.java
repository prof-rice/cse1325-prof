import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import menu.Menu;
import menu.MenuItem;

public class WithSimple {
    private Simple simple = null;
    private File file = null;
    private Menu menu = null;
    
    private static final String VERSION = "1.0";
    private static final String TITLE = "Simple Data v" + VERSION;
    private static final String EXTENSION = ".simple";
    private static final String MAGIC_COOKIE = "ʂïmрḷẹ";
    private static final String FILE_VERSION = "1.0";
        
    public WithSimple() {
        String clear = "\n".repeat(80);
        String title = TITLE + "\n" + "=".repeat(TITLE.length()) + "\n\n";
        menu = new Menu(new Object[]{clear, title},
                        new Object[]{this, "\n\nSelection? "},
                        new MenuItem("Exit",       this::exit),
                        new MenuItem("Create...",  this::create),
                        new MenuItem("New...",     this::newz),
                        new MenuItem("Save",       this::save),
                        new MenuItem("Save As...", this::saveAs),
                        new MenuItem("Open...",    this::open));
        menu.run();
    }
    
    public static void main(String[] args) {
        new WithSimple();
    }
    
    @Override
    public String toString() {
        return (simple == null) ? "\nSelect Create... to create a Simple."
                                : "\nSimple\n======\n" + simple;
    }
    
    // Command: "Exit"
    private void exit() {
        menu.result = null;
    }
    
    // Command: "Create..."
    private void create() {
        try{
            simple = new Simple(Menu.getString( "Enter a string: "),
                                Menu.getInt(    "Enter an integer: "),
                                Menu.getDouble( "Enter a double: "),
                                Menu.getChar(   "Enter a character: "),
                                Menu.getBoolean("Enter true or false: "));
            menu.result.append("\nCreated " + simple);
        } catch(Exception e) {
            menu.result.append("\nFailed to create a new Simple: " + e);
        }
    }
    
    // Command: "New"
    private void newz() {
        simple = null;
        file = null;
    }
    
    // Command: "Save"
    private void save() {
        file = Menu.selectFile("Select or create .simple file to save (-1 to abort): ", 
                file, // If file is a directory, start browsing in it; 
                      // if it's a file, just save to it; 
                      // if it's null, start in the user's home directory
                (dir, name) -> {File file = new File(dir, name);
                                    return !name.startsWith(".") &&
                                   (file.isDirectory() ||
                                    name.toLowerCase().endsWith(EXTENSION));});
        if(file == null) return;
        try (PrintStream out = new PrintStream(file)) {
            out.println(MAGIC_COOKIE);
            out.println(FILE_VERSION);
            simple.save(out);
            menu.result.append("\nWrote simple to " + file.getName());
        } catch (Exception e) {
            menu.result.append("\nFailed to save: " + e);
        }
    }
    
    // Command: "Save as..."
    private void saveAs() {
        file = null;
        save();
    }
    
    // Command: "Open..."
   private void open() {
        file = Menu.selectFile("Select .simple file to load (-1 to abort): ", 
            (file != null) ? file.getParentFile() : null, 
            (dir, name) -> {File file = new File(dir, name);
                            return !name.startsWith(".") &&
                           (file.isDirectory() ||
                            name.toLowerCase().endsWith(EXTENSION));});
        if(file == null) return;
        try (Scanner in = new Scanner(file)) {
            String mc = in.nextLine();
            if(!mc.equals(MAGIC_COOKIE)) {
                menu.result.append(file.toString() + " is not a " + TITLE + " file");
                return;
            }
            String fv = in.nextLine();
            if(fv.compareTo(FILE_VERSION) > 0) {
                menu.result.append(file.toString() + " is a newer file version - time to upgrade!");
                return;
            }
            simple = new Simple(in);
            menu.result.append("\nRecreated simple from " + file.getName());
        } catch (Exception e) {
            menu.result.append("\nFailed to read: " + e);
            simple = null;
        }
    }
}
