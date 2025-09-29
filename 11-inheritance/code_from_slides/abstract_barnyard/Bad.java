// NOTE: This class will NOT compile
//       The point is for you to understand why!

abstract class A {
    public abstract void m();
}

// Remove abstract to see the error!
abstract class B extends A {
// class B extends A {
    public void x() {System.out.println("x of B");}
    // @Override
    // public void m() {System.out.println("m of B");}
}

public class Bad {
    public static void main(String[] args) {
        // UNCOMMENT these two lines to see the error!
        // B b = new B();
        // b.x();
    }
}
