enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

class Foo {
    private DayOfWeek dayOfWeek;
    Foo(DayOfWeek day) {dayOfWeek = day;}
    public void setDayOfWeek(DayOfWeek day) {dayOfWeek = day;}
    public DayOfWeek day() {return dayOfWeek;}
}

public class PassByValue {
    public static void everyDayIsFriday(DayOfWeek dow) { 
        dow = DayOfWeek.FRIDAY;
    }
    public static void everyDayIsFriday(Foo foo) { 
        foo.setDayOfWeek(DayOfWeek.FRIDAY);
    }
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY;    
        everyDayIsFriday(day);
        System.out.println(day); // primitives are pass by value
        
        Foo foo = new Foo(DayOfWeek.MONDAY);
        everyDayIsFriday(foo);
        System.out.println(foo.day()); // objects behave as pass by refernece
    }
}
