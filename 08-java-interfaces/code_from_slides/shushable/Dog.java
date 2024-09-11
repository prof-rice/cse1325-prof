public class Dog extends Critter {
    public Dog(int frequency) {
        super(frequency);
    }
    @Override
    public void speak() {
        if (timer == 0 && !isShushed()) say("Ruff! Ruff!"); 
    }
}
