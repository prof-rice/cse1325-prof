import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.Security;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
         description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
class CheckSum implements Callable<Integer> {

    @Parameters(index = "0..1", description = "The file whose checksum to calculate.")
    private File[] files;

    @Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "SHA-256";

    @Option(names = {"-l", "--list"}, description = "List supported algorithms")
    private boolean listAlgorithms;

    @Override
    public Integer call() throws Exception {
        if(listAlgorithms) {
            for(String s : Security.getAlgorithms("MessageDigest").toArray(new String[0]))
                System.out.println(s);
            System.exit(0);
        }
        if(files != null && files.length != 0) {
            byte[] fileContents = Files.readAllBytes(files[0].toPath());
            byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
            System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
            return 0;
        }
        return -1;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new CheckSum()).execute(args);
        System.exit(exitCode);
    }
}
