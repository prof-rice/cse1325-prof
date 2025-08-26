import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        // Instance a Scanner to read guesses
        Scanner in = new Scanner(System.in);
        
        // Instance 5 Platonic solids
        Die d4 = new Die(4);
        Die d6 = new Die(6);
        Die d8 = new Die(8);
        Die d12 = new Die(12);
        Die d20 = new Die(20);
        
        // Calculate the sum of one roll each
        int sum = d4.roll() + d6.roll() + d8.roll() + d12.roll() + d20.roll();
        
        // Show the instructions
        System.out.print(
            "I've rolled one of each Platonic solid - 4, 6, 8, 12, and 20 sides.\n"
          + "Try to guess the sum!\nGuess:  ");
        
        // Count the number of guesses
        int guesses = 0;
        
        // Accept guesses until correct
        int guess = 0;
        while(guess != sum) {
            guess = in.nextInt();
            ++guesses;
            if(guess > sum)      System.out.print  ("Lower:  ");
            else if(guess < sum) System.out.print  ("Higher: ");
            else                 System.out.println("Exactly!");
        }
        System.out.println("You guessed " + guesses + " times.");
    }
}
