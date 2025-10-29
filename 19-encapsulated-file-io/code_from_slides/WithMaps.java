import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.Random;

class MapCounter {
    public MapCounter() {
        Simple s = null;
        for(int i=0; i<100; ++i) {
            s = makeSimple();
            counts.put(s, counts.getOrDefault(s, 0)+1);
        }
    }
    public MapCounter(Scanner in) {
        int size = in.nextInt(); in.nextLine();
        while(size-- > 0) {
            Simple s = new Simple(in);
            int i = in.nextInt(); in.nextLine();
            counts.put(s, i);
        }
    }
    public void save(PrintStream out) {
        out.println(counts.size());
        for(Simple s : counts.keySet()) {
            s.save(out);
            out.println(counts.get(s));
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Simple, Integer> entry : counts.entrySet()) {
            sb.append(String.format("%2d instances of %s\n",
                                 entry.getValue(), entry.getKey()));
        }
        return sb.toString();
    }
    
    private static Simple makeSimple() {
        return new Simple(strings[random.nextInt(strings.length)],
                          ints[random.nextInt(ints.length)],
                          doubles[random.nextInt(doubles.length)],
                          'x',
                          true);
    }
    private static String[] strings = {"hello", "hola", "ni hao", "namaste"};
    private static Integer[] ints = {17, 41};
    private static Double[] doubles = {3.14, 2.78}; 
    private static Random random = new Random();
    
    private Map<Simple, Integer> counts = new HashMap<>();
}

public class WithMaps {
    private static MapCounter mc = new MapCounter();
    private static File file = new File("counts.mc");
    
    public static void save(PrintStream out) {
        mc.save(out);
    }
    
    public static MapCounter open(Scanner in) {
        return new MapCounter(in);
    }

   public static void main(String[] args) {
        System.out.println("Initial MapCounter is:\n" + mc);
        
        try (PrintStream out = new PrintStream(file)) {
            save(out);
            System.out.println("Saved MapCounter to " + file);
        } catch(Exception e) {
            System.err.println("Unable to save " + file + ": " + e);
        }
        
        MapCounter mcReconstructed = null;
        
        try (Scanner in = new Scanner(file)) {
            mcReconstructed = open(in);
            System.out.println("Reconstructed MapCounter from " + file);
        } catch(Exception e) {
            System.err.println("Unable to reconstruct " + file + ": " + e);
        }

        if(mcReconstructed != null)
            System.out.println("Reconstructed MapCounter is:\n" + 
                              mcReconstructed);
    }
}
