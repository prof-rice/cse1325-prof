import java.util.Deque;      // Interface
import java.util.ArrayDeque; // Class implementations
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> lifo = new ArrayDeque<>(); // Last-In First-Out Stack
        Deque<Integer> fifo = new LinkedList<>(); // First-In First-Out Stack
        int popped;
        
        // Pushing is the same for LIFO and FIFO
        System.out.print("Pushing ");
        for (int i=1; i<10; ++i) {
            System.out.print("... " + i);
            lifo.push(i);
            fifo.push(i);
        }
        System.out.println('\n');
        
        // To pop the LIFO, use pop() method
        for(int i=0; i<3; ++i)
            System.out.println("Popped from LIFO: " + lifo.pop());
        System.out.println("LIFO is now " + lifo + '\n');
            
        // To pop the FIFO, use removeLast() method
        for(int i=0; i<3; ++i)
            System.out.println("Popped from FIFO: " + fifo.removeLast());
        System.out.println("FIFO is now " + fifo + '\n');

    }
}
