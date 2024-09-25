import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

class Nim {
    public Nim(int sticks, int firstPlayer) {
        this.sticks = sticks;
        cPlayer = firstPlayer;
    }
    public Nim() {  // chain (delegate) to first constructor
        this(ThreadLocalRandom.current().nextInt(7, 16), // between 7 and 15, inclusive
             ThreadLocalRandom.current().nextInt(1, 3));
    }
    public Nim(BufferedReader br) throws IOException {
        sticks = Integer.parseInt(br.readLine());
        cPlayer = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + sticks + '\n');        
        bw.write("" + cPlayer + '\n');
    }

    public int currentPlayer() {return cPlayer;}
    public int sticksLeft() {return sticks;}
    public void takeSticks(int sticks) {
       assert(1 <= sticks && sticks <= 3);
       if(this.sticks >= sticks) this.sticks -= sticks;
       else throw new IllegalArgumentException("Out of sticks!");
       cPlayer = 3 - cPlayer;
    }
    public int optimalMove() {
        if(sticks <= 1) return 1;
        switch(sticks%4) {
            case 1: return ThreadLocalRandom.current().nextInt(1, 4);
            case 2: return 1;
            case 3: return 2;
            case 0: return 3;
            default: throw new RuntimeException("Invalid optimal move calculation: " + sticks%4);
        }
    }
    
    private int sticks;
    private int cPlayer;
}
    
