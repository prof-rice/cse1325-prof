import menu.MenuItem;
import menu.Menu;

import java.util.Scanner;

// This class implements the game of the same name from "The Big Bang Theory"
// https://youtu.be/aQ1Nmxp55ms?si=GytMn13N9oodtFaL

public class RockPaperScissorsLizardSpock {
    private static final String NAME = "Rock Paper Scissors Lizard Spock";
    private static final String BORDER = "\n" + "=".repeat(NAME.length()) + '\n';
    private static final String CLEAR = "\n".repeat(80);
    private static String result = "Welcome to " + NAME;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create the menu
        Menu menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit", () -> quit()));
        for(Choice c : Choice.values()) {
            menu.addMenuItem(new MenuItem(c.toString(), () -> choose(c)));
        }
        
        final String titleMenu = CLEAR + BORDER + NAME + BORDER + "\n" + menu + "\n\n";
        final String prompt = "\n\nChoose carefully! ";
        
        // Main loop! (See ExampleMenu for using Menu's main loop instead)
        while(true) {
            System.out.print(titleMenu + result + prompt);
            try {
                menu.run(scanner.nextInt());
            } catch (Exception e) {
                if(scanner.hasNextLine()) { // User typed erroneous entry
                    result = "Invalid choice!";
                    scanner.nextLine();     // Clear the erroneous entry
                } else {                    // Control-d EOF on input, unrecoverable
                    System.err.println("\nConnection lost..."); 
                    System.exit(-1);        // Report error to the shell
                }
            }
        }
    }
    public static void choose(Choice playerChoice) {
        Choice computerChoice = Choice.random();
        result = playerChoice.outcome(computerChoice); // "" if tie, null if player lost
        
        // Adjust result of the game to show the user
        if(result == null) result = "You lose! " + computerChoice.outcome(playerChoice);
        else if (result == "") result = "You both chose " + playerChoice;
        else result = "You win! " + result;
    }
    public static void quit() {
        System.out.println("Thanks for playing " + NAME + "!");
        System.exit(0); // Proper exit
    }
}
