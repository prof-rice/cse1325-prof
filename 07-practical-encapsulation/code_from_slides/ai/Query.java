import java.util.Scanner;

public class Query {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(args.length == 0) {
            System.err.print("Available search engines are");
            for(Engine engine : Engine.values())
                System.err.print(" " + engine);
            System.err.println();
            System.exit(0);
        }
        Engine engine = Engine.valueOf(args[0]);
        System.out.println("Using Engine " + engine);
        AI ai = new AI(engine);
        
        while(!ai.isFinished()) {
            System.out.print(">> ");
            if(!scanner.hasNextLine()) break;
            String question = scanner.nextLine();
            System.out.println(ai.query(question) + "\n");
        }
        
        System.out.println("\n\nYour most recent queries were:");
        for(var s : ai.getQueryHistory())
            System.out.println("  " + s);
    }
}
