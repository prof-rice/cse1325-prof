import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

public class SetExample {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        Set<String> sortedWords = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        while(in.hasNext()) {
            String s = in.next();
            words.add(s);
            sortedWords.add(s);
        }
        
        System.out.print("Words: ");
        for(String s : words) System.out.print(s + " ");
        
        System.out.print("\nSorted: ");
        for(String s : sortedWords) System.out.print(s + " ");
        System.out.println("");
    }
}
