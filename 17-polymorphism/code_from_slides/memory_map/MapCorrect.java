import java.util.Map;
import java.util.HashMap;

class SSN {
    public SSN(String social) {
        this.social = social;
    }
    @Override
    public String toString() {
        return social;
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null ||
           o.getClass() != getClass()) return false;
        SSN ssn = (SSN) o;
        return social.equals(ssn.social);
    }
    @Override
    public int hashCode() {
        return social.hashCode();
    }
    private String social;
}

public class MapCorrect {
    public static void main(String[] args) {
        HashMap<SSN, String> socials = new HashMap<>();
        for(int i=0; i<500; ++i)
            socials.put(new SSN("431-19-2021"), "Prof Rice");
        System.out.println("Size of map is " + socials.size());
    }
}

