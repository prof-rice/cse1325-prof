/**
 * Provides classes to simplify writing a menu-driven interface (mdi) console application,
 * using simple constructs analogous in many ways to (though far simpler than) the
 * <a href="https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/package-summary.html">
 * javax.swing</a> library.
 * <p>
 * Menu, similar in concept to JMenu, supports organization, presentation, and selection 
 * of MenuItem objects. Printing a Menu object prints the menu comprised of the aggregated
 * MenuItem objects. Calling run with an item number invokes the observer for the menu
 * item with that index.
 * <p>
 * In addition, utility methods are provided to collect a String or primitive value
 * from the user or to select from an array or List object.
 *
 * @since 1.0
 */
package menu;
