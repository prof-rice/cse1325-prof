import java.io.IOException;

  
public class TestSpeech { 
  
    public static String execCmdWithResult(String cmd) throws IOException {
        java.util.Scanner s = new java.util.Scanner(
            Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNextLine() ? s.nextLine() : "";
    }
    public static void execCmd(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
    public static void main(String[] args) { 
  
        try { 
            execCmd("espeak Hello");
            execCmd("espeak Goodbye");  
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
