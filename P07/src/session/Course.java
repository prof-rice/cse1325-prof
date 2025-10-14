package session;

/**
 * Represents a department and course number.
 *
 * The department must be 3-4 characters in length.
 * The course number must be a 4-digit integer between 1000 and 9999.
 * If either are invalid, a {@link session.InvalidCourseException}
 * will be thrown.
 * <p/>
 * Similarly, time should follow a 24-hour clock in the ISO 8601 format,
 * which is HH:MM (where HH is 00 to 23 hours and MM is 00 to 59 minutes).
 * <p/>
 * The start and end time are on the same date.
 *
 * @author             Prof Rice
 * @version            1.3
 * @since              1.3
 * @license.agreement  Gnu General Public License 3.0
 */
public class Course {
    /**
     * Creates a tutoring Session. If either parameter is null,
     * an {@link session.InvalidCourseException} is thrown. 
     * The date, time, and students are initially not assigned.
     *
     * @param dept       the 3- or 4-char department, such as CSE or MATH
     * @param number     the course number between 1000 and 9999
     * @throws InvalidCourseException if any parameter is out of range
     * @since              1.3
     */
    public Course(String dept, int number) {
        if(dept.length() < 3 || dept.length() > 4)
            throw new InvalidCourseException(dept);
        if(number < 1000 || number > 9999)
           throw new InvalidCourseException(dept, number);
        this.dept = dept;
        this.number = number;
    }
    /**
     * Represents the department and course number, such as CSE1325.
     *
     * @return          the course identifier
     * @since           1.0
     */
    @Override
    public String toString() {
        return dept + number;
    }
    /**
     * Compares this course to the specfied object.
     *
     * @return          True if both dept and course are equal, false otherwise.
     * @since           1.0
     */
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Course c = (Course) o;
        return c.dept.equals(dept) &&
               c.number == number;
    }
    /**
     * Returns a hash code for this course.
     *
     * @return          the Object.hash calculated from both dept and number.
     * @since           1.0
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(dept, number);
    }
    private String dept;
    private int number;
}
