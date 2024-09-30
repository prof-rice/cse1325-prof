import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Logger {
    public Logger() {
        Random random = new Random();
        for(int i=0; i<8000000; ++i)
            logs.add(random.nextDouble());
    }
    private static ArrayList<Double> logs = new ArrayList<>();
}

public class BadLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press Enter to continue:");
        String wait = sc.nextLine();   // Wait for user to press Enter

        Logger logger = new Logger();  // Looks innocent enough?

        System.out.print("Press Enter to continue:");
        wait = sc.nextLine();   // Wait for user to press Enter
    }
}


