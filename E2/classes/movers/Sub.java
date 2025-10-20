package movers;

/**
 * Models a Sub.
 *
 * @author   Prof Rice
 * @version  4.0
 * @since    1.0
 */
public class Sub extends Vehicle implements Diveable {
    private int depth;
    public Sub(String model, double fuelLevel) {
        super(model, fuelLevel);
        this.depth = 0;
    }
    @Override
    public void dive(int depth) {
        this.depth = depth;
    }
    @Override
    public void refuel(double fuel) {
        this.fuelLevel += fuel;
    }
    public String toString() {
        return "Sub";
    }
}
