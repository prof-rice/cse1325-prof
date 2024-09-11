class Test {
  public static void main(String[] args) {
     for(int i=0; i<8; ++i) {
       try {
         //System.out.println(System.in.read()); 
         char c = (char)System.in.read();
         System.out.println(c);
       } catch(Exception e) {
         System.err.println("Exception: " + e.toString());
       }
     }
  }
}
