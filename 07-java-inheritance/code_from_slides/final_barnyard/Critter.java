import java.io.IOException;

public abstract class Critter {
    public Critter(int frequency) {
        this.frequency = frequency; 
        this.timer = 0;
    }
    public final void count() {
        if (++timer > frequency) timer = 0;
    }
    public abstract void speak();
    
    // This is the shell command for audio speech synthesis
    // It is protected so that our subclasses can call it,
    //     but other classes cannot
    protected final String speakCmd = "espeak ";
    protected void say(String s) {
        try {
            System.out.println(s);
            execCmd(speakCmd + s.split(" ")[0]);
        } catch(Exception e) {
        }
    }
    // Our fields are also protected, so our subclasses can use them
    protected int frequency;
    protected int timer;
    
    // Runs a command in the shell (returns while it runs)
    // No other class needs access to this method, so it is private
    private static void execCmd(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
}
