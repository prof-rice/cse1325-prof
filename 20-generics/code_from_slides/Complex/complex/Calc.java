package complex;

public interface Calc<T> {
    T add(T a, T b);
    T fromDouble(double d);
    double toDouble(T a);
}
