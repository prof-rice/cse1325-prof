import java.io.PrintStream;
import java.io.File;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import menu.Menu;

abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public Animal(Scanner in) { 
        this.name = in.nextLine();
    }
    public void save(PrintStream out) { 
        out.println(name);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Animal a = (Animal) o;
        return a.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // list all relevant fields as parameters
    }

    @Override
    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    private String bark;
    public Dog(String name, String bark) {
        super(name);
        this.bark = bark;
    }
    public Dog(Scanner in) { 
        super(in);
        this.bark = in.nextLine();
    }
    public void save(PrintStream out) { 
        super.save(out);
        out.println(bark);
    }
}

class Cat extends Animal {
    private String meow;
    public Cat(String name, String meow) {
        super(name);
        this.meow = meow;
    }
    public Cat(Scanner in) { 
        super(in);
        this.meow = in.nextLine();
    }
    public void save(PrintStream out) { 
        super.save(out);
        out.println(meow);
    }
}

class Home {
    List<Animal> pets = new ArrayList<>();

    public Home(Animal... animals) {
        for(Animal animal : animals) 
            pets.add(animal);
    }
    public Home(Scanner in) { 
        int size = in.nextInt(); in.nextLine();
        while(size-- > 0) {
            String type = in.nextLine();
            switch(type) {
                case "Dog" -> pets.add(new Dog(in));
                case "Cat" -> pets.add(new Cat(in));
                default -> throw new IllegalStateException("Bad pet type: " + type);
            }
        }
    }
    public void save(PrintStream out) { 
        out.println(pets.size());
        for(Animal pet : pets) {
            out.println(pet.getClass().getName()); 
            pet.save(out);
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Home h = (Home) o;
        return h.pets.equals(pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pets);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Our home has " + pets.size() + " pets!");
        for(Animal pet : pets)
            sb.append("\n  " + pet);
        return sb.toString();
    }
}

public class WithPolymorphism {
    private File file = new File("test.wp");
    
    private void save(Home home) {
        try (PrintStream out = new PrintStream(file)) {
            home.save(out);
            System.out.println("\nWrote home to " + file.getName());
        } catch (Exception e) {
            System.err.println("\nFailed to save: " + file.getName() + "\n"  + e);
        }
    }
    
    private Home open() {
        try (Scanner in = new Scanner(file)) {
            Home homeReconstructed = new Home(in);
            System.out.println("\nOpened homeReconstructed from " + file.getName());
            return homeReconstructed;
        } catch (Exception e) {
            System.err.println("\nFailed to read: " + file.getName() + "\n" + e);
            return null;
        }
    }
    
    public static void main(String[] args) {
        WithPolymorphism wp = new WithPolymorphism();

       // Create and print a Home object
        Home home = new Home(
            new Dog("Spot", "Arf!"),
            new Cat("Snuggles", "Purr!"),
            new Dog("Spike", "GRRRRR!"),
            new Cat("Streak", "Whoosh!")
        );
        System.out.println("\nCreated new home:\n" + home);
        
        // Save the object to a Home file
        wp.save(home);
        
        // Open to a new Home object
        Home homeReconstructed = wp.open();
        System.out.println("\nRecreated the following home:\n" + homeReconstructed);
        
        if(home.equals(homeReconstructed))
            System.out.println("\nSaved and opened Home objects are equal!");
    }
}
