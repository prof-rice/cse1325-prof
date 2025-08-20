package hello;

// The above declares this file to be part of a Java package named hello.

// This program demonstrates how to build and run a Java package.
// This file is part of package hello, and must be in the hello subdirectory.
// It must be compiled and run from the parent directory as
//     javac hello/HelloJava.java
//     java hello.HelloJava
// If ant is run from the parent directory, it will build this package correctly.
// If ant is run from THIS directory, it will produce code that won't run.


// The javax.swing package is the Swing GUI library
import javax.swing.JFrame;   // A window on the desktop
import javax.swing.JButton;  // A button in the window

// Preview of classes AND inheritance! More soon.
public class HelloJava extends JFrame {

    // VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    // Execution begins here as always in Java!

    public static void main(String[] args) {
        new HelloJava();  // This calls HelloJava.HelloJava() - next!
    }

    // This is a special function called a "constructor"
    // It runs when 'new HelloJava()' executes - more next week!

    public HelloJava() {
        System.out.println("Look for the small window on your desktop!");
    
        // Close the window if X is clicked in title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create and size a button
        JButton button = new JButton("Hello, Java!");
        button.setBounds(20,20,120, 30);
        
        // Add the button to the window and print "Ouch!" when it's clicked
        add(button);
        button.addActionListener(event -> System.out.println("Ouch!"));
        
        setSize(160,110); // Set the window size
        setLayout(null);  // Only one widget, so we don't need to manage layout
        setVisible(true); // Make window interactive
    }
}
