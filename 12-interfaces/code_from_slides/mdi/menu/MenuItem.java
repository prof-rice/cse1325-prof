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

/**
 * Associates menu text with a response when selected.
 * 
 * When printed, MenuItem prints the menuText. Calling {@link run()} invokes the menuResponse.
 * <p>
 * For example, 
 *
 * <pre>
 * MenuItem exitApp = new MenuItem("Exit", () -&gt; endApp());
 * System.out.println(exitApp);    // prints "Exit"
 * exitApp.run();                  // calls endApp()
 * </pre>
 *
 * <p>
 * MenuItem is philisophically similar to Swing's {@link javax.swing.JMenuItem}, except that
 * MenuItem relies on {@link java.lang.Runnable} rather than {@link java.awt.event.ActionListener}
 * for the response.
 *
 * @author             Professor George F. Rice
 * @version            1.1
 * @since              1.0
 * @license.agreement  MIT License
 * @see Menu
 */
public class MenuItem implements Runnable {
    /**
     * Initializes a MenuItem object.
     *
     * @param menuText      Text to display when the menu is printed
     * @param menuResponse  Object that delegates to the menu item response
     * @since               1.0
     */
    public MenuItem(Object menuText, Runnable menuResponse) {
        this.menuText = menuText;
        this.menuResponse = menuResponse;
    }
    /**
     * Returns the result of the menuText toString() method.
     */
   @Override
    public String toString() {
        return menuText.toString();
    }
    /**
     * Calls the menuResponse for this menu item.
     */
    @Override // from Runnable
    public void run() {
        menuResponse.run();
    }
    private Object menuText;        // The text displayed to the user
    private Runnable menuResponse;  // run() is called on this object when selected
}


