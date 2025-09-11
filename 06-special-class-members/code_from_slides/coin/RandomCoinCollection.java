import java.util.Arrays;

public class RandomCoinCollection {
    // This is the actual collection
    private static Coin[] coins;
    
    // This prints the collection in order
    private static void printCoins() {
        for(Coin c : coins) System.out.println(c);
    }
    
    // Create a random collection, print it, then sort and print it again
    public static void main(String[] args) {
        final int numCoins =
            (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        coins = new Coin[numCoins];
        for(int i=0; i<numCoins; ++i) coins[i] = new Coin();
        
        System.out.println("\nUnsorted:\n");
        printCoins();
        
        // Arrays.sort will sort any array as long 
        //   as the stored objects implement Comparable
        Arrays.sort(coins);
        
        System.out.println("\nSorted:\n");
        printCoins();
    }
}
