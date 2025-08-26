// This approach searches the ~/.gitconfig file to find the user's name
// (assuming the user has provided it) - may not work on Windows
//     name = Professor Rice

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class HelloGit {
    public static void main(String[] args) {
        String gitConfigPath = System.getProperty("user.home") + "/.gitconfig";
        String name = "Unknown";
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new FileReader(gitConfigPath)));

            while(in.hasNext()) {
                name = in.next();
                if(name.equals("name")) break;
            }
            if(name.equals("name")) {
                name = in.next();
                if(name.equals("=")) {
                    name = in.nextLine().trim();
                } else {
                    name = "NoEquals";
                }
            } else {
                name = "NoName";
            }

        } catch(Exception e) {
            name = "Exception: " + e;
        }
        
        System.out.println("Hello, " + name);
    }
}
