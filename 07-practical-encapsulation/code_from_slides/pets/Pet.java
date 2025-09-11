public class Pet {
    public Pet(String name, double age, Type type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
    private static double humanLifespan = 80;
    public double humanAge() {
        return age * humanLifespan / type.lifespan();
    }
    @Override
    public String toString() {
        return name + " is a " + type + " age " + age
             + " or " + humanAge() + " in human years";
    }
    private String name;
    private double age;
    private Type type;
}

