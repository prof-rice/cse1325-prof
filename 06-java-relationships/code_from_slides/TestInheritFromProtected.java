public class TestInheritFromProtected {
    // protected and private classes can only be nested within public
    //   or package-private classes, NOT stand-alone
    protected class ProtectedSuperclass { 
        @Override
        public String toString() {
            return "I'm ProtectedSuperclass!";
        }
    }

    public class PublicSubclass {
        @Override
        public String toString() {
            return "I'm PublicSubclass!";
        }
    }

    @Override
    public String toString() {
        return "I'm TestInheritFromProtected!";
    }

    // Instance the nested classes
    public ProtectedSuperclass protectedSuperclass = new ProtectedSuperclass();
    public PublicSubclass publicSubclass = new PublicSubclass();

    // Main instances our outer class and prints the outer object and
    //   the nested protected and public objects
    public static void main(String[] args) {
        TestInheritFromProtected test = new TestInheritFromProtected();
        System.out.println(test);
        System.out.println(test.protectedSuperclass);
        System.out.println(test.publicSubclass);
    }
}
