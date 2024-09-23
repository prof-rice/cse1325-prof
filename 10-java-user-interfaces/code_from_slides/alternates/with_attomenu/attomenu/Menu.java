package attomenu;

/*
Copyright 2023 by George F. Rice
DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

This file is part of Console Menu.

Console Menu is free software: you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation, either version 3 of the License, 
or (at your option) any later version.

Foobar is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
for more details.

You should have received a copy of the GNU General Public License 
along with Console Menu. If not, see <https://www.gnu.org/licenses/>.
*/

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A simple multi-level console menu system using the Observer pattern.
 * <p>
 * Each {@link MenuItem} specifies the text for a menu entry along with the Runnable object
 * (a lambda is often preferred) to invoke when that menu entry is selected.
 * <p>
 * Menu uses the sequential non-negative integers for selecting a MenuItem using console
 * input. The Menu can be runOnce() for a single selection and response, or simply run() 
 * for many selections and responses until the user selects 'x' to exit that Menu.
 * <p>
 * Menu also provides static select() methods for selecting one element from an array or 
 * List of objects, and a static selectFile() method to select a file or directory.
 * <p>
 * Menu is philisophically similar to Swing's JMenu, using MenuItem instead of JMenuItem
 * for the menu elements.
 * <p>
 * See the Pizza Pearl example application in package pizza for ideas.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Menu {
    /**
     * Constructs a new Menu with all menu items and associated callbacks.
     * 
     * @param title      Printed before the menu items (if not null)
     * @param data       Printed after the menu items and before the prompt (if not null)
     * @param menuItems  List of menu item text and observer / callbacks
     * @since 1.0
     */
    public Menu(Object title, Object data, MenuItem... menuItems) {
        this.title = title;
        this.data = data;
        this.menuItems = menuItems;
    }
    /**
     * Displays the menu and executes the callback for one selection by the user.
     * 
     * @return null if selected action succeeded, user input if an error occurred
     */
    public String runOnce() {
        System.out.print(this); // Print the menu
        String input = System.console().readLine();
        try {
            int item = Integer.parseInt(input);
            menuItems[item].run();
            input = null;       // Null indicates a valid response was handled
        } catch(Exception e) {
        }
        return input;
    }
    /**
     * The main loop that repeatedly calls runOnce until the user enters 'x'.
     */
    public void run() {
        while(true) {
            String input = runOnce(); // Print menu and get response
            if(input != null) {       // If not null, response was undefined
                if(Character.toLowerCase(input.charAt(0)) == 'x') break;
                System.err.println("Invalid menu selection: " + input);
            }
        }
    }
    // <E> means to accept a List containing any type!
    // If user exits without selection, returns -1
    /**
     * Provides a menu containing all list members so the user can select one.
     * 
     * Calls toArray on the list and passes the array to {@link #select(Object,Object[])}.
     * 
     * @param <E>    The type of elements in list
     * @param title  Displayed above the menu (if not null)
     * @param list   The List of elements to offer in the menu
     * @return       The index of the selected element, or -1 if 'x' was selected
     */
    public static <E> int select(Object title, List<E> list) {
        return select(title, list.toArray(new String[list.size()]));
    }
    /**
     * Provides a menu containing all array members so the user can select one.
     * 
     * The menu items correspond to the index of elements. If the user enters
     * an out of bounds index or any text other than 'x', an error message 
     * is displayed followed by the prompt. If the user enters 'x', -1 is returned
     * to signal that the user declined to select an element.
     * 
     * 
     * @param title  Displayed above the menu (if not null)
     * @param list   The array of elements to offer in the menu
     * @return       The index of the selected element, or -1 if 'x' was selected
     */
    public static int select(Object title, Object[] list) {
        if(list.length < 2) return list.length-1; // trivial selections
        String menu = buildMenu(title.toString(), null, list);
        int selection = -1;
        while(true) {
            System.out.println(menu);
            String input = System.console().readLine();
            try {
                if(input != null) {
                    if(Character.toLowerCase(input.charAt(0)) == 'x') {
                        selection = -1;
                    } else {
                        selection = Integer.parseInt(input);
                        if(selection < 0 || selection >= list.length)
                            throw new ArrayIndexOutOfBoundsException();
                    }
                    break;
                }
            } catch(Exception e) {
                System.err.println("Invalid selection: " + input);
            }
        }
        return selection;
    }
    /**
     * Navigates the filesystem so the user can select a file or directory.
     * 
     * The subdirectories (with a trailing '/') and files in the starting directory
     * that match filter are listed in case-insensitive sort order along with 
     * 4 additional options:
     * (0) .. changes to the parent directory
     * (1) .  returns a File object for the current folder
     * (2) +  prompts for a new subdirectory path, and creates and changes to it
     * (3) ++ prompts for a new filename and returns a File object for it
     * 
     * Otherwise, if a subdirectory is selected it is opened and the method repeats.
     * If a file is selected it is returned. If the user enters an out of bounds index 
     * or any text other than 'x', an error message is displayed followed by the prompt. 
     * If the user enters 'x', null is returned to signal that the user declined to 
     * select a file or directory.
     * 
     * @param title    Displayed above the menu (if not null)
     * @param starting The first directory to be listed, or user.home if null
     * @param filter   A FilenameFilter object (filter hidden files if null)
     * @return         The selected File object, or null if 'x' was selected
     */
    public static File selectFile(Object title, File starting, FilenameFilter filter) {
        if(title == null) title = "";
        File current = (starting != null) ? starting : new File(System.getProperty("user.home"));
        if(filter == null) filter = (dir, name) -> name.charAt(0) != '.';
        int selection = -1;
        boolean done = false; // used to explicitly select a directory
        while(!done && current != null && current.isDirectory()) {
            try {
                File[] files = current.listFiles(filter);
                Arrays.sort(files, (a,b) -> {
                    if( a.isDirectory() && !b.isDirectory()) return -1;
                    if(!a.isDirectory() &&  b.isDirectory()) return  1;
                    return a.getName().compareToIgnoreCase(b.getName());
                });
                String[] filenames = new String[files.length+4];
                filenames[0] = ".. (go up one directory)";
                filenames[1] = ".  (select this directory)";
                filenames[2] = "+  (create new directory and open it)";
                filenames[3] = "++ (specify a new filename here)";
                for(int i=0; i<files.length; ++i) 
                    filenames[i+4] = files[i].getName() 
                        + (files[i].isDirectory() ? File.pathSeparator : "");
                selection = select("\n" + title + "\nAt " + current.getPath(), filenames);
                switch(selection) {
                    case -1: current = null; break; // User canceled the selection
                    case  0: current = current.getParentFile(); break; // Up one directory
                    case  1: done = true; break;    // User selected this directory
                    case  2: String sub = System.console().readLine("Enter new subdirectory path: ");
                             File subs = new File(current, sub);
                             subs.mkdirs();  // try to create subdirectories
                             current = subs; // it worked! Switch to it now
                             break;
                    case  3: String file = System.console().readLine("Enter new filename: ");
                             current = new File(current, file);
                             break;
                    default: current = files[selection-4];
                }
            } catch (Exception e) {
                System.err.println("#### Error: " + e);
            }        
        }
        return current;
    }

    /**
     * @param title  Printed before the menu items (if not null)
     * @param data   Printed after the menu items and before the prompt (if not null)
     * @param items  Array of elements to include in the menu
     * @return       String representation of the constructed menu
     */
    private static String buildMenu(Object title, Object data, Object[] items) {
        StringBuilder sb = new StringBuilder(title.toString() + "\n\n");
        for(int i = 0; i < items.length; ++i)
            sb.append(i + ") " + items[i].toString() + '\n');
        if(data != null) sb.append("\n\n" + data + "\n\n");
        sb.append("\nSelection ('x' to exit): ");
        return sb.toString();
    }
    /**
     * Formats this menu for presentation to the user.
     */
    @Override
    public String toString() {
        return buildMenu(title, data, menuItems);
    }
    /**
     * Returns the hash code value for this menu.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, data, menuItems);
    }
    /**
     * Compares the specified object with this menu for equality.
     * <p> 
     * Returns true if and only if the specified object is also a Menu
     * and the title, data, and all menuItems are equal and in the same order.
     * 
     * @param obj  The object to be compared for equality with this Menu
     * @return     True if the specified object is equal to this Menu
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Menu other = (Menu) obj;
        return title.equals(other.title) && 
               data.equals(other.data) &&
               Arrays.equals(menuItems, other.menuItems);
    }
    private Object title;          // Displayed above the menu
    private Object data;           // Displayed between menu and prompt,
                                   //   usually the data object being built by the menu.
    private MenuItem[] menuItems;  // The menu text and associated callback for each element
}