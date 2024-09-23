import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.Security;

import attomenu.Menu;
import attomenu.MenuItem;

public class CheckSumAttoMenu {
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
    private Data data;
    private Menu menu;

    public CheckSumAttoMenu() {
        data = new Data();
        menu = new Menu("\n\n\n\n\n\n\n\nChecksum 4.0", data,
            new MenuItem("Select a file", () -> onAddFileClick()),
            new MenuItem("Select an algorithm", () -> onSelectAlgorithm()),
            new MenuItem("Generate checksum", () -> onGenerateChecksumClick()));
        menu.run();
    }

    // Listeners
    
    protected void onAddFileClick() {
        data.file = Menu.selectFile("Select File",            // set the dialog's title
            (data.file != null) ? data.file.getParentFile() : null, // stay in selected folder
            null);                                           // show all files
        data.checksum = noChecksum;
    }

    protected void onSelectAlgorithm() {
        String[] algorithms = Security.getAlgorithms("MessageDigest").toArray(new String[0]);
        int selection = Menu.select("Select checksum algorithm", algorithms);
        if(selection != -1) {
            data.algorithm = algorithms[selection];
            data.checksum = noChecksum;
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
        new CheckSumAttoMenu();
    }
}
