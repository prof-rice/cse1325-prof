import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int day, imonth, year;
        Month month;
        Scanner in = new Scanner(System.in);
        System.out.print("In what year were you born? ");
        year = in.nextInt();
        System.out.print("In what month were you born (1-12)? ");
        imonth = in.nextInt();
        System.out.print("On what day were you born? ");
        day = in.nextInt();
        
        Month m = Month.values()[imonth-1];
        Date birthday = new Date(year, m, day);
        System.out.println("Your birthday is " + birthday
                         + " with gemstone " + m.asGemstone());
    }
}        
        
