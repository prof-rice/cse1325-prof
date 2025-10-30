import java.io.PrintStream;
import java.io.File;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Super {
    public Super(String name) {
        this.name = name;
    }
    public Super(Scanner in) {
        this.name = in.nextLine();
    }
    public void save(PrintStream out) {
        out.println(name);
    }
    @Override
    public String toString() {
        return "Superclass " + name;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return true;
        Super s = (Super) o;
        return s.name.equals(name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    private String name;
}

class Sub1 extends Super {
    public Sub1(String name) {
        super(name);
    }
    public Sub1(Scanner in) {
        super(in);
    }
    public void save(PrintStream out) {
        super.save(out);
    }
    @Override
    public String toString() {
        return super.toString() + " Sub1";
    }
}

class Sub2 extends Super {
    public Sub2(String name) {
        super(name);
    }
    public Sub2(Scanner in) {
        super(in);
    }
    public void save(PrintStream out) {
        super.save(out);
    }
    @Override
    public String toString() {
        return super.toString() + " Sub2";
    }
}

public class Challenge {
    private List<Super> supers;
    public Challenge(String[] names) {
        supers = new ArrayList<>();
        Random random = new Random();
        for(String s : names) {
            if(random.nextBoolean()) supers.add(new Sub1(s));
            else supers.add(new Sub2(s));
        }
    }
    public Challenge(Scanner in) {
        int size = in.nextInt(); in.nextLine();
        supers = new ArrayList<>();
        while(size-- > 0) {
            String type = in.nextLine();
            switch (type) {
                case "Sub1" -> supers.add(new Sub1(in));
                case "Sub2" -> supers.add(new Sub2(in));
                default -> throw new IllegalStateException(
                    "Missing Challenge subclass: " + type);
            }
        }
    }
    private void save(PrintStream out) {
        out.println(supers.size());
        for(Super s : supers) {
            out.println(s.getClass().getName());
            s.save(out);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int pager = 1;
        for(Super s : supers) sb.append(s.toString() + ((pager++ % 4 == 0) ? "\n" : "  "));
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Challenge c = (Challenge) o;
        if(c.supers.size() != supers.size()) return false;
        for(int i=0; i<supers.size(); ++i) 
            if(!c.supers.get(i).equals(supers.get(i))) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return supers.hashCode();
    }
    public static void main(String[] args) {
        Challenge challenge = new Challenge(
            new String[]{"Liam", "Ezra", "Enzo", "Axel",
                 "Amir", "Jace", "Milo", "Arlo", "Leon", "Ivan", "Finn", "Joel", 
                 "Abel", "Rhys", "Kian", "Seth", "Otis", "Shia", "Nick", "Aman"});
        System.out.println("The challenge is:\n" + challenge + "\n\n");

        File file = new File("Untitled.chall");
        try(PrintStream out = new PrintStream(file)) {
            challenge.save(out);
        } catch(Exception e) {
            System.err.println("Unable to save: " + e);
        }

        Challenge challenger = null;
        try(Scanner in = new Scanner(file)) {
            challenger = new Challenge(in);
        } catch(Exception e) {
            System.err.println("Unable to load: " + e);
        }
        System.out.println("The challenger is:\n" + challenger + "\n\n");

        if(challenge.equals(challenger)) System.out.println("They match!");
        else System.out.println("ERROR: NO MATCH!");
    }
}


