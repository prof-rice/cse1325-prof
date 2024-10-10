import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

public class PlotTemps {
    public PlotTemps(String filename) throws IOException {
        this.filename = filename;
        int lineNumber = 1;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                if(!line.trim().isEmpty()) temps.add(Integer.parseInt(line));
                ++lineNumber;
            }
        } catch(IOException e) {
            throw new IOException("Error loading " + filename + " at line " + lineNumber, e);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Plot of Temperature from " + filename + "\n\n");
        Iterator<Integer> it = temps.iterator();
        while(it.hasNext()) {
            int t = it.next();
            sb.append(String.format("%3d ", t));
            for(int i=1; i<t; ++i) sb.append('=');
            sb.append(">\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String filename = (args.length > 0) ? args[0] : "2023-10-09.txt";
        try {
            PlotTemps pt = new PlotTemps(filename);
            System.out.println(pt);
        } catch(Exception e) {
            System.err.println(e);
            System.exit(-1);
        }
    }
    private ArrayList<Integer> temps = new ArrayList<>();
    private String filename;
}
