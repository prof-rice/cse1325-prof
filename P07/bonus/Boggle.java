import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

import java.util.Objects;

public class Boggle {
    private static List<Board> boards = new ArrayList<>();
    private static List<String> words = new ArrayList<>();
    private static Set<Solution> solutions = new TreeSet<>();

    private static int numberOfBoards = 1; // default
    private static int boardSize = 50;     // default is to use 50x50 Boggle boards
    private static int numThreads = 1;     // default is to use a single thread
    private static String filename = "words.txt"; // default (this is the supplied file of 971 common words)
    private static int verbosity = 0;   // smaller ints mean less output - us 0 for timing
    
    private static int nextBoard = 0;
    private static synchronized Integer getNextBoardNumber() {
        if(nextBoard >= boards.size()) return null;
        return nextBoard++;
    }
    private static void solvePuzzles(int threadNumber) {
        Board board = null;
        while(true) {
            Integer boardNumber = getNextBoardNumber();
            if(boardNumber == null) break;
            synchronized(boards) {
                board = boards.get(boardNumber);
            }
            Solver solver = new Solver(board, threadNumber, verbosity);
            int numSolutions = 0;
            long start = System.nanoTime();  // NOT required for Bonus!
            for(String word : words) {
                Solution solution = solver.solve(word);
                if(solution != null) {
                    ++numSolutions;
                    synchronized(solutions) {
                        solutions.add(solution);
                    }
                }
            }
            long end = System.nanoTime();  // NOT required for Bonus!
            if(verbosity == 1) log(String.format("T%03d->B%04d found %4d in %12d ns", 
                           threadNumber, boardNumber, numSolutions, (end-start)), 1);
        }
        log("T" + threadNumber + " exits", 1);
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            // Offer standard help
            if(args.length > 0 && args[0].equals("-h")) {
                System.err.println(
                    """
                    usage: java Boggle [#boards] [boardSize] [#threads] [wordsFilename] [verbosity(0-4)]
                           defaults:       1         50           1       words.txt            0 
                           You may skip any parameters with '-'. To use 4 threads, type: java Boggle - - 4
                           verbosity 0 = # solutions, 1 = threads, 2 = boards & solutions, 3 = details""");
                System.exit(0);
            }
        
            // Parse the other command line arguments
            try {
                if(args.length > 0 && !args[0].equals("-")) numberOfBoards = Integer.parseInt(args[0]);
                if(args.length > 1 && !args[1].equals("-")) boardSize = Integer.parseInt(args[1]);
                if(args.length > 2 && !args[2].equals("-")) numThreads = Integer.parseInt(args[2]);
                if(args.length > 3 && !args[3].equals("-")) filename = args[3];
                if(args.length > 4 && !args[4].equals("-")) verbosity = Integer.parseInt(args[4]);
           } catch(Exception e) {
                    System.err.println("Invalid command line arguments: " + e);
                    System.exit(-2);
            }
    
            // Generate random Boggle boards on which to search
            try {
                for(int i=0; i<numberOfBoards; ++i) {
                    boards.add(new Board(boardSize));
                    log("\nBoard " + i + "\n\n" + boards.get(i) + "\n\n", 2);
                }
            } catch(Exception e) {
                    System.err.println("Unable to generate new Boggle boards: " + e);
                    System.exit(-2);
            }
            // System.exit(0);
        
            // Read the list of words to find on the Boggle Boards
            String s = null;
            try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
                while((s = br.readLine()) != null) words.add(s);
            } catch(IOException e) {
                System.err.println("Unable to read words from file " + filename + ": " + e);
                System.exit(-1);
            }
        
            // Launch worker threads
            Thread[] threads = new Thread[numThreads];
            for(int i=0; i<numThreads; ++i) {
                final int threadNumber = i;
                threads[i] = new Thread(() -> solvePuzzles(threadNumber));
                threads[i].start();
            }

            // Wait for all work to complete
            for(Thread thread : threads) thread.join();

            // Print all the solutions if requested & calculate objective hash
            for(Solution solution : solutions) {
                log(solution.toString(), 2);
            }

            // Print the results. These should be EXACTLY the same regardless of # of threads
            System.out.println("\nFound " + solutions.size() + " solutions");
            System.out.printf("Hash is 0x%08X\n", Objects.hash(solutions));

        } catch(Exception e) {
            System.err.println("Unexpected exception (panic): Contact support");
            e.printStackTrace();
            System.exit(-99);
        }
    }
    // This implements the verbosity from Boggle, printing the debug message only if requested
    private static void log(String s, int level) {
        if(verbosity == level) System.out.println(s);
    }
    

}
