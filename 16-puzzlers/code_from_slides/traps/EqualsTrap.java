public class EqualsTrap {
    public static void main(String[] args) {
        Integer foo = 1000; 
        Integer bar = 1000;
        System.out.println("foo and bar = 1000");
        System.out.println("foo <= bar: " + (foo <= bar));
        System.out.println("foo >= bar: " + (foo >= bar));
        System.out.println("foo == bar: " + (foo == bar));

        Integer spam = 42; 
        Integer eggs = 42; 
        System.out.println("\nspam and eggs = 42");
        System.out.println("spam <= eggs: " + (spam <= eggs));
        System.out.println("spam >= eggs: " + (spam >= eggs));
        System.out.println("spam == eggs: " + (spam == eggs));
    }
}
