package mdi;

import menu.Menu;
import menu.MenuItem;

import session.Course;
import session.Session;

import people.Person;
import people.Student;
import people.Tutor;

import rating.Rateable;
import rating.Rating;
import rating.Comment;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MavTutor {

    // construct and run the menu

    public MavTutor() {
        try(Scanner in = new Scanner(new File("mdi/logo.txt"))) {
            while(in.hasNextLine()) logo.add(in.nextLine());
        } catch(IOException e) {
            logo.clear();
            logo.add("Welcome to MavTutor!");   // The title of the menu
            logo.add("=".repeat(logo.get(0).length()));
        }
        
        System.out.print(clearScreen);
        try {
            for(int i=0; i<39; ++i) {
                System.out.println((i<logo.size()) ? logo.get(i) : "");
                Thread.sleep(60);
            }
        } catch(Exception e) {
        }

        menu = new Menu(
            new Object[] {clearScreen, logo}, // pre
            new Object[] {this, "\nSelection?"},     // post: 'this' invokes toString()
            new MenuItem("Quit\n",          () -> quit()),      // lambda

            new MenuItem("View Courses",    () -> selectView(courses)), // lambda
            new MenuItem("New Course\n",    this::newCourse), // method reference

            new MenuItem("View Students",   () -> selectView(students)),
            new MenuItem("Review Student",  () -> review(students)),
            new MenuItem("New Student\n",   this::newStudent),

            new MenuItem("View Tutors",     () -> selectView(tutors)),
            new MenuItem("Review Tutor",    () -> review(tutors)),
            new MenuItem("New Tutor\n",     this::newTutor),

            new MenuItem("View Sessions",   () -> selectView(sessions)),
            new MenuItem("Review Session",  () -> review(sessions)),
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
        if(view == courses)  
            return Menu.listToString("Courses\n=======\n\n", courses, '•');
        if(view == students) 
            return Menu.listToString("Students\n========\n\n", students, '•');
        if(view == tutors)   
            return Menu.listToString("Tutors\n======\n\n", tutors, '•');
        if(view == sessions) 
            return Menu.listToString("Sessions\n========\n\n", sessions, '•');
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
            selectView(courses);
            menu.result.append("\nAll data cleared!");
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
                for(var s : students) s.save(out); // name and email only
                
                out.println(tutors.size());
                for(var t : tutors) t.save(out); // name and email only
                
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
                    menu.result.append("\nSuccessfully loaded " + file);
                } catch(IOException e) {
                    menu.result.append("\nERROR: Unable to open file " + file + "\n  " + e);
                    newz(); // Discard any partial data that was read
                }
                selectView(courses);
            }
        }
    }
    
    // Handle ratings and comments
    public void review(List<? extends Rateable> list) {
        if(list.isEmpty()) {
            menu.result.append("\nCreate one to review first!");
            return;
        }
        
        // Select an item from the list to review and against which to browse comments
        Integer index = Menu.selectItemFromList("Which to review? ", list);
        if(index == null) return;
        Rateable rateable = list.get(index);
        
        // Report average rating
        double average = rateable.getAverageRating();
        if(Double.isNaN(average)) {
            System.out.printf("%s has no ratings yet!\n\n", rateable.toString());
        } else {
            System.out.printf("%s has an average rating of %.1f\n\n", 
                rateable.toString(), average);
        }

        // If not logged in, provide the opportunity
        Person user = login();
            
        // Offer for the user to rate and review
        if(user != null) {
            Integer stars = 0;
            while(stars != null && (stars < 1 || stars > 5)) {
                stars = Menu.getInt("\n\n" + user + 
                    "\nAdd your rating between 1 and 5 stars (-1 to not rate): ", 
                    "-1", "-1");
            }
            if(stars != null) {
                Comment review = null;
                String line = Menu.getString("Include your review (Enter to omit): ");
                if(line != null && !line.isEmpty()) {
                    if(user != null) review = new Comment(line, user, null);
                }
        
                rateable.addRating(new Rating(stars, review));
                menu.result.append("\nRated " + rateable + " as " + stars + " stars\n");
            }
        }

        // Review other ratings
        Rating[] ratings = rateable.getRatings();
        System.out.println("\nRatings for " + rateable + "\n\n");
        Comment comment = null;
        while(comment == null) {
            if(ratings.length == 1) System.out.println(ratings[0]);
            index = Menu.selectItemFromArray(
                "\nRead review of which rating (Enter for none)? ", ratings);
            if(index == null) return;
        
            comment = ratings[index].getReview();
            if(comment == null) 
                System.out.println("No review was provided for " + ratings[index]);
        }
        int level = 0;
        
                // Explore and reply to the comments to the selected rating
        while(true) {
            try {
                if(comment == null) return;
                System.out.print(clearScreen + "Comments\n========\n\n");
                printExpandedComments(comment, level);
                Character c = Menu.getChar("\n\n" +
                    " (R)eply" + 
                    ((comment.getInReplyTo() != null) ? " (U)p" : "") +
                    ((comment.numReplies() > 0) ? " (D)own" : "") +
                    " (M)ain menu? "
                );
                switch(c) {
                    case 'r', 'R' -> {
                        if(user == null) login();
                        if(user == null) continue; 
                        comment.addReply(Menu.getString("Reply  as " + user + "? "), user);
                    }
                    case 'u', 'U' -> { 
                        if(level == 0) continue;
                        comment = comment.getInReplyTo();
                        --level;
                    }
                    case 'd', 'D' -> { 
                        if(comment.numReplies() == 0) continue;
                        comment = comment.getReply(Menu.getInt("Reply #? ")); 
                        ++level; 
                    }
                    case 'm', 'M' -> { return; }
                    default       -> { throw new RuntimeException(); }
                }
            } catch(Exception e) {
                System.err.println("#### Invalid selection");
            }
        }
    }
    private Person login() {
        Person user = null;
        System.out.println("\nLogin\n=====\n\n");
        Integer index = Menu.selectItemFromArray("Selection? ", 
            new String[] {"Cancel login", "Tutor login", "Student login"});
        if(index != null && index != 0) {
            boolean isTutor = (index == 1);
            System.out.println();
            index = Menu.selectItemFromList("Login as? ", isTutor ? tutors : students);
            user = isTutor ? tutors.get(index) : students.get(index);
        }
        return user;
    }
    
    // This code was from P05's DemoRatingSystem
    private void printIndented(String multiline, int level) {
        String[] strings = multiline.split("\n");
        for(String s : strings) {
            System.out.println("  ".repeat(level) + s);
        }
    }
    private void printExpandedComments(Comment c, int level) {
        printIndented(c.toString(), level);
        System.out.println("\n");
        for(int i=0; i<c.numReplies(); ++i) {
            printExpandedComments(c.getReply(i), level+1);
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
    
    // Added convenience fields
    private List<String> logo = new ArrayList<>();
    private final String clearScreen = "\n".repeat(80);
}
