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

import java.util.Objects;

/**
 * Associates menu text with a response when selected.
 * <p>
 * MenuItem is philisophically similar to Swing's {@link javax.swing.JMenuItem}, except that
 * MenuItem relies on {@link java.lang.Runnable} rather than {@link java.awt.event.ActionListener}
 * for the response.
 * <p>
 * When printed, MenuItem prints the menuText. Calling {@link run()} invokes the menuResponse.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 * @see Menu
 */
public class MenuItem implements Runnable {
    /**
     * @param menuText      Text to display when the menu is printed
     * @param menuResponse  Object that delegates to the menu item response
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
    @Override
    public void run() {
        menuResponse.run();
    }
    private Object menuText;        // The text displayed to the user
    private Runnable menuResponse;  // run() is called on this object when selected

    /**
     * Returns the hash code value for this menuItem.
     */
    @Override
    public int hashCode() {
        return Objects.hash(menuText, menuResponse);
    }
    /**
     * Compares the specified object with this menuItem for equality. 
     * <p>
     * Returns true if and only if the specified object is also a MenuItem
     * and the menuText and menuResponse are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MenuItem other = (MenuItem) obj;
        return menuText.equals(other.menuText) && 
               menuResponse.equals(menuResponse);
    }

}