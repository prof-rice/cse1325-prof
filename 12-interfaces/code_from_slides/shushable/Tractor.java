import java.io.IOException;

public class Tractor implements Shushable {
    public void operate() {
        say("Brrrrummmm! Clunk! Clunk!");
    }

    // Implement interface Shushable
    @Override
    public void shush() {
        shushed = true;
    }
    @Override
    public void unshush() {
        shushed = false;
    }
    @Override
    public boolean isShushed() {
        return shushed;
    }
    private boolean shushed;
    
    // This is the shell command for audio speech synthesis
    private final String speakCmd = "espeak ";
    private void say(String s) {
        if(!shushed) {
            try {
                System.out.println(s);
                execCmd(speakCmd + s.split(" ")[0]);
            } catch(Exception e) {
            }
        }
    }
    // Runs a command in the shell (returns while it runs)
    // No other class needs access to this method, so it is private
    private static void execCmd(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
}
