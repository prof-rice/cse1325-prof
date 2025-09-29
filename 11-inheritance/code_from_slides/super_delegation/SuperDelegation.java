class Grandfather {
    public Grandfather(int age) {
        this.age = age;
    }
    public Grandfather() {
        this(100);
    }
    @Override
    public String toString() {
        return "Grandfather is " + age + " years old";
    }
    private int age;
}

class Father extends Grandfather {
    // public Father(int grandfatherAge) {
    //     super(grandfatherAge);
    // }
}

// Question: Can super refer to a grandparent superclass?
// Answer: Compile to find out!
class Son extends Father {
    public Son(int grandfatherAge) {
        super(grandfatherAge);
    }
}

public class SuperDelegation {
    public static void main(String[] args) {
        Son son = new Son(80);
        System.out.println(son.toString());
    }
}
