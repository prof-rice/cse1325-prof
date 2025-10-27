import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

abstract class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public Animal(BufferedReader br) throws IOException {
        this.name = br.readLine();
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Animal that = (Animal) o;
        return this.name.equals(that.name);
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
    public Dog(BufferedReader br) throws IOException {
        super(br);
        this.bark = br.readLine();
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(bark + '\n');
    }
}

class Cat extends Animal {
    private String meow;
    public Cat(String name, String meow) {
        super(name);
        this.meow = meow;
    }
    public Cat(BufferedReader br) throws IOException {
        super(br);
        this.meow = br.readLine();
    }
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(meow + '\n');
    }
}

class Home {
    ArrayList<Animal> pets = new ArrayList<>();

    public Home(Animal... animals) {
        for(Animal animal : animals) 
            pets.add(animal);
    }
    public Home(BufferedReader br) throws IOException {
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) {
            String type = br.readLine();
            if(type.equals("Dog")) pets.add(new Dog(br));
            else if(type.equals("Cat")) pets.add(new Cat(br));
            else throw new IOException("Bad pet type: " + type);
        }
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + pets.size() + '\n');
        for(Animal pet : pets) {
            bw.write(pet.getClass().getName() + '\n'); 
            pet.save(bw);
        }
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Home that = (Home) o;
        if(this.pets.size() != that.pets.size()) return false;
        for(int i=0; i<pets.size(); ++i) 
            if(!pets.get(i).equals(that.pets.get(i))) return false;
        return true;
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

public class WithInheritance {
    
    private String filename = "Untitled.home";
    private Home home = null;
    private Home homeRecreated = null;
    
    private Scanner in = new Scanner(System.in);
    
    private void open() {
        System.out.print("Enter a Home filename to open (Enter for '" 
                       + filename + "'): ");
        String s = in.nextLine();
        if(!s.isEmpty()) filename = s;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            homeRecreated = new Home(br);
            System.out.println("Opened homeRecreated from " + filename);

        } catch (Exception e) {
            System.err.println("Failed to read: " + e);
            homeRecreated = null;
        }
    }
    
    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            home.save(bw);
            System.out.println("Wrote home to " + filename);
        } catch (Exception e) {
            System.err.println("Failed to save: " + e);
        }
    }
    
    private void saveAs() {
        System.out.print("Enter a Home filename to save: ");
        String s = in.nextLine();
        if(s.isEmpty()) return;
        filename = s;
        save();
    }

    public void mdi() {
       // Create and print a Home object
        home = new Home(
            new Dog("Spot", "Arf!"),
            new Cat("Snuggles", "Purr!"),
            new Dog("Spike", "GRRRRR!"),
            new Cat("Streak", "Whoosh!")
        );
        System.out.println(home.toString());
        
        // Save the object to a Home file
        System.out.println("\nWriting Home data to " + filename);
        save();
        
        // Save as a new filename
        System.out.println("\nWriting Home data to a new filename");
        saveAs();
        
        // Open to a new Home object
        System.out.println("\nOpening a Home file");
        open();
        System.out.println(homeRecreated.toString());
        
        if(home.equals(homeRecreated))
            System.out.println("\nSaved and opened Home objects are equal!");
    }
    
    public static void main(String[] args) {
        WithInheritance we = new WithInheritance();
        we.mdi();
    }
}
