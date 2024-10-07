public class BadIO implements Runnable {
    private static boolean go = false;
    public void run() {
        String s = "Welcome, warm and friendly Java!\n";
        go = true;
        for(char c : s.toCharArray()) {System.out.print(c); System.out.flush();}
    }
    public static void main(String[] args) {
        (new Thread(new BadIO())).start();
        String s = "Goodbye, cold cruel world!\n";
        while(!go) ;
        for(char c : s.toCharArray()) {System.out.print(c); System.out.flush();}
    }
}
