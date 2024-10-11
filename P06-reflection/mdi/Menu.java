package mdi;

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

// This class manages the entire menu and dispatch table
class Menu {
    private static Scanner in = new Scanner(System.in);
    private List<MenuItem> items = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<items.size() ; ++i)
            sb.append(" " + i + "] " + items.get(i) + "\n");
       return sb.toString();
    }

    public void run(int itemNumber) {
        items.get(itemNumber).run();
    }
    
    // /////////////////////////////////////////////////////////////////////////
    //                         U T I L I T Y   M E T H O D S

    // Show the prompt and return a string, with optional defaultInput
    // If the user enters an empty string and defaultInput is not null, defaultInput is returned
    // If cancelInput is not null and the user entered the cancelInput string, null is returned
    public static String getString(String prompt, String cancelInput, String defaultInput) {
        String s = null;
        while(true) {
            try  {
                System.out.print(prompt);
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
    public static String getString(String prompt, String cancelInput) {
        return getString(prompt, cancelInput, null);
    }
    public static String getString(String prompt) {
        return getString(prompt, null, null);
    }

    // Show the prompt and return an Integer (or null if cancelInput is entered
    //     or if an empty string is entered and defaultInput is null or omitted)
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
    public static Integer getInt(String prompt, String cancelInput) {
        return getInt(prompt, cancelInput, null);
    }
    public static Integer getInt(String prompt) {
        return getInt(prompt, null, null);
    }
    
    // Show the prompt and return a double (or null if cancelInput is entered
    //     or if an empty string is entered and defaultInput is null or omitted)
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
    public static Double getDouble(String prompt, String cancelInput) {
        return getDouble(prompt, cancelInput, null);
    }
    public static Double getDouble(String prompt) {
        return getDouble(prompt, null, null);
    }

    // Show the prompt and return a Boolean (or null if cancelInput is entered
    //     or if an empty string is entered and defaultInput is null or omitted)
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
    public static Boolean getBoolean(String prompt, String cancelInput) {
        return getBoolean(prompt, cancelInput, null);
    }
    public static Boolean getBoolean(String prompt) {
        return getBoolean(prompt, null, null);
    }
    
    // Show the prompt and return a char (or null if cancelInput is entered
    //     or if an empty string is entered and defaultInput is null or omitted)
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
    public static Character getChar(String prompt, String cancelInput) {
        return getChar(prompt, cancelInput, null);
    }
    public static Character getChar(String prompt) {
        return getChar(prompt, null, null);
    }
    
    // Select an item from an array
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput, String defaultInput) {
        return switch(array.length) {
            case 0  -> null;
            case 1  -> 1;
            default -> {
                           for(int i=0; i<array.length; ++i) 
                               System.out.printf("%4d] %s\n", i, array[i]);
                           yield getInt(prompt, cancelInput, defaultInput);
                       }
        };
    }
    public static Integer selectItemFromArray(String prompt, Object[] array, String cancelInput) {
        return selectItemFromArray(prompt, array, cancelInput, null);
    }
    public static Integer selectItemFromArray(String prompt, Object[] array) {
        return selectItemFromArray(prompt, array, null, null);
    }

    // Select an item from a list
    public static Integer selectItemFromList(String prompt, List list, String cancelInput, String defaultInput) {
        return selectItemFromArray(prompt, list.toArray(), cancelInput, defaultInput);
    }
    public static Integer selectItemFromList(String prompt, List list, String cancelInput) {
        return selectItemFromArray(prompt, list.toArray(), cancelInput, null);
    }
    public static Integer selectItemFromList(String prompt, List list) {
        return selectItemFromArray(prompt, list.toArray(), null, null);
    }
}


