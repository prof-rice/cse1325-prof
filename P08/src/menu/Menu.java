package menu;

import java.util.Objects;

/*
Menu Manager Copyright (c) 2024 Professsor George F. Rice

Licensed under The MIT License (MIT)

Summary: Basically, you can do whatever you want as long as you include 
this copyright and license notice in any copy of the software/source.

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION 
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import java.util.Arrays;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A simple multi-level console menu system using the Observer pattern.
 * <p/>
 * Menu includes a public {@link result} field to collect text to be displayed
 * below the menu. The Menu constructor specifies {@link pre} text to be
 * displayed above the menu / result, {@link post} text to be displayed below
 * the menu / result, and zero or more {@link MenuItem} objects that comprise
 * the menu itself.
 * </p>
 * Each {@link MenuItem} object specifies the text for a menu entry and 
 * the Runnable object to invoke when that menu entry is selected. 
 * Menu uses the sequential non-negative integers for selecting a MenuItem.
 * <p/>
 * The {@link run()} method provides a complete main loop for the application.
 * Also available are the {@link runOnce()} method, which allows the user to
 * select one menu item to be run, and {@link run(Integer)} which runs the
 * specified menu item directly.
 * <p/>
 * Menu also provides a static {@link #getString(String, String, String)} method 
 * to obtain text from the user, as well as similar static methods for each 
 * primitive type such as {@link #getInt(String, String, String)}. Default values
 * and a cancel option are optionally supported.
 * <p/>
 * Another pair of convience static methods are
 * {@link arrayToString(String, Object[], Character)} and
 * {@link listToString(String, List, Character)} 
 * to convert arrays and lists into numbered or bullet-point formats.
 * These complement (for example) Arrays.toString(Object[]) by adding
 * a vertical format to the existing comma-separated inside [ ] 
 * horizontal format.
 * <p/>
 * In addition, Menu provides static 
 * {@link selectItemFromArray(String,Object[])},
 * {@link selectItemFromList(String,List)}, and 
 * {@link selectFile(String, File, FilenameFilter)} 
 * methods for selecting one element from an array, List, or the filesystem.
 * <p/>
 * Setting up and operating a menu is straightforward. 
 * 
 * <ol>
 * <li/>In the constructor for the main class, instance a new menu, including
 * the {@link pre} text (shown before the menu and result, often the title) 
 * and {@link post} text (shown after the menu and result, often data and a prompt), 
 * along with as many menu items as desired in the constructor and (if needed)
 * via calls to the {@link addMenuItem(MenuItem)} method. 
 * 
 * <li/>Invoke menu.run() to initiate the main loop. To exit via a
 * {@link MenuItem#run()} callback, simply set {@link result} to null.
 * 
 * <li/>Your main method need only construct the main class to execute the app.
 * </ol>
 *
 * <p/>
 * A simple example application that collects and deletes strings 
 * is shown in full below.
 * <p/>
 * <pre>
 * package demo;
 *
 * import java.util.List;
 * import java.util.Arraylist;
 *
 * import menu.Menu;
 * import menu.MenuItem;
 *
 * public class DemoMenu {
 *     public DemoMenu() {
 *         String clearScreen = "\n".repeat(80);  // Scroll all text off display
 *         String title = "Demo Menu";            // The title of the menu
 *         title += '\n' + "=".repeat(title.length()) + '\n'; // Add underline
 *         menu = new Menu(
 *           new Object[] {clearScreen, title},   // pre  - print above menu / result
 *           new Object[] {this, "\nSelection?"}, // post - print below menu / result
 *           new MenuItem("Exit\n",        () -&gt; endApp()),
 *           new MenuItem("Enter String",  () -&gt; enterString()), // lambda
 *           new MenuItem("Remove String", this::removeString)   // method ref
 *         );
 *         menu.run(); // Start the main loop
 *     }
 *     public static void main(String[] args) {
 *         new DemoMenu(); // Run this application's main loop
 *     }
 *     public void endApp() {
 *         menu.result = null; // signal end of main loop
 *     }
 *     public void enterString() {
 *         String s = Menu.getString("Enter a String: ");
 *         if(s != null) strings.add(s);
 *     }
 *     public void removeString() {
 *         Integer index = Menu.selectItemFromList("Remove which string? ", strings);
 *         if(index != null) // null indicates cancel by default
 *             menu.result.append("\nRemoved \"" + strings.remove(index.intValue()) + '"');
 *     }
 *
 *     // Called by "this" (in the 2nd constructor parameter above) to display our data.
 *     // The title is first, then the List, and finally the bullet to precede each element.
 *     // If the bullet were null, then each element's index would be the "bullet".
 *     &commat;Override
 *     public String toString() {  
 *         return Menu.listToString("List of Strings\n---------------\n", strings, '•');
 *     }
 *
 *     private List&lt;String&gt; strings = new ArrayList&lt;&gt;(); // the data
 *     private Menu menu;                                // the main menu
 * }
 * </pre>
 *
 * @author             Professor George F. Rice
 * @version            1.3
 * @since              1.0
 * @license.agreement  MIT License
 */
