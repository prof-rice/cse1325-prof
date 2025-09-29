final class Dollar {
    public Dollar(int year) {this.year = year;}
    @Override
    public String toString() {return "" + year + " dollar bill";}
    protected int year;
}

class CounterfeitDollar extends Dollar {
    public CounterfeitDollar(int year) {super(year);}
    @Override
    public String toString() {return "" + year + " $100 dollar bill";}
}

public class Counterfeiter {
    public static void main(String[] args) {
        //Dollar dollar = new Dollar(2018);
        Dollar dollar = new CounterfeitDollar(2018);
        System.out.println(dollar);
    }
}
