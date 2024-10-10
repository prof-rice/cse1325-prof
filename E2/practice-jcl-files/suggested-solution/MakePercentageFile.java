import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MakePercentageFile {
    private static Map<String, Integer> evSales = new HashMap<>(); // Unsorted
    // private static Map<String, Integer> evSales = new TreeMap<>();    // Sorted
    private static final String inFileName = "ev-sales.dat";
    private static final String outFileName = "ev-percentage.dat";
    public static void main(String[] args) {
        String state = "";
        int sales = 0;
        int totalSales = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inFileName))) {
            while((state = br.readLine()) != null) {
                String s = br.readLine(); if(s == null) break;
                sales = Integer.parseInt(s);
                evSales.put(state, sales);
                totalSales += sales;
            }
        } catch(IOException e) {
            System.err.println("Unable to load " + inFileName);
            e.printStackTrace();
            System.exit(-1);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName))) {
            for(String s : evSales.keySet()) {
                double percent = 100.0 * ((double) evSales.get(s)) / totalSales;
                bw.write(s + "\n" +  evSales.get(s) + "\n" + percent + "%\n");
                System.out.printf("%18s bought %6d EVs or %4.1f%%\n", s, evSales.get(s), percent);
            }
        } catch(IOException e) {
            System.err.println("Unable to save " + outFileName);
            e.printStackTrace();
            System.exit(-2);
        }
        System.out.println("Total EVs  bought  were  " + totalSales);
    }
}