public class Menu implements Runnable {

    /**
     * Constructs a menu with no predefined text or menu items.
     *
     * @since               1.0
     */
    public Menu() {
    }

    /**
     * Constructs a menu with specified pre and post text and optionalmenu items.
     * <p/>
     * The pre and post parameters may be a plain old Java object (pojo), an array, 
     * or an instance of Iterable such as a List. If an array or instance of iterable, 
     * they will be recursively traversed until a pojo (plain ole Java object) is found. 
     * Each pojo is printed  as encountered prior to (for pre) or immediately following 
     * (for post) the menu text from the menu items and {@link result}.
     * <p/>
     * Unlike most other Java objects, String objects provided within pre or post 
     * will not reflect changes, since String is immutable. To change the text 
     * of a pre or post String object, use a StringBuilder object instead.
     * <p/>
     * Even if pre-populated, additional menu items may be added using 
     * {@link addMenuItem(MenuItem)}.
     *
     * @param pre           Object(s) to print before the menu items, often a title.
     * @param post          Object(s) to print after the menu items, often a prompt.
     * @param items         Zero or more MenuItem instances to pre-populate the menu.
     * @since               1.2
     */
    public Menu(Object pre, Object post, MenuItem... items) {
        this.pre = pre;  
        this.post = post;
        for(var item : items) addMenuItem(item);
    }
    
    /**
     * Add a menu item to this menu at the next available integer index.
     *
     * @param item                      The menu item to be added.
     * @throws IllegalArgumentException if item is null.
     * @since               1.0
     */
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Invokes the selected item number.
     * 
     *<p/>
     * The itemNumber parameter is used to select a MenuItem object from 
     * the list added by {@link Menu(Object, Object, MenuItem...)} and 
     * via the {@link addMenuItem(MenuItem)} method. Then the selected
     * Menutem object's run() method is called.
     *
     * <p/>
     * If the item number is null, it is ignored.
     *
     * @param itemNumber    The index of the MenuItem object to invoke.
     * @throws OutOfRangeException if itemNumber is negative or too large
     * @since               1.0
     */
    public void run(Integer itemNumber) {
        if(itemNumber != null) 
            items.get(itemNumber).run();
    }
    
    /**
     * Display the menu, get selection, clear {@link result}, then execute selection.
     *
     * <p/>
     * This is a convenience function that behaves as if for an instance of Menu 
     * named menu:
     *
     * <p/>
     * <pre>
     * Integer command = Menu.getInt(menu.toString())); // Get user selection
     * if(result != null) result.setLength(0);          // Clear result
     * menu.run(command);                               // Call associated method
     * </pre>
     *
     * @throws IndexOutOfRangeException if the user enters an invalid index.
     * @since               1.2
     */
    public void runOnce() {
        Integer command = getInt(toString());
        if(result != null) result.setLength(0); 
        run(command);
    }

    /**
     * Call runOnce() repeatedly until {@link result} becomes null.
     *
     * <p/>
     * This is a convenience function that behaves as a main loop.
     * It repeatedly calls {@link runOnce()}, which prints the menu
     * and runs the selected observer. The main loop may be exited
     * by setting {@link result} to null.
     *
     * @since               1.2
     */
    @Override
    public void run() {
        while(result != null) {
            try {
                runOnce();
            } catch(Exception e) {
                result.append("\nERROR: Command failed\n");
            }
        }
    }

