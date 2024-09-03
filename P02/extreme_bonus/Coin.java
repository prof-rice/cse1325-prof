public class Coin {
    public Coin(Denomination denomination, int year) {
        this.denomination = denomination;
        this.year = year;
    }
    public double getValue() {
        return denomination.getValue();
    }
    public int getYear() {
        return year;
    }
    public double getWeight() {
        return switch(denomination) {
            case PENNY -> (year<1983) ? 3.11 : 2.5;
            case NICKEL -> 5;
            case DIME -> (year<1965) ? 2.5 : 2.268;
            case QUARTER -> (year<1965) ? 6.25 : 5.67;
            default -> 0.00;
        };
    }
    @Override
    public String toString() {
        return "" + year + " " + denomination;
    }
    private int year;
    private Denomination denomination;
}
