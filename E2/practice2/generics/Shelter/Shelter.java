import java.util.Objects;
import java.util.ArrayList;
import java.time.LocalDate;

enum Type {DOG, CAT, BIRD, LIZARD}

class Animal { 
    public Animal(String name, Type type) {
        this.name = name;
        this.type = type;
    }
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || !(o instanceof Animal)) return false;
        Animal a = (Animal) o;
        return name.equals(a.name)
            && type == a.type;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
    @Override 
    public String toString() {
        return "" + type + " named " + name;
    }
    private String name;
    private Type type;
}
class Client {
    public Client(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || !(o instanceof Client)) return false;
        Client c = (Client) o;
        return name.equals(c.name)
            && birthday.equals(c.birthday);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
    @Override 
    public String toString() {
        return "Client named " + name + " (born " + birthday + ")";
    }
    private String name;
    private LocalDate birthday;
}

class Pair {
    public Pair(Animal animal, Client client) {
        this.animal = animal;
        this.client = client;
    }
    public Animal getAnimal() {return animal;}
    public Client getClient() {return client;}
    private Animal animal;
    private Client client;
}

public class Shelter {
    private ArrayList<Pair> adoptions = new ArrayList<>();
    public void adopt(Animal animal, Client client) {
        adoptions.add(new Pair(animal, client));
    }
    @Override
    public String toString() {
        String s = "";
        for(Pair p : adoptions) 
            s += p.getClient() + "->" + p.getAnimal();
        return s;
    }
}
