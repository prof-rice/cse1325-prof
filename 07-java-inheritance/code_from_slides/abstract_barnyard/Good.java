abstract class AA {
    public abstract void m();
}

class BB extends AA {
    public void x() {System.out.println("x of BB");}
    @Override
    public void m() {System.out.println("m of BB");}
}

public class Good {
    public static void main(String[] args) {
        BB b = new BB();
        b.x();
        b.m();
        
        // But we can do better! Since BB "is a" AA...
        AA a = new BB();
        b.x();
        b.m();
    }
}
