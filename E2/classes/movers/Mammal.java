package movers;

abstract class Mammal {
    public Mammal(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }
    public abstract void eat(String food);

    protected String name;
    protected double temperature;
}
