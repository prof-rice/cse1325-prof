import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.Security;

class CheckSum {
    private String version = "4.0";
    private File file = null;
    private String algorithm = "SHA-256";
    
    private void usage() {
        System.err.println("Usage: checksum [-lhV] [-a=<algorithm>] <file>\n"
                         + "Prints the checksum (SHA-256 by default) of a file to STDOUT.\n"
                         + "      <file>      The file whose checksum to calculate.\n"
                         + "  -a, --algorithm=<algorithm>\n"
                         + "                  MD5, SHA-1, SHA-256, ...\n"
                         + "  -l, --list      Show all supported algorithms.\n"
                         + "  -h, --help      Show this help message and exit.\n"
                         + "  -V, --version   Print version information and exit.\n");
    }
    
    private void badArgument(int index, String argument) {
        if(argument.charAt(0) == '-') 
            System.err.println("Unknown option: '" + argument + "'");
        else
            System.err.println("Unmatched argument at index " + index + ": '" + argument + "'");
        usage();
        System.exit(-1);
    }

    public CheckSum(String[] args) {
        int i=0;
        while(i < args.length) {
            if(args[i].equals("-a") || args[i].equals("--algorithm")) {
                algorithm = args[++i];
                ++i;
            } else if(args[i].equals("-l") || args[i].equals("--list")) {
                listAlgorithms();
                System.exit(0);
            } else if(args[i].equals("-h") || args[i].equals("--help")) {
                usage();
                System.exit(0);
            } else if(args[i].equals("-V") || args[i].equals("--version")) {
                System.out.println(version);
                System.exit(0);
            } else if(file == null) {
                if(args[i].charAt(0) == '-') badArgument(i, args[i]);
                else file = new File(args[i++]);
            } else {
                badArgument(i, args[i]);
           }
        }
        
        if(file == null) {
            System.err.println("Missing required parameter: '<file>'");
            usage();
            System.exit(-2);
        }
    }

    public void listAlgorithms() {
        for(String s : Security.getAlgorithms("MessageDigest").toArray(new String[0]))
            System.out.println(s);
    }
    
    public void printCheckSum() throws Exception {   
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        System.exit(0);
    }
    
    public static void main(String[] args) throws Exception {
        (new CheckSum(args)).printCheckSum();
    }
}
