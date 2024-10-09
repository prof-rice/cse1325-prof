import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import java.util.Objects;

class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private Integer ID;
    private List<Double> grades;

    public Student(String firstName, String lastName, Integer ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.grades = new ArrayList<>();
    }

    public void addGrades(Double... grades) { // grades is an array
        for(Double grade : grades) this.grades.add(grade);
    }

    public Double[] grades() {
        return grades.toArray(new Double[grades.size()]);
    }
    @Override // Comparable interface
    public int compareTo(Student s) {
        int result = lastName.compareTo(s.lastName);               // Sort by last name
        if(result == 0) result = firstName.compareTo(s.firstName); // ... then first name
        if(result == 0) result = ID.compareTo(s.ID);               // ... then ID
        return result;
    }
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;     // Is it me?
        if(o == null                   // Is it my type?
          || ! (o instanceof Student)) return false;
        Student s = (Student) o;       // Downcast to my type
        return compareTo(s) == 0;      // Compare significant fields using compareTo
    }
    @Override
    public int hashCode() {         // If s1.equals(s2), they MUST have same hashCode.
        return Objects.hash(lastName, firstName, ID); // So use SAME fields as equals!
    }
    @Override
    public String toString() {
        double sum = 0;
        for(double grade : grades) sum += grade;
        return String.format("%s %s (%d, %3.1f average)", 
                  firstName, lastName, ID, sum / grades.size());
    }
}

public class SetHashCodeExample {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();

        Student s = new Student("Fred", "Flintstone", 1002391);
        s.addGrades(82.0, 91.0, 66.0, 102.0, 98.0);
        students.add(s);
        s = new Student("Barney", "Rubble", 1001134);
        s.addGrades(58.0, 62.0, 71.0, 59.0, 91.0, 88.0, 89.0, 76.0);
        students.add(s);
        s = new Student("Wilma", "Flintstone", 1001912);
        s.addGrades(91.0, 93.0, 88.0, 90.0);
        students.add(s);
        s = new Student("Betty", "Rubble", 1002201);
        s.addGrades(92.0, 103.0, 98.0, 101.0);
        students.add(s);

        System.out.println("Students: ");
        for(Student student : students) System.out.println("  " + student);
        System.out.println("");
    }
}

