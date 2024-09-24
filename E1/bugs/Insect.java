public class Insect extends Bug {
    public Insect(Stage stage) {
        super(stage);
        System.out.println("Insect is now " + stage); // NOT on exam
    }
    @Override
    public void nextStage() {
        stage = switch(stage) {
                    case EGG -> Stage.LARVA;
                    case LARVA -> Stage.PUPA;
                    case PUPA -> Stage.ADULT;
                    default -> Stage.ADULT;
        };
        System.out.println("Insect is now " + stage); // NOT on exam
    }
    public void fly(int speed) {
        if(speed > 35) throw new IllegalArgumentException("Too fast!");
        System.out.println("Insect is flying");
    }
    // Bonus 2 - we graded this very generously!
    public boolean equals(Object o) {
        if(this == o) return true;    // Is it me?
        if(o == null ||               // Is it my type?
           this.getClass() != o.getClass()) return false; // or !(o instanceof Insect)
        Bug b = (Bug) o;              // Make it my (superclass) type
        return stage == b.stage;      // Compare the field
    }
    // End Bonus 2

}
