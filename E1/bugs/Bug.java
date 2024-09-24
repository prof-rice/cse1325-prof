public abstract class Bug {
    public Bug(Stage stage) {
        this.stage = stage;
    }
    public Stage getStage() {
        return this.stage;
    }
    public abstract void nextStage();
    @Override
    public String toString() {
        return this.getClass().getName() + " (" + stage + ")";
    }
    // Bonus 2 - You could more easily define equals in the superclass
    // since it only compares superclass fields!
    public boolean equals(Object o) {
        if(this == o) return true;    // Is it me?
        if(o == null ||               // Is it my type?
           this.getClass() != o.getClass()) return false;
        Bug b = (Bug) o;              // Make it my (superclass) type
        return stage == b.stage;      // Compare the field
    }
    // End Bonus 2
    protected Stage stage;
}
