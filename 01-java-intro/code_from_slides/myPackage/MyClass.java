// This is a program MyClass inside myPackage
// It MUST be in ./myPackage/MyClass.java
// It MUST be compiled using javac ./myPackage/MyClass.java
// It MUST be run      using java  myPackage.MyClass

// Declare that MyClass is part of myPackage
package myPackage;

// Declare the class (for now, think of this as the filename)
public class MyClass {

    // Create a simple main
    public static void main(String[] args) {
        System.out.println("Running myPackage.MyClass.main()");
    }
}
