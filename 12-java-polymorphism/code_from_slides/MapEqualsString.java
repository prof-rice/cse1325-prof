// An Experiment - do NOT NOT NOT do this!
// It breaks symmetry: if ssn.equals(string) is true,
//     string.equals(ssn) is NOT true
// This can lead to really bizarre bugs!

class SSN3 {
    public SSN3(String social) {this.social = social;}
    @Override
    public String toString() {return social;}
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(o.getClass() == "".getClass()) // Also support String compares
            return ((String) o).equals(social);
        if(this.getClass() != o.getClass()) return false;
        SSN3 ssn = (SSN3) o;
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

public class MapEqualsString {
    public static void main(String[] args) {
        SSN3 ssn1 = new SSN3("431-19-2021");
        SSN3 ssn2 = new SSN3("431-19-2021");
        
        String equals = "==";
        if(!ssn1.equals(ssn2)) equals = "!=";
        System.out.println("ssn1 " + equals + " ssn2");
        
        equals = "==";
        if(!ssn1.equals("431-19-2021")) equals = "!=";
        System.out.println("ssn1 " + equals + " 431-19-2021");
        
        equals = "==";
        if(!ssn1.equals("432-42-1945")) equals = "!=";
        System.out.println("ssn1 " + equals + " 432-42-1945");
    }
}

