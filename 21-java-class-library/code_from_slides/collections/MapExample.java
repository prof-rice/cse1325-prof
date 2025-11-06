import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Comparator;

class SortByLength implements Comparator<String> {
    public int compare(String lhs, String rhs) {
        int key = lhs.length() - rhs.length();
        if (key == 0) key = lhs.compareTo(rhs);
        return key;
    }
}

public class MapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> cars = new HashMap<>();
        TreeMap<String, Integer> sortedCars = new TreeMap<>();
        TreeMap<String, Integer> lenSortCars = new TreeMap<>(new SortByLength());
        Scanner in = new Scanner(System.in);
        
        while(true) {
            System.out.print("Enter model year (0 to exit) and vehicle: ");
            //System.out.flush(); // text is only output on \n
            int year = in.nextInt(); if(year == 0) break;
            String vehicle = in.nextLine();
            cars.put(vehicle, year);
            sortedCars.put(vehicle, year);
            lenSortCars.put(vehicle, year);
        }
        
        System.out.println("\n\nCars: ");
        for(String key : cars.keySet()) 
            System.out.println("  " + cars.get(key) + " " + key);
        
        System.out.println("\nSorted: ");
        for(String key : sortedCars.keySet()) 
            System.out.println("  " + sortedCars.get(key) + " " + key);
            
        System.out.println("\nSorted by Length: ");
        for(String key : lenSortCars.keySet()) 
            System.out.println("  " + lenSortCars.get(key) + " " + key);
            
    }
}
