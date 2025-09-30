public class Person {
    public Person(String name, String email) {
        if(name  == null || name.isEmpty() ||
           email == null || email.isEmpty())
           throw new IllegalArgumentException("Undefined name or email");
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() { 
        return name + " (" + email + ")";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() == getClass()) return false;
        Person p = (Person) o;
        return p.name.equals(name) &&
               p.email.equals(email);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, email);
    }
    private String name;
    private String email;
}
