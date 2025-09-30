package menu;

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

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * A simple multi-level console menu system using the Observer pattern.
 * <p>
 * Each {@link MenuItem} specifies the text for a menu entry and the Runnable object
 * (a lambda is often preferred) to invoke when that menu entry is selected.
 * Menu uses the sequential non-negative integers for selecting a MenuItem using console input. 
 * <p>
 * Menu provides a static {@link #getString(String, String, String)} method to obtain
 * text from the user, as well as similar static methods for each primitive type
 * such as {@link #getInt(String, String, String)}. 
 * Menu also provides static {@link selectItemFromArray(String,Object[])} and 
 *{@link selectItemFromList(String,List)} 
 * methods for selecting one element from an array or List of objects.
 * <p>
 * Setting up and operating a menu is straightforward. Instance a new menu,
 * add as many menu items as desired, then use the menu as a  {@link #getInt(String)}
 * prompt. If the returned object isn't null, run that menu item:
 * <pre>
 * Menu menu = new Menu();
 * //                             Menu Text             Method to Call
 * //                             -------------         --------------
 * menu.addMenuItem(new MenuItem("Exit\n",        () -&gt; endApp()));
 * menu.addMenuItem(new MenuItem("Enter String",  () -&gt; enterString()));
 * menu.addMenuItem(new MenuItem("Recall String", () -&gt; recallString()));
 *
 * Integer index = Menu.getInt(menu.toString() + "\n\nSelect? "); // Get user selection
 * if(index != null) menu.run(index);                             // Call associated method
 * </pre>
 * <p>
 * Menu is philisophically similar to Swing's {@link javax.swing.JMenu}, using {@link MenuItem} 
 * instead of {@link javax.swing.JMenuItem} for the menu elements.
 *
 * @author             Professor George F. Rice
 * @version            1.1
 * @since              1.0
 * @license.agreement  MIT License
 */
public class Menu {

    /**
     * Constructs a menu with specified header text and optionally pre-populates menu items.
     * Even if pre-populated, additional menu items may be added (see {@link addMenuItem(MenuItem)}).
     *
     * @param header        Text to be displayed before the menu items, often a title.
     * @param items         Zero or more MenuItem instances to pre-populate the menu.
     * @since               1.0
     */
    public Menu(String header, MenuItem... items) {
        this.header = header;
        for(var item : items) addMenuItem(item);
    }
    
    /**
     * Constructs a menu with no header or menu items.
     *
     * @since               1.0
     */
    public Menu() {
    }

    /**
     * Provides a menu item to this menu at the next sequential integer.
     *
     * @param item                      The menu item to be added.
     * @throws IllegalArgumentException if item is null.
     * @since               1.0
     */
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Converts the object to a fully formatted menu.
     *
     * @since               1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(header);
        for(int i=0 ; i<items.size() ; ++i)
            sb.append(" " + i + "] " + items.get(i) + "\n");
       return sb.toString();
    }

    /**
     * Invokes the selected item number.      * Invokes the selected item number. If the item number is null, it is ignored.
     *
     * @param itemNumber    The index of the MenuItem object to invoke.
     * @throws OutOfRangeException if itemNumber is negative or enough MenuItems have not been added via {@link addMenuItem(MenuItem)}.
     * @since               1.0
     */
    public void run(Integer itemNumber) {
        if(itemNumber != null) 
            items.get(itemNumber).run();
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                         U T I L I T Y   M E T H O D S

    /**
     * Prints the prompt and returns a trimmed String from the user, with optional cancel and default text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If an exception occurs while reading and processing the input String, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * Finally, if cancelInput is not null and matches the input, then null is returned. Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is returned if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt, String cancelInput, String defaultInput) {
        String s = null;
        while(true) {
            try  {
                if(prompt != null) System.out.print(prompt);
                s = in.nextLine().trim();
                if(s.isEmpty() && defaultInput != null) s = defaultInput;
                break;
            } catch(Exception e) {
                System.err.println("Invalid input!");
            }
        }
        if(cancelInput != null && s.equals(cancelInput)) s = null; 
        return s;
    }
    /**
     * Prints the prompt and returns a trimmed String from the user, with optional cancel text.
     * <p>
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * If an exception occurs while reading and processing the input String, "Invalid input!" is printed
     * and another attempt to read a String is made.
     * <p>
     * Finally, if cancelInput is not null and matches the input, then null is returned. Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt, String cancelInput) {
        return getString(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns a trimmed String from the user.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * If an exception occurs while reading and processing the input String, "Invalid input!" is printed
     * and another attempt to read a String is made.
     * <p>
     * Otherwise, the input is returned.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @returns null if the input matches cancelInput or the input String otherwise.
     * @since               1.0
     */
    public static String getString(String prompt) {
        return getString(prompt, null, null);
    }

    /**
     * Prints the prompt and returns an Integer from the user, with optional cancel and default text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Integer if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
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
                System.err.println("Invalid input!");
            }
        }
        return i;
    }
    /**
     * Prints the prompt and returns an Integer from the user, with optional cancel text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.0
     */
    public static Integer getInt(String prompt, String cancelInput) {
        return getInt(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Integer from the user.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input, and the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.0
     */
    public static Integer getInt(String prompt) {
        return getInt(prompt, null, null);
    }
    
    /**
     * Prints the prompt and returns an Double from the user, with optional cancel and default text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Double and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Double, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Double if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Double otherwise.
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
                System.err.println("Invalid input!");
            }
        }
        return d;
    }
    /**
     * Prints the prompt and returns an Double from the user, with optional cancel text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Double and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Double, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Double otherwise.
     * @since               1.0
     */
    public static Double getDouble(String prompt, String cancelInput) {
        return getDouble(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Double from the user.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input, and the input is converted to an Double and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Double, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @returns null if the input matches cancelInput or the input Double otherwise.
     * @since               1.0
     */
    public static Double getDouble(String prompt) {
        return getDouble(prompt, null, null);
    }

    /**
     * Prints the prompt and returns an Boolean from the user, with optional cancel and default text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Boolean and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Boolean, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Boolean if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Boolean otherwise.
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
                System.err.println("Invalid input!");
            }
        }
        return b;
    }
    /**
     * Prints the prompt and returns an Boolean from the user, with optional cancel text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Boolean and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Boolean, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Boolean otherwise.
     * @since               1.0
     */
     public static Boolean getBoolean(String prompt, String cancelInput) {
        return getBoolean(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Boolean from the user.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input, and the input is converted to an Boolean and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Boolean, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @returns null if the input matches cancelInput or the input Boolean otherwise.
     * @since               1.0
     */
    public static Boolean getBoolean(String prompt) {
        return getBoolean(prompt, null, null);
    }
    
    /**
     * Prints the prompt and returns an Character from the user, with optional cancel and default text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Character and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Character, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Character if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Character otherwise.
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
                System.err.println("Invalid input!");
            }
        }
        return c;
    }
    /**
     * Prints the prompt and returns an Character from the user, with optional cancel text.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Character and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Character, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Character otherwise.
     * @since               1.0
     */
    public static Character getChar(String prompt, String cancelInput) {
        return getChar(prompt, cancelInput, null);
    }
    /**
     * Prints the prompt and returns an Character from the user.
     *
     * The prompt is printed exactly as provided, and a newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input, and the input is converted to an Character and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Character, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @returns null if the input matches cancelInput or the input Character otherwise.
     * @since               1.0
     */
    public static Character getChar(String prompt) {
        return getChar(prompt, null, null);
    }
    
    /**
     * Prints the prompt and array, allowing the user to select an array element, with optional cancel and default text. 
     *
     * If the array is null or of zero length, null is returned. If the array contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInd parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param array     The array of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Integer if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput, String defaultInput) {
        if(array == null) return null;
        return switch(array.length) {
            case 0  -> null;
            case 1  -> 0;
            default -> {
                           for(int i=0; i<array.length; ++i) 
                               System.out.printf("%4d] %s\n", i, array[i]);
                           yield getInt(prompt, cancelInput, defaultInput);
                       }
        };
    }
    /**
     * Prints the prompt and array, allowing the user to select an array element, with optional cancel text. 
     *
     * If the array is null or of zero length, null is returned. If the array contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param array     The array of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput) {
        return selectItemFromArray(prompt, array, cancelInput, null);
    }
    /**
     * Prints the prompt and array, allowing the user to select an array element. 
     *
     * If the array is null or of zero length, null is returned. If the array contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the array elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input which is then converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param array     The array of objects from which the user will select.
     * @returns the input Integer.
     * @since               1.1
     */
    public static Integer selectItemFromArray(String prompt, Object[] array) {
        return selectItemFromArray(prompt, array, null, null);
    }

    /**
     * Prints the prompt and list, allowing the user to select a list element, with optional cancel and default text. 
     *
     * If the list is null or of zero length, null is returned. If the list contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. Then, if the String is empty 
     * and the defaultInput parameter is not null, input is replaced with the defaultInput parameter.
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param list      The list of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @param defaultInput The String that is converted to an Integer if the user just presses Enter.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list, String cancelInput, String defaultInput) {
        if(list == null) return null;
        return selectItemFromArray(prompt, list.toArray(), cancelInput, defaultInput);
    }
    /**
     * Prints the prompt and list, allowing the user to select a list element, with optional cancel text. 
     *
     * If the list is null or of zero length, null is returned. If the list contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input. 
     * <p>
     * If the input matches cancelInput or is still empty, null is returned. Otherwise, the input is converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param list      The list of objects from which the user will select.
     * @param cancelInput  The String that, if entered  by the user, returns a null.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list, String cancelInput) {
        return selectItemFromArray(prompt, list.toArray(), cancelInput, null);
    }
    /**
     * Prints the prompt and list, allowing the user to select a list element. 
     *
     * If the list is null or of zero length, null is returned. If the list contains a single object, 0 is returned.
     * <p>
     * Otherwise, the prompt is printed exactly as provided, along with a menu showing indices and toString representations of the list elements. 
     * A newline-terminated String from the user is read as input from the console.
     * <p>
     * All whitespace is trimmed from the beginning and ending of the input which is then converted to an Integer and returned.
     * <p>
     * If an exception occurs while reading and processing the input String and converting it to an Integer, "Invalid input!" is printed
     * and another attempt to read a String is made.
     *
     * 
     * @param prompt    The String to be printed (if not null) to prompt input from the user.
     * @param list      The list of objects from which the user will select.
     * @returns null if the input matches cancelInput or the input Integer otherwise.
     * @since               1.1
     */
    public static Integer selectItemFromList(String prompt, List list) {
        return selectItemFromArray(prompt, list.toArray(), null, null);
    }

    private static Scanner in = new Scanner(System.in);
    private List<MenuItem> items = new ArrayList<>();
    private String header = "";
}


