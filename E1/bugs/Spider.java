public class Spider extends Bug {
    public Spider(Stage stage) {
        super(stage);
        System.out.println("Spider is now " + stage); // NOT on exam
    }
    @Override
    public void nextStage() {
        stage = switch(stage) {
                    case EGG -> Stage.SPIDERLING;
                    case SPIDERLING -> Stage.ADULT;
                    default -> Stage.ADULT;
        };
        System.out.println("Spider is now " + stage); // NOT on exam
    }
    public void spin(double length) {
        if(length < 0) throw new IllegalArgumentException("Negative length!");
        System.out.println("Spinning web");
    }
    // Bonus 2 - we graded this very generously!
    public boolean equals(Object o) {
        if(this == o) return true;    // Is it me?
        if(o == null ||               // Is it my type?
           this.getClass() != o.getClass()) return false; // or !(o instanceof Spider)
        Bug b = (Bug) o;              // Make it my (superclass) type
        return stage == b.stage;      // Compare the field
    }
    // End Bonus 2

}
