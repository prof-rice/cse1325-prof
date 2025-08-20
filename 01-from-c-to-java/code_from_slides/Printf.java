public class Printf { 
  public static void main(String args[])  { 
    // Different integer bases
    int i = 1234;
    System.out.printf("Int    as dec %d,\n" +        
                      "          hex %x,\n" +
                      "      and oct %o\n",
                       i, i, i); 

    // Different double bases
    double d = 1234.56789;
    System.out.printf("Double as dec %.6f,\n" + 
                      "          hex %.6a,\n" +
                      "      and exp %.6e\n", 
                      d, d, d);
  
    // align right and include 20 characters 
    System.out.printf("Right-align with " +
        "4 decimal places: | %20.4f|\n", d); 
  } 
} 
