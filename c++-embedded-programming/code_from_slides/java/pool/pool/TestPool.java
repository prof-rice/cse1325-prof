package pool;

import java.util.ArrayList;
import java.util.Scanner;

class Info {
    public Info() {
        id = nextID++;
    }
    public Info(Info source) { // Copy constructor (MUST be public!)
        this();
        random = source.random;
    }
    void set(double d) {
        random = d;
    }
    @Override
    public String toString() {
        return String.format("Info #%d)->%f (0x%x)", id-1, random, this.hashCode());
        //return "Info #" + (id-1) + "->" + random + " (" + this.hashCode() + ")";
    }
    @Override
    public boolean equals(Object rhs) {
        if(this == rhs) return true;
        if(rhs == null) return false;
        if(getClass() != rhs.getClass()) return false;
        Info info = (Info) rhs;
        return random == info.random;
    }
    @Override
    public int hashCode() {
        return Double.hashCode(random);
    }

    double random;  // The payload
    private int id;
    private static int nextID = 0;

}

public class TestPool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Info> infos = new ArrayList<>(); // references pool data
        Pool<Info> pool = new Pool<>(10, new Info());
        
        String menu = "\n(0) Exit (1) Add item (2) Remove item: ";
        int selection = -1;
        while(selection != 0) {
            System.out.println("\nPool\n====\n" + pool + "\nInfos\n=====\n");
            for(int i=0; i<infos.size(); ++i) 
                System.out.println("  " + i + ") " + infos.get(i));
            System.out.print(menu);
            selection = in.nextInt();
            if(selection == 1) {
                Info info = pool.get();
                System.err.println("Got " + info); // DEBUG
                if(info != null) {
                    double d = Math.random();
                    System.out.println("Putting " + d + " into pool");
                    info.set(d);
                    infos.add(info);
                } else {
                    System.err.println("#### Out of pool");
                }
            } else if (selection == 2) {
                System.out.print("Free which item? ");
                int item = in.nextInt();
                if(item >= 0 && item < infos.size()) {
                    pool.free(infos.get(item));
                    if(pool.lostValue != null) {
                        System.err.println("#### LOST VALUE! " + pool.lostValue);
                        pool.lostValue = null;
                    }
                    infos.remove(item);
                } else {
                    System.err.println("#### No such item!");
                }
            } else if (selection != 0) {
                System.err.println("#### Invalid selection\n");
            }
        }
    }
}
