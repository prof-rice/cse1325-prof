package mdi;

import menu.Menu;
import menu.MenuItem;

import session.Course;
import session.Session;

import people.Student;
import people.Tutor;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MavTutor {

    // construct and run the menu

    public MavTutor() {
        String clearScreen = "\n".repeat(80);
        
        try(Scanner in = new Scanner(new File("mdi/logo.txt"))) {
            while(in.hasNextLine()) logo.add(in.nextLine());
        } catch(IOException e) {
            logo.clear();
            logo.add("Welcome to MavTutor!");   // The title of the menu
            logo.add("=".repeat(logo.get(0).length()));
        }
        
        System.out.print(clearScreen);
        try {
            for(int i=0; i<36; ++i) {
                System.out.println((i<logo.size()) ? logo.get(i) : "");
                Thread.sleep(80);
            }
        } catch(Exception e) {
        }

        menu = new Menu(
            new Object[] {clearScreen, logo},        // pre            
            new Object[] {this, "\nSelection?"},     // post: 'this' invokes toString()
            new MenuItem("Quit\n",          () -> quit()),      // lambda

            new MenuItem("View Courses",  () -> selectView(courses)),
            new MenuItem("New Course\n",    this::newCourse),   // method reference

            new MenuItem("View Students", () -> selectView(students)),
            new MenuItem("New Student\n",   this::newStudent),

            new MenuItem("View Tutors",   () -> selectView(tutors)),
            new MenuItem("New Tutor\n",     this::newTutor),

            new MenuItem("View Sessions", () -> selectView(sessions)),
            new MenuItem("New Session\n",   this::newSession),

            new MenuItem("New MavTutor",   this::newz),
            new MenuItem("Save",           this::save),
            new MenuItem("Save as",        this::saveAs),
            new MenuItem("Open",           this::open)
        );
        dirty = false; // No data to lose (changed to true when data is created)
        menu.run();    // Main loop via the menu package, exit when menu.result == null
    }
    public static void main(String[] args) {
        new MavTutor();
    }
    
    // toString returns the view of the data to display below menu.result
    
    @Override
    public String toString() {
        if(view == courses)  return Menu.listToString("Courses\n=======\n\n", courses, '•');
        if(view == students) return Menu.listToString("Students\n========\n\n", students, '•');
        if(view == tutors)   return Menu.listToString("Tutors\n======\n\n", tutors, '•');
        if(view == sessions) return Menu.listToString("Sessions\n========\n\n", sessions, '•');
        return "";
    }

    // "Observers" respond to menu selections
    
    private void quit() {
        if(safeToDiscardData())
            menu.result = null; // Signals menu to exit the main loop
    }
    private void selectView(List list) {
        view = list; // Specifies which data to display via toString() below
    }
    private void newCourse() { // Create a course and add to courses List
        try {
            Course course = new Course(Menu.getString("Enter dept: "),
                                       Menu.getInt("Enter course number: "));
            if(course.equals(shazam)) {shazam(); return;}
            if(courses.indexOf(course) == -1) {
                courses.add(course);
                dirty = true; // Unsaved data is present
                menu.result.append("Added " + course);
            } else {
                menu.result.append("Course " + course + " is already defined!");
            }
        } catch(Exception e) {
            menu.result.append("Error adding Course: " + e.getMessage());
        }
        selectView(courses);
    }
    private void newTutor() { // Create a tutor and add to tutors List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            String name  = Menu.getString("Enter name: ");
            String email = Menu.getString("Enter email: ");
            Integer ssn  = Menu.getInt("Enter SSN: ");
            String bio   = Menu.getString("Enter biography: ");
            Integer index = Menu.selectItemFromList(
                "Select course of expertise: ", courses);
            Tutor tutor = new Tutor(name, email, ssn, bio, courses.get(index));
            tutors.add(tutor);
            dirty = true; // Unsaved data is present
            menu.result.append("Added tutor " + tutor);
        } catch(Exception e) {
            menu.result.append("Error adding Tutor: " + e.getMessage());
        }
        selectView(tutors);
    }
    private void newStudent() { // Create a student and add to students List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            Student student = new Student(Menu.getString("Enter name: "),
                                          Menu.getString("Enter email: "));
            Integer index = null;
            int coursesAdded = 0;
            do {
                index = Menu.selectItemFromList("Select course of interest: ",
                                               courses);
                if(index != null) student.addCourse(courses.get(index));
            } while(index != null && courses.size() > ++coursesAdded);
            students.add(student);
            dirty = true; // Unsaved data is present
            menu.result.append("Added student " + student);
        } catch(Exception e) {
            menu.result.append("Error adding Student: " + e.getMessage());
        }
        selectView(students);
    }
    private void newSession() { // Create a session and add to sessions List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            if(tutors.isEmpty()) {
                menu.result.append("Please define a tutor first!");
                return;
            }
            if(students.isEmpty()) {
                menu.result.append("Please define a student first!");
                return;
            }
            Integer i1 = Menu.selectItemFromList("Select course: ", courses);
            if(i1 == null) return;
            Course course = courses.get(i1);
            
            Integer i2 = Menu.selectItemFromList("Select tutor: ", tutors);
            if(i2 == null) return;
            Tutor tutor = tutors.get(i2);
            
            if(!tutor.getCourse().equals(course)) {
                menu.result.append("Error adding Session: " + tutor + " lacks expertise in " + course);
                return;
            }
            
            Session session = new Session(course, tutor);
            
            session.setSchedule(Menu.getString("Enter date (YYYY-MM-DD): "),
                                Menu.getString("Enter starting time (HH:mm): "),
                                Menu.getInt("Enter duration in minutes: "));

            Integer index = null;
            int studentsAdded = 0;
            do {
                index = Menu.selectItemFromList("Select student to add: ",
                                                students);
                if(index != null) session.addStudent(students.get(index));
            } while(index != null && students.size() > ++studentsAdded);

            sessions.add(session);
            dirty = true; // Unsaved data is present
            menu.result.append("Added " + session);
            
        } catch(Exception e) {
            menu.result.append("Error adding Session: " + e.getMessage());
        }
        selectView(sessions);
    }

    private void newz() {
        if(safeToDiscardData()) {
            courses.clear();
            students.clear();
            tutors.clear();
            sessions.clear();
            file = null;
            dirty = false; // no data exists to BE dirty!
        }
    }
    private void save() {
        if(file == null)
            file = Menu.selectFile("Save to file: ", null, null);
        if(file != null) {
            try(PrintStream out = new PrintStream(file)) {
                out.println(courses.size());
                for(var c : courses) c.save(out);
                
                out.println(students.size());
                for(var s : students) s.save(out);
                
                out.println(tutors.size());
                for(var t : tutors) t.save(out);
                
                out.println(sessions.size());
                for(var s : sessions) s.save(out);
                
                dirty = false; // data has been safely saved
                menu.result.append("Saved all data to " + file);
            } catch(IOException e) {
                menu.result.append("\nERROR: Unable to save to " + file + "\n  " + e);
            }
        } else {
            menu.result.append("\nData was not saved.");
        }
    }
    private void saveAs() {
        File temp = file;
        file = null;           // Force save() to ask for new file
        save();                // Try to save the data
        if(dirty) file = temp; // Restore original file if data wasn't saved
    }
    private void open() {
        if(safeToDiscardData()) {
            dirty = false;
            file = Menu.selectFile("Open file: ", null, null);
            if(file != null) {
                try(Scanner in = new Scanner(file)) {
                    courses  = new ArrayList<>();
                    int size = in.nextInt(); in.nextLine();
                    while(size-- > 0)
                        courses.add(new Course(in));
                    
                    students = new ArrayList<>();
                    size = in.nextInt(); in.nextLine();
                    while(size-- > 0)
                        students.add(new Student(in));

                    tutors   = new ArrayList<>();
                    size = in.nextInt(); in.nextLine();
                    while(size-- > 0)
                        tutors.add(new Tutor(in));

                    sessions = new ArrayList<>();
                    size = in.nextInt(); in.nextLine();
                    while(size-- > 0)
                        sessions.add(new Session(in));
                } catch(IOException e) {
                    menu.result.append("\nERROR: Unable to open file " + file + "\n  " + e);
                    newz(); // Discard any partial data that was read
                }
            }
        }
    }
    private boolean safeToDiscardData() {
        if(!dirty) return true;
        System.out.print("\nWARNING: Unsaved data will be lost!");
        while(true) {
            Character c = Menu.getChar("(S)ave, (D)iscard, or (A)bort? ");
            if(c == null) break;
            switch(c) {
                case 's', 'S' -> { save();        }
                case 'd', 'D' -> { dirty = false; }
                case 'a', 'A' -> { break;         }
                default       -> { continue;      }
            }
            break;
        }
        return !dirty;
    }

    private final Course shazam = new Course("SZM", 9999); 
    private void shazam() {
        courses.add(new Course("CSE", 1310));
        courses.add(new Course("CSE", 1320));
        courses.add(new Course("CSE", 1325));
        courses.add(new Course("CSE", 1326));
        
        Student s1 = new Student("Suzy Q", "sq123@uta.edu");
        s1.addCourse(courses.get(0));
        students.add(s1);
        
        Student s2 = new Student("Alam Nguyen", "an345@uta.edu");
        s2.addCourse(courses.get(0));
        students.add(s2);
        
        Student s3 = new Student("Chi Vu", "cv876@uta.edu");
        s3.addCourse(courses.get(2));
        students.add(s3);
        
        tutors.add(new Tutor("Sam Smart", "ss987@uta.edu", 123456789, "Smart!", courses.get(0)));
        tutors.add(new Tutor("Suzuki Rin", "sr636@uta.edu", 123456789, "Suzuki!", courses.get(0)));
        
        menu.result.append("### S H A Z A M ! ###");      
    }
    
    // Our data fields
    
    private List<Course>  courses  = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Tutor>   tutors   = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    private File file;
    private boolean dirty;
    
    // Utility fields
    
    private Menu menu;
    private List view = courses; // List to view via toString()
    
    private List<String> logo = new ArrayList<>();
}
