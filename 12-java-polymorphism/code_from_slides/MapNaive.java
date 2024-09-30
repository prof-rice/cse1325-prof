import java.util.HashMap;

class SSNNaive {
    public SSNNaive(String social) {this.social = social;}
    @Override
    public String toString() {return social;}
    private String social;
}

public class MapNaive {
    public static void main(String[] args) {
        HashMap<SSNNaive, String> socials = new HashMap<>();
        for(int i=0; i<500; ++i)
            socials.put(new SSNNaive("431-19-2021"), "Prof Rice");
        System.out.println("Size of map is " + socials.size());
    }
}

