import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.Security;

public class CheckSumMenu {
    private static String noChecksum = "\n";
    class Data {
        public File file = null;             // The file whose checksum to calculate
        public String algorithm = "SHA-256"; // Checksum algorithm name
        public String checksum = noChecksum; // Calculated checksum
        @Override
        public String toString() {
            return (file == null ? "No file selected" : file.toString())
                  + " for algorithm " + algorithm + checksum;
        }
    }
    private Data data = new Data();

    // Listeners
    
    protected void onAddFileClick() {
        String filename = "";
        try {
            filename = System.console().readLine("Select file: ");
            data.file = new File(filename);
            data.checksum = noChecksum;
        } catch (Exception e) {
            data.checksum = "\nInvalid filename: " + filename + "\n" + e + "\n";
        }
    }

    protected void onSelectAlgorithm() {
        try {
            String[] algorithms = Security.getAlgorithms("MessageDigest").toArray(new String[0]);
            for(int i=0; i<algorithms.length; ++i)
                System.out.println("" + i + ") " + algorithms[i]);
            String s = System.console().readLine("Select checksum algorithm ('x' to cancel): ");
            if(s.charAt(0) == 'x') return;
            data.algorithm = algorithms[Integer.parseInt(s)];
            data.checksum = noChecksum;
        } catch(Exception e) {
            System.err.println("Unable to select an algorithm: " + e);
        }
    }

    protected void onGenerateChecksumClick() {
        try {
            if(data.file != null) {
                byte[] fileContents = Files.readAllBytes(data.file.toPath());
                byte[] digest = MessageDigest.getInstance(data.algorithm).digest(fileContents);
                data.checksum = String.format("\n%0" + (digest.length*2) + "x", 
                    new BigInteger(1, digest));
            } 
        } catch(Exception e) {
            data.checksum = "Failed to generate checksum: " + e;
        }
    }

    public static void main(String... args) {
        CheckSumMenu menu = new CheckSumMenu();
        while(true) {
            try {
                System.out.println("\n\n\n\n\n\n\n\nChecksum Menu 4.0\n");
                System.out.println("0) Select a file");
                System.out.println("1) Select an algorithm");
                System.out.println("2) Generate checksum");
                System.out.println("\n" + menu.data + "\n");
                String s = System.console().readLine("\nSelection ('x' to exit): ");
                if(s.charAt(0) == 'x') break;
                int selection = Integer.parseInt(s);
                if(selection == 0) menu.onAddFileClick();
                else if(selection == 1) menu.onSelectAlgorithm();
                else if(selection == 2) menu.onGenerateChecksumClick();
                else throw new IllegalArgumentException(s + " - select between 0 and 2 or x");
            } catch (Exception e) {
                System.err.println("Invalid selection: " + e);
            } 
        }
    }
}
