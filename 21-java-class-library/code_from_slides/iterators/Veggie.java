public class Veggie  implements Comparable<Veggie> {
    public Veggie(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Veggie " + name;
    }
    @Override
    public int compareTo(Veggie f) {
        return name.compareTo(f.name);
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Veggie that = (Veggie) o;
        return this.name.equals(that.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
     private String name;
}


