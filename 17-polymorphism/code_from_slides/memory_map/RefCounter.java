public class RefCounter {
    public static void main(String[] args) {
        AClass a = new AClass();  // ref count = 1
        RefHolder r = new RefHolder(a); // ref counter = 2

        // Let's check the hash identities
        System.out.println("Objects: " + a + " and " + r);

        // Now we remove our reference, and check r's hash identity        
        a = null; // discard ref to AClass - but ref counter = 1
                  //   because RefHolder still has a reference!
        System.out.println("Object: " + r);
        
        // Finally, we remove r, leaving no referenct to AClass object
        r = null;  // Discard RefHolder - ref counter = 0
        
        // Garbage collector MAY run at any time after this
        //   and delete AClass (and RefHolder) - or we can
        //   request (not require) it using...
        System.gc();  // Request that the garbage collector run
    }
}

class RefHolder {
  public RefHolder(AClass aClass) {
      this.aClass = aClass;  // Add reference
  }
  private AClass aClass;
  @Override
  public String toString() {
      return super.toString() + " with RefHolder.aClass = " + aClass;
  }
} 
  
class AClass {
  public AClass() {
    int anInt = 42;
  }
  private int anInt;
}
