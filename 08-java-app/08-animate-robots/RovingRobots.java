public class RovingRobots {
    public static void main(String[] args) {
        int numRobots = (args.length > 0) ? Integer.parseInt(args[0]) : 30;
        Game game = new Game(numRobots);
        game.cli();
    }
}
