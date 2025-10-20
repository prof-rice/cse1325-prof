package movers;

/**
 * Models a Bat.
 *
 * @author   Prof Rice
 * @version  1.1
 * @since    1.0
 */
public class Bat extends Mammal implements Flyable {
    private int speed;
    public Bat(String name, double temperature) {
        super(name, temperature);
        this.speed = 0;
    }
    @Override
    public void fly(int speed) {
        this.speed = speed;
    }
    @Override
    public void eat(String food) {
        System.out.println("Eating " + food);
    }
    public String toString() {
        return "Bat";
    }
}
