/**
 * Provides classes to simplify writing a multi-level menu-driven console application,
 * using simple constructs analogous to the javax.swing library.
 * <p>
 * Menu, similar in concept to JMenu, supports organization, presentation, and selection 
 * of MenuItem objects that are similar in concept to JMenuItem. When run, a Menu object 
 * will present its menu either {@link Menu#runOnce() once} or {@link Menu#run() repeatedly}, 
 * requesting a user selection and calling the action listener assigned to the selected 
 * MenuItem object. 
 * <p>
 * A menu action may be to run another Menu object, either once or repeatedly. In addition,
 * utility methods are provided to enable selection from an array, List, or the filesystem.
 * <p>
 * Any menu may be exited without further selection(s) by entering 'x'.
 * <p>
 * Package pizza contains an example.
 *
 * @since 1.0
 */
package attomenu;