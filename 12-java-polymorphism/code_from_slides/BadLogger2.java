import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Logger2 {
    public Logger2() {
        Random random = new Random();
        for(int i=0; i<8000000; ++i)
            logs.add(random.nextDouble());
    }
    private static ArrayList<Double> logs = new ArrayList<>();
}

public class BadLogger2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press Enter to continue:");
        String wait = sc.nextLine();   // Wait for user to press Enter

        {
            Logger2 logger = new Logger2();  // Looks innocent enough?

            System.out.print("Press Enter to continue:");
            wait = sc.nextLine();   // Wait for user to press Enter
        }
        
        System.out.print("Press Enter to continue:");
        wait = sc.nextLine();   // Wait for user to press Enter
    }
}


