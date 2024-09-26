import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFile {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new FileReader((args[0])));
        String line;
        while((line=br.readLine())!=null) System.out.println(line); 
    }
}
