package session;

/**
 * Thrown to indicate a University department or course number is not valid.
 *
 * @author             Prof Rice
 * @version            1.3
 * @since              1.3
 * @license.agreement  Gnu General Public License 3.0
 */
public class InvalidCourseException extends IllegalArgumentException {
    /**
     * Constructor if the department is invalid.
     * 
     * @param dept       the invalid department text
     * @since            1.3
     */
    public InvalidCourseException(String dept) {
        super("Invalid dept in new Course: " + dept);
    }
    /**
     * Constructor if the course number is invalid.
     * 
     * @param dept       the invalid course number
     * @since            1.3
     */
    public InvalidCourseException(String dept, int number) {
        super("Invalid course number in new Course: " + dept + " " + number);
    }
}
