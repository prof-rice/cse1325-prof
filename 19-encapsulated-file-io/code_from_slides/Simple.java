import java.io.PrintStream;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.Objects;

public class Simple {
    public Simple(String aString, int anInt, double aDouble, char aChar, boolean aBoolean) {
        this.aString = aString;
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.aBoolean = aBoolean;
    }
    
    public Simple(Scanner in) {
        this.aString  =                   in.nextLine();
        this.anInt    = in.nextInt();     in.nextLine();
        this.aDouble  = in.nextDouble();  in.nextLine();
        this.aChar    =                   in.nextLine().charAt(0);
        this.aBoolean = in.nextBoolean(); in.nextLine();
    }
    
    public void save(PrintStream out) {
        out.println(aString);
        out.println("" + anInt);
        out.println("" + aDouble);
        out.println("" + aChar);
        out.println("" + aBoolean);
    }
    
    @Override
    public String toString() {
        return aString + " " + anInt + " " + aDouble + " " + aChar + " " + aBoolean;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || 
           o.getClass() != getClass()) return false;
        Simple s = (Simple) o;
        return aString.equals(s.aString)
            && anInt       == s.anInt
            && aDouble     == s.aDouble
            && aChar       == s.aChar
            && aBoolean    == s.aBoolean;
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
