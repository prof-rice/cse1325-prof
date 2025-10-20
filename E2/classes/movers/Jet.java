package movers;

/**
 * Models a Jet.
 *
 * @author   Prof Rice
 * @version  3.7
 * @since    1.0
 */
public class Jet extends Vehicle implements Flyable {
    private int speed;
    public Jet(String model, double fuelLevel) {
        super(model, fuelLevel);
        this.speed = 0;
    }
    @Override
    public void fly(int speed) {
        this.speed = speed;
    }
    @Override
    public void refuel(double fuel) {
        this.fuelLevel += fuel;
    }
    public String toString() {
        return "Jet";
    }
}
