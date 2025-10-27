import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Objects;

public class Simple {
    public Simple(String aString, int anInt, double aDouble, char aChar, boolean aBoolean) {
        this.aString = aString;
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.aBoolean = aBoolean;
    }
    
    public Simple(BufferedReader br) throws IOException {
        this.aString  =                      br.readLine();
        this.anInt    = Integer.parseInt    (br.readLine());
        this.aDouble  = Double.parseDouble  (br.readLine());
        this.aChar    =                      br.readLine().charAt(0);
        this.aBoolean = Boolean.parseBoolean(br.readLine());
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(aString       + '\n');
        bw.write("" + anInt    + '\n');
        bw.write("" + aDouble  + '\n');
        bw.write("" + aChar    + '\n');
        bw.write("" + aBoolean + '\n');
    }
    
    @Override
    public String toString() {
        return aString + " " + anInt + " " + aDouble + " " + aChar + " " + aBoolean;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Simple s = (Simple) o;
        return aString.equals(s.aString)
            && anInt    == s.anInt
            && aDouble  == s.aDouble
            && aChar    == s.aChar
            && aBoolean == s.aBoolean;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aString, anInt, aDouble, aChar, aBoolean); 
    }


    private String aString;
    private int anInt;
    private double aDouble;
    private char aChar;
    private boolean aBoolean;
}
