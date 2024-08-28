class Final {
    public final int constant;
    public Final() {
        constant = 100;  // Yes. Once set it is immutable (cannot change).
    }
    public static void main(String[] args) {
        // constant = 100; // NO - can only be set in a constructor!
        int a = 10;
        final int b;  // Like a constant, but initialized (once) below
        if(a < 100) 
            b = -1;
        else 
            b = 1;
        System.out.println("b = " + b);
        
        Final f = new Final(); // Since constant isn't static, we need an object
        System.out.println("constant = " + f.constant);
    }
}