    /**
     * Converts the object to a fully formatted menu.
     *
     * <p/>
     * The resulting string will be the string representation of {@link pre},
     * each element of {@link items} with the index as a selector, {@link result},
     * and the string representation of {@link post}.
     * <p/>
     * If {@link pre} or {@link post} is an array or Iterable, it will be
     * recursively evaluated down to a sequence of plain old Java objects 
     * that will be appended in order to the resulting String.
     * <p/>
     * Elements that are null will be silently ignored.
     * <p/>
     * Thus, {@link pre} and {@link post} may represent a series of nested
     * objects that comprise (for example) the title and the prompt of the
     * final formatted menu returned by this method.
     *
     * @since               1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        recursiveAppend(sb, pre);
        for(int i=0 ; i<items.size() ; ++i)
            sb.append(" " + i + "] " + items.get(i) + "\n");
        sb.append('\n');
        recursiveAppend(sb, result);
        sb.append('\n');
        recursiveAppend(sb, post);
       return sb.toString();
    }
    
    /**
     * Recursively append addendum to sb.
     *
     * <p/>
     * If addendum is an array or Iterable, each element is passed to recursiveAppend.
     * Otherwise, it is appended to sb. If any parameter is null, this method returns.
     * <p/>
     * WARNING: Recursive (self-referential) arrays / lists will throw StackOverflowError.
     *
     * @since               1.2
     */
    private static void recursiveAppend(StringBuilder sb, Object addendum) {
        if(sb == null || addendum == null) return;
        else if(addendum.getClass().isArray()) 
            for(var o : (Object[]) addendum) recursiveAppend(sb, o);
        else if(addendum instanceof Iterable)  
            for(var o : (Iterable) addendum) recursiveAppend(sb, o);
        else sb.append(addendum.toString() + '\n');
    }

    // /////////////////////////////////////////////////////////////////////////
    //                         U T I L I T Y   M E T H O D S

