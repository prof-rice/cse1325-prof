package session;

import people.Tutor;
import people.Student;

import java.util.List;
import java.util.ArrayList;

/**
 * Models a tutoring session on a specific course
 *
 * Each tutoring session is solely associated with a course and a tutor.
 * <p/>
 * Initially no date and time are associated with a session, but these
 * may be set or changed at any time.
 * <p/>
 * No students are initially associated with a session, but any number 
 * may be added as needed.
 *
 * @author             Prof Rice
 * @version            1.3
 * @since              1.3
 * @license.agreement  Gnu General Public License 3.0
 */
public class Session {
    /**
     * Creates a tutoring Session. If either parameter is null,
     * an {@link java.lang.IllegalArgumentException} is thrown. 
     * The date, time, and students are initially not assigned.
     *
     * @param course       the subject matter for this tutoring session
     * @param tutor        the person who will teach the course material
     * @throws IllegalArgumentException if any parameter is null
     * @since              1.3
     */
    public Session(Course course, Tutor tutor) {
        if(course == null | tutor == null)
            throw new IllegalArgumentException("Session invalid constructor parameter");
        this.course = course;
        this.tutor = tutor;
        this.students = new ArrayList<>();
        this.dates = null;
    }
    /**
     * Sets or changes the scheduled date, time, and duration.
     *
     * @param date      The date of the session in the form YYYY-MM-DD
     * @param startTime The time of the session in the form HH:mm (24-hour clock)
     * @param duration  How long in minutes the session is planned
     * @since           1.3
     */
    public void setSchedule(String date, String startTime, long duration) {
        dates = new DateRange(date, startTime, duration);
    }
    /**
     * Adds a student to the tutoring session.
     *
     * @param student   The student who plans to attend this tutoring session
     * @since           1.3
     */
    public void addStudent(Student student) {
        students.add(student);
    }
    /**
     * Represents the session topic, date and time, tutor, and student(s).
     *
     * The format is as follows.
     *
     * <pre>
     * {@code
     * Session on <course> at <date, time, duration>.
     *   Tutor: <tutor>
     *   Students: <student1>, <student2>, ...
     * }</pre>
     * 
     * If the session is not yet scheduled, the date and time is reported
     * as "at an unspecified date". StringBuilder
     * <p/>
     * If no students have yet enrolled in this session, "Students:" is
     * replaced with "No students are assigned to this session".
     *
     * @return          the resulting Complex number
     * @since           1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Session on " + course + " at " + 
            ((dates != null) ? dates : "an unspecified date"));
        sb.append("\n  Tutor:    " + tutor);
        if(students.isEmpty()) {
            sb.append("\n  No students are assigned to this session");
        } else {
            sb.append("\n  Students: ");
            String div = "";
            for(Student s : students) {
                sb.append(div + s);
                div = ", ";
            }
        }
        return sb.toString();
    }

    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List<Student> students;
}
