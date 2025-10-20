package movers;

/**
 * Models a Seal.
 *
 * @author   Prof Rice
 * @version  2.3
 * @since    1.0
 */
public class Seal extends Mammal implements Diveable {
    private int depth;
    public Seal(String name, double temperature) {
        super(name, temperature);
        this.depth = 0;
    }
    @Override
    public void dive(int depth) {
        this.depth = depth;
    }
    @Override
    public void eat(String food) {
        System.out.println("Eating " + food);
    }
    public String toString() {
        return "Seal";
    }
}