    /**
     * Prints the prompt and returns a trimmed String from the user.

     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If an exception occurs while reading and processing the input String, 
     * "Invalid input!" is printed and another attempt to read a String is made.
     *
     * Finally, if cancelInput is not null and matches the input, then null is 
     * returned. Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is returned if the user just presses Enter.
     * @return null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt, String cancelInput, String defaultInput) {
        String s = null;
        while(true) {
            try  {
                if(prompt != null) System.out.print(prompt);
                s = scanner.nextLine().trim();
                if(s.isEmpty() && defaultInput != null) s = defaultInput;
                break;
            } catch(Exception e) {
                System.err.println("\nInvalid input: " + e.getMessage());
            }
        }
        if(cancelInput != null && s.equals(cancelInput)) s = null; 
        return s;
    }
    /**
     * Prints the prompt and returns a trimmed String from the user.

     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * If an exception occurs while reading and processing the input String, 
     * "Invalid input!" is printed and another attempt to read a String is made.
     * <p/>
     * Finally, if cancelInput is not null and matches the input, then null is 
     * returned. Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt, String cancelInput) {
        return getString(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns a trimmed String from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * If an exception occurs while reading and processing the input String, 
     * "Invalid input!" is printed
     * and another attempt to read a String is made.
     * <p/>
     * Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @return null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt) {
        return getString(prompt, null, null);
    }

    /**
     * Prints the prompt and returns an Integer from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to Integer if the user just presses Enter.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.0
     */
    public static Integer getInt(String prompt, String cancelInput, String defaultInput) {
        Integer i = null;
        while(true) {
            try  {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } catch(Exception e) {
                System.err.println("\nInvalid input: " + e.getMessage());
            }
        }
        return i;
    }
    /**
     * Prints the prompt and returns an Integer from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.0
     */
    public static Integer getInt(String prompt, String cancelInput) {
        return getInt(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Integer from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input, and 
     * the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.0
     */
    public static Integer getInt(String prompt) {
        return getInt(prompt, null, null);
    }
    
    /**
     * Prints the prompt and returns an Double from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Double and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Double, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to a Double if the user presses Enter.
     * @return null if the input matches cancelInput or the input Double otherwise.
     * @since               1.0
     */
    public static Double getDouble(String prompt, String cancelInput, String defaultInput) {
        Double d = null;
        while(true) {
            try  {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s != null && !s.isEmpty()) d = Double.parseDouble(s);
                break;
            } catch(Exception e) {
                System.err.println("\nInvalid input: " + e.getMessage());
            }
        }
        return d;
    }
    /**
     * Prints the prompt and returns an Double from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Double and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Double, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Double otherwise.
     * @since               1.0
     */
    public static Double getDouble(String prompt, String cancelInput) {
        return getDouble(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Double from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input, 
     * and the input is converted to an Double and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Double, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @return null if the input matches cancelInput or the input Double otherwise.
     * @since               1.0
     */
    public static Double getDouble(String prompt) {
        return getDouble(prompt, null, null);
    }

    /**
     * Prints the prompt and returns an Boolean from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Boolean and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Boolean, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to an Boolean if the user presses Enter.
     * @return null if the input matches cancelInput or the input Boolean otherwise.
     * @since               1.0
     */
    public static Boolean getBoolean(String prompt, String cancelInput, String defaultInput) {
        Boolean b = null;
        while(true) {
            try  {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s != null && !s.isEmpty()) b = Boolean.parseBoolean(s);
                break;
            } catch(Exception e) {
                System.err.println("\nInvalid input: " + e.getMessage());
            }
        }
        return b;
    }
    /**
     * Prints the prompt and returns an Boolean from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Boolean and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Boolean, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Boolean otherwise.
     * @since               1.0
     */
     public static Boolean getBoolean(String prompt, String cancelInput) {
        return getBoolean(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Boolean from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input, and 
     * the input is converted to an Boolean and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Boolean, "Invalid input!" is printed and another attempt
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @return null if the input matches cancelInput or the input Boolean otherwise.
     * @since               1.0
     */
    public static Boolean getBoolean(String prompt) {
        return getBoolean(prompt, null, null);
    }
    
    /**
     * Prints the prompt and returns an Character from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Character and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Character, "Invalid input!" is printed and another 
     * attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to a Character if the user presses Enter.
     * @return null if the input matches cancelInput or the input Character otherwise.
     * @since               1.0
     */
    public static Character getChar(String prompt, String cancelInput, String defaultInput) {
        Character c = null;
        while(true) {
            try  {
                String s = getString(prompt, cancelInput, defaultInput);
                if(s != null && !s.isEmpty()) c = s.charAt(0);
                break;
            } catch(Exception e) {
                System.err.println("\nInvalid input: " + e.getMessage());
            }
        }
        return c;
    }
    /**
     * Prints the prompt and returns an Character from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Character and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Character, "Invalid input!" is printed and another 
     * attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Character otherwise.
     * @since               1.0
     */
    public static Character getChar(String prompt, String cancelInput) {
        return getChar(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Character from the user.
     *
     * <p/>
     * The prompt is printed exactly as provided, and a newline-terminated String 
     * from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input, and 
     * the input is converted to an Character and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * onverting it to an Character, "Invalid input!" is printed and another
     *  attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @return null if the input matches cancelInput or the input Character otherwise.
     * @since               1.0
     */
    public static Character getChar(String prompt) {
        return getChar(prompt, null, null);
    }
    
    /**
     * Converts the array to a String preceded by the title (if not null).
     *
     * <p/>
     * The title (if not null) precedes the array contents.
     * <p/>
     * Each element of the array is added, one per line, preceded by either bullet
     * or (if bullet is null) its index and "] ". (The most common bullet is '•'.)
     * 
     * So the following code:
     *
     * <p/>
     * <pre>
     * String title = "The Three Stooges\n=== ===== =======\n\n";
     * String[] stooges = {"Larry", "Curly", "Moe"};
     * arrayToString(title, stooges, null);
     * </pre>
     *
     * would result in 
     * "The Three Stooges\n=== ===== =======\n\n0] Larry\n1] Curly\n2] Moe".
     * 
     * @param title    The String to precede the array (ignored if null).
     * @param array    The array to be converted to a String.
     * @param bullet   Character to precede each element, or use the index if null
     * @return         The String representation of the array in list form.
     * @since          1.3
     */
    public static String arrayToString(String title, Object[] array, Character bullet) {
        StringBuilder sb = new StringBuilder();
        if(title != null) sb.append(title);
        for(int i=0; i<array.length; ++i) {
            if(bullet == null)
                sb.append(String.format("%4d] %s\n", i, array[i]));
            else
                sb.append(String.format("%c  %s\n", bullet, array[i]));
        }
        return sb.toString();
    }
    
    /**
     * Converts the List to a String preceded by the title (if not null).
     *
     * <p/>
     * The title (if not null) precedes the List contents.
     * <p/>
     * Each element of the list is added, one per line, preceded by either bullet
     * or (if bullet is null) its index and "] ". (The most common bullet is '•'.)
     *
     * So the following code:
     *
     * <p/>
     * <pre>
     * String title = "The Three Stooges\n=== ===== =======\n\n";
     * List&lt;String&gt; stooges = new ArrayList&lt;&gt;(); 
     * stooges.add("Larry");
     * stooges.add("Curly"; 
     * stooges.add("Moe");
     * System.out.println(listToString(title, stooges, null));
     * </pre>
     *
     * would result in 
     * "The Three Stooges\n=== ===== =======\n\n0] Larry\n1] Curly\n2] Moe".
     * 
     * @param title    The String to precede the array (ignored if null).
     * @param list     The List to be converted to a String.
     * @param bullet   Character to precede each element, or use the index if null
     * @return         The String representation of the array in list form.
     * @since          1.3
     */
    public static String listToString(String title, List list, Character bullet) {
        return arrayToString(title, list.toArray(), bullet);
    }
    /**
     * Prints the prompt and array, allowing the user to select an array element. 
     *
     * <p/>
     * If the array is null or of zero length, null is returned. 
     * If the array contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInd parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param array     The array of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to an Integer if the user presses Enter.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput, String defaultInput) {
        if(array == null) return null;
        return switch(array.length) {
            case 0  -> null;
            case 1  -> 0;
            default -> {
                           System.out.println(arrayToString(null,  array, null));
                           yield getInt(prompt, cancelInput, defaultInput);
                       }
        };
    }
    /**
     * Prints the prompt and array, allowing the user to select an array element. 
     *
     * <p/>
     * If the array is null or of zero length, null is returned. 
     * If the array contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param array     The array of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput) {
        return selectItemFromArray(prompt, array, cancelInput, null);
    }
    /**
     * Prints the prompt and array, allowing the user to select an array element. 
     *
     * <p/>
     * If the array is null or of zero length, null is returned. 
     * If the array contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input 
     * which is then converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param array     The array of objects from which the user will select.
     * @return the input Integer.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array) {
        return selectItemFromArray(prompt, array, null, null);
    }

    /**
     * Prints the prompt and list, allowing the user to select a list element. 
     *
     * <p/>
     * If the list is null or of zero length, null is returned. 
     * If the list contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * Then, if the String is empty and the defaultInput parameter is not null, 
     * input is replaced with the defaultInput parameter.
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param list      The list of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String converted to an Integer if the user presses Enter.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list, String cancelInput, String defaultInput) {
        if(list == null) return null;
        return selectItemFromArray(prompt, list.toArray(), cancelInput, defaultInput);
    }
    /**
     * Prints the prompt and list, allowing the user to select a list element.
     *
     * <p/>
     * If the list is null or of zero length, null is returned. 
     * If the list contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p/>
     * If the input matches cancelInput or is still empty, null is returned. 
     * Otherwise, the input is converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt 
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param list      The list of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list, String cancelInput) {
        return selectItemFromArray(prompt, list.toArray(), cancelInput, null);
    }
    /**
     * Prints the prompt and list, allowing the user to select a list element. 
     *
     * <p/>
     * If the list is null or of zero length, null is returned. 
     * If the list contains a single object, 0 is returned.
     * <p/>
     * Otherwise, the prompt is printed exactly as provided, along with a menu 
     * showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p/>
     * All whitespace is trimmed from the beginning and ending of the input which 
     * is then converted to an Integer and returned.
     * <p/>
     * If an exception occurs while reading and processing the input String and 
     * converting it to an Integer, "Invalid input!" is printed and another attempt
     * to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt the user.
     * @param list      The list of objects from which the user will select.
     * @return null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list) {
        return selectItemFromArray(prompt, list.toArray(), null, null);
    }
    /**
     * Navigates the filesystem so the user can select or create a file or directory.
     * 
     * <p/>
     * The subdirectories (with a trailing '/') and files in the starting directory
     * that match filter are listed in case-insensitive sort order along with 
     * 4 additional options:
     * <p/>
     * <pre>
     * (0) .. changes to the parent directory
     * (1) .  returns a File object for the current folder
     * (2) +  prompts for a new subdirectory path, and creates and changes to it
     * (3) ++ prompts for a new filename and returns a File object for it
     * </pre>
     * <p/>
     * Otherwise, if a subdirectory is selected it is opened and the method repeats.
     * If a file or a directory is selected it is returned. 
     * If the user enters a negative selection, null is returned to signal that 
     * the user declined to  select a file or directory. 
     * If the user enters a positive but out of bounds index, an error message is 
     * displayed followed by the prompt.
     * <p/>
     * The directory from which the program was launched may be selected for starting
     * by setting the second parameter to 
     * 
     * <pre>
     * new File(System.getProperty("user.dir"))
     * </pre>.
     * 
     * @param prompt   Requests input from the user, or no prompt if null
     * @param starting The first directory to be listed, or user.home if null
     * @param filter   Files to show or show all non-hidden files if null
     * @return         The selected File object, or null if no file was selected
     */
    public static File selectFile(String prompt, File starting, FilenameFilter filter) {
        if(prompt == null) prompt = "";
        File current = (starting != null) ? starting 
                                          : new File(System.getProperty("user.home"));
        if(filter == null) filter = (dir, name) -> name.charAt(0) != '.';
        Integer selection = -1;
        boolean done = false; // used to explicitly select a directory
        while(!done && current != null && current.isDirectory()) {
            try {
                File[] files = current.listFiles(filter);
                Arrays.sort(files, (a,b) -> { // list directories before regular files
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
                    filenames[i+4] = files[i].getName() + 
                        (files[i].isDirectory() ? File.separator : "");
                selection = selectItemFromArray("\nAt " + current.getPath() + 
                                                "\n" + prompt, filenames);
                System.out.println();
                switch(selection) {
                    case -1: current = null; break; // User canceled the selection
                    case  0: current = current.getParentFile(); break; // Up one directory
                    case  1: done = true; break;    // User selected this directory
                    case  2: String sub = getString("Enter new subdirectory path: ");
                             File subs = new File(current, sub);
                             subs.mkdirs();  // try to create subdirectories
                             current = subs; // it worked! Switch to it now
                             break;
                    case  3: String file = getString("Enter new filename: ");
                             current = new File(current, file);
                             break;
                    default: current = files[selection-4];
                }
            } catch (Exception e) {
                System.err.println("\nError selecting file: " + e.getMessage());
            }        
        }
        return current;
    }

    /**
     * Compares the specified object with this menu for equality. 
     *
     * Returns true if and only if the specified object is also a Menu
     * and the {@link pre}, {@link items}, and {@link post} fields are equal.
     * 
     * @param  o  the object to be compared for equality with this Menu
     * @return    true if the specified object is equal to this Menu
     * @since     1.3
     */
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Menu m = (Menu) o;
        return m.pre.equals(pre) &&
               m.items.equals(items) &&
               m.post.equals(post);
    }
    /**
     * Returns the hash code value for this Menu. 
     *
     * The {@link pre}, {@link items}, and {@link post} fields are significant 
     * to the hashCode.
     * 
     * @return    the hash code value for this Menu
     * @since     1.3
     */
    @Override
    public int hashCode() {
        return Objects.hash(pre, items, post);
    }

    /**
     * This field collects text to display below the menu text.
     * 
     * The result object is null and ignored by default. If set non-null
     * by application code, it will be cleared prior to each call to
     * {@link runOnce()} and then printed below the menu. If set to null,
     * {@link run()} will exit.
     *
     * @since               1.2
     */
    public StringBuilder result = new StringBuilder();

    /**
     * Array, Iterable, null, or plain old Java object to print before items.
     *
     * @since               1.2
     */
    protected Object pre;
    /**
     * Dispatch table of menu items.
     *
     * @since               1.0
     */
    protected List<MenuItem> items = new ArrayList<>();
    /**
     * Array, Iterable, null, or plain old Java object to print after items.
     *
     * @since               1.2
     */
    protected Object post;
    /**
     * Used only to read a String from the console.
     *
     * @since               1.2
     */
    private static Scanner scanner = new Scanner(System.in);
}


