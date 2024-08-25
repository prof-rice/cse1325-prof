public class Date {
    // Private (encapsulated) data FIELDS
    private int year;
    private Month month;
    private int day;

    // The Constructor that is invoked when an object of class Date is instanced
    public Date(int year, Month month, int day) {
        // To this.field assign the associated parameter
        this.year = year;
        this.month = month;
        this.day = day;
        
        // Month is an enum, so it is known good
        // But throw an "exception" (error) if the day is obviously invalid
        // More on "exceptions" in Lecture 05
        if(1 > day || day > 31) throw new IllegalArgumentException(
                                "Day must be between 1 and 31");
    }

    // Tell Java how to convert an object of this type into a String
    // The @Override helps us catch typographical errors - more later
    @Override
    public String toString() {
        return day + " " + month + ", " + year;
    }
    
    // This methods is the entry point for the class, and is called by the OS
    //   using the 'java Date' bash command
    public static void main(String[] args) {
        // For non-primitives, assign a new value with the "new" keyword
        Date birthday = new Date(1950, Month.December, 30);
        System.out.println(birthday);
    }    
}
