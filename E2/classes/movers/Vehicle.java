package movers;

abstract class Vehicle {
    public Vehicle(String model, double fuelLevel) {
        this.model = model;
        this.fuelLevel = fuelLevel;
    }
    public abstract void refuel(double fuel);

    protected String model;
    protected double fuelLevel;
}
