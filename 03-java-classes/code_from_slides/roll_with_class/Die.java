public class Die {
    public Die(int faces) { // constructor
      this.faces = faces;
    }

    int getFaces() {        // (getter) returns # faces set by constructor
        return faces;
    }

    int roll() {            // roll the die and return the value
        return (int) (1 + faces * Math.random());
    }
 
    private final int faces;      // number of faces on this die
}

