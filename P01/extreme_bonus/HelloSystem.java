// This approach runs bash commands that report information about the user.
// We use Scanner to parse a stream of text from Runtime.exec.

import java.io.IOException;

public class HelloSystem {
    public static String execCmd(String cmd) throws IOException {
        java.util.Scanner s = new java.util.Scanner(
            Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNextLine() ? s.nextLine() : "";
    }
    public static void main(String[] args) throws IOException {
    
        // The 'whoami' command returns the user's name, identical to 'echo $USER'
        //   (Note that execCmd does NOT resolve environment variables, though)
        System.out.println("Hello, " + execCmd("whoami").trim());
        
        // The 'getent' returns the user's line from /etc/passwd (see also HelloPasswd.java)
        String cmd = "getent passwd " + System.getenv("USER");
        System.out.println("Hello, " + execCmd(cmd).split(":")[4].split(",")[0]);
        
        // The 'git config' command returns the user's name (see also HelloGit.java)
        System.out.println("Hello, " + execCmd("git config user.name").trim());
    }
}
