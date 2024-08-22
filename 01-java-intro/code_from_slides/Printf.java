class Printf { 
    public static void main(String args[])  { 
        // Different integer bases
        int i = 1234;
        System.out.printf("Int    as dec %d,        hex %x,           and oct %o\n", i, i, i); 

        // Different double bases
        double d = 1234.56789;

        // show max 2 decimal places 
        System.out.printf("Double as dec %.6f, hex %.6a, and exp %.6e\n", d, d, d); 
  
        // align right and include 20 characters 
        System.out.printf("Right-align with 4 decimal places: | %20.4f|\n", d); 
    } 
} 
