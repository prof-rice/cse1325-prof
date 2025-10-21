package edu.uta;

public class WhatsMyClass {
    public static void main(String[] args) {
        String myFullClassName = WhatsMyClass.class.getCanonicalName();
        System.out.println("My full class name is " + myFullClassName);
        String myClassFilename = myFullClassName.replaceAll(".", "/") + ".class";
        System.out.println("The class filename is " + myClassFilename);
    }
}
