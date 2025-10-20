import movers.Diveable;
import movers.Seal;
import movers.Sub;

import movers.Flyable;
import movers.Bat;
import movers.Jet;

import java.util.List;
import java.util.ArrayList;

class Whale implements Diveable {
    @Override
    public void dive(int depth) { }
    @Override
    public String toString() {
        return "Whale";
    }
}
class Dolphin implements Diveable {
    @Override
    public void dive(int depth) { }
    public String toString() {
        return "Dolphin";
    }
}
class Bird implements Flyable {
    @Override
    public void fly(int speed) { }
    public String toString() {
        return "Bird";
    }
}
class Bee implements Flyable {
    @Override
    public void fly(int speed) { }
    public String toString() {
        return "Bee";
    }
}

public class ArrayLists {
    public static void main(String[] args) {
        List<Diveable> divers = new ArrayList<>();
        divers.add(new Seal("Sea Lion", 38));
        divers.add(new Sub("Gato", 116_000));
        divers.add(new Whale());
        divers.add(new Dolphin());
        System.out.println(divers);
        
        List<Flyable> flyers = new ArrayList<>();
        flyers.add(new Bat("MFT", 34));
        flyers.add(new Jet("F-86", 435));
        flyers.add(new Bird());
        flyers.add(new Bee());
        System.out.println(flyers);
    }
}
