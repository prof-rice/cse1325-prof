class Final {
    public final int c; 
    public int d;
    public Final(int c) {
        this.c = c; // OK
        this.d = c;
    }
    public static void main(String[] args) {
        int a = 10;
        final int b; // OK – construct below
        if(a < 100) 
            b = -1;
        else 
            b = 1;

        System.out.println("b = " + b);

        // b = 100; // NO – b is final
        // ++b;     // NO – b is final
        
        final Final f = new Final(100);

        // f.c = 42;          // NO – c is final
        f.d = 42;         // OK – d is NOT final!
        // f = new Final(17); // NO – f is final

        System.out.println("c = " + f.c
                       + ", d = " + f.d);
    }
}
