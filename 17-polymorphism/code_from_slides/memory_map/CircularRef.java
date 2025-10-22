public class CircularRef {
    public static void main(String[] args) {
        RefHolder2 r = new RefHolder2(); // ref counter = 2
            // (because RefHolder2 references itself!)

        // Let's check the hash identities
        System.out.println("Object: " + r);

        // We remove r, leaving no reference accessible to us
        //   to the refHolder object - though it references itself
        r = null;  // Discard RefHolder2 ref - ref counter = 1
        
        // Garbage collector clearly needs a way to handle this!
        //   request (not require) it using...
    }
}

class RefHolder2 {
  public RefHolder2() {
      this.refHolder = this;  // Add reference to ourself
      recursionCounter = 1;
  }
  private RefHolder2 refHolder;
  @Override
  public String toString() {
      if(recursionCounter-- < 0) return super.toString();
      return super.toString() + " with RefHolder2.refHolder = " + refHolder;
  }
  private int recursionCounter;
} 
  

