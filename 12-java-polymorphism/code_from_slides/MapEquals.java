import java.util.Map;
import java.util.HashMap;

class SSN {
    public SSN(String social) {this.social = social;}
    @Override
    public String toString() {return social;}
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        SSN ssn = (SSN) o;
        return social.equals(ssn.social);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31*hash + (social == null ? 0 : social.hashCode());
        return hash;
    }
    private String social;
}

public class MapEquals {
    public static void main(String[] args) {
        HashMap<SSN, String> socials = new HashMap<>();
        for(int i=0; i<500; ++i)
            socials.put(new SSN("431-19-2021"), "Prof Rice");
        System.out.println("Size of map is " + socials.size());
    }
}

