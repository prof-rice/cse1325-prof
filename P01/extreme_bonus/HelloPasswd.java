// This approach parses the /etc/passwd password file on Linux / Unix systems,
//   which often contains the user's full name. Unlikely to work on Windows.
// Tested successfully on Ubuntu and Chromebook Linux

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloPasswd {
    public static void main(String[] args) 
            throws IOException {
        String name = "Friend";
        String username = System.getenv("USER");
        BufferedReader in = new BufferedReader(new FileReader("/etc/passwd"));
        while (true) {
            String s = in.readLine();
            if(s.indexOf(username) >= 0) { // Found user's record, looks like
                // ricegf:x:1000:1000:George F. Rice,,,:/home/ricegf:/bin/bash
                // Split the result for the 5th :-separated substrings,
                //   and split that for the 1st ,-separate substring
                name = s.split(":")[4].split(",")[0];
                break;
            }
        }
        System.out.println("Hello, " + name + "!");
    }
}   
