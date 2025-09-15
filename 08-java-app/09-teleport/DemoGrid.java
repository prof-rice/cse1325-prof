import java.util.Scanner;

public class DemoGrid {
    public static void main(String[] args) {
        Game game = new Game(30);
        char command = '5';
        while(true) {
            try {
                game.printGrid();
                command = (char)System.in.read();
                game.executeCommand(command);
            } catch (Exception e) {
                System.err.println("Invalid command: " + command);
            }
        }
    }
}
