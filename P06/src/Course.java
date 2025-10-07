public class Course {
    public Course(String dept, int number) {
        if(dept.length() < 3 || dept.length() > 4)
            throw new InvalidCourseException(dept);
        if(number < 1000 || number > 9999)
           throw new InvalidCourseException(dept, number);
        this.dept = dept;
        this.number = number;
    }
    @Override
    public String toString() {
        return dept + number;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Course c = (Course) o;
        return c.dept.equals(dept) &&
               c.number == number;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(dept, number);
    }
    private String dept;
    private int number;
}
