public class NamingConventions {  // NamingConventions is a new type
    public static void main(String[] args) {  // K&R style braces
        boolean isHappy = true;
        final char TEACH_ME = '教';   // final means const
        int ultimateAnswer = 42;
        double earthMass = 5.972e+27; // in grams
        String goodbye = "So long, folks!";
        System.out.println(goodbye + ' ' + isHappy + ' '
            + TEACH_ME + ' ' + ultimateAnswer +  ' ' + earthMass);
    }
}
