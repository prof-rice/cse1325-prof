public class Fruit implements Comparable<Fruit> {
    public Fruit(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Fruit " + name;
    }
    @Override
    public int compareTo(Fruit f) {
        return name.compareTo(f.name);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Fruit f = (Fruit) o;
        return name.equals(f.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    private String name;
}


