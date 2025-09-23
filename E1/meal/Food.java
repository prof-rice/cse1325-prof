import java.util.Objects;

public class Food {
    private String name;
    private Group group;
    private int calories;
    
    public Food(String name, int calories, Group group) {
        if(calories < 0 ) 
            throw new IllegalArgumentException(name + " cannot have negative calories");
        this.name = name;
        this.calories = calories;
        this.group = group;
    }
    public int getCalories() {
        return calories;
    }
    public Group getFoodGroup() {
        return group;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        Food f = (Food) o;
        return f.name == name &&
               f.group == group;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
