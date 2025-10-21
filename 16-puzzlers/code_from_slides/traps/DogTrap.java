class Dog {
    public static void bark() {
        System.out.print("woof ");
    }
}

class Basenji extends Dog {
    public static void bark() {
        // Basenji dogs can't bark, though they yodel a bit
    }
}

public class DogTrap {
    public static void main(String[] args) {
        Dog woofer = new Dog();
        Dog nipper = new Basenji();
        woofer.bark();
        nipper.bark();
        System.out.println();
    }
}
