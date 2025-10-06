import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;

public class MapCustomSortExample {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, Integer> cars = new HashMap<>();
        TreeMap<String, Integer> sortedCars = new TreeMap<>();
        TreeMap<String, Integer> lenSortedCars = new TreeMap<>(new SortByLength());

        while(true) {
            System.out.print("Enter model year (0 to exit) and vehicle: ");
            if(!scanner.hasNextInt()) break;
            int year = scanner.nextInt(); 
            if(year == 0) break;
            String vehicle = scanner.nextLine();
            cars.put(vehicle, year);
            sortedCars.put(vehicle, year);
            lenSortedCars.put(vehicle, year);
        }
        
        System.out.println("\n\nCars: ");
        for(String key : cars.keySet()) 
            System.out.println("  " + cars.get(key) + " " + key);
        
        System.out.println("\nSorted: ");
        for(String key : sortedCars.keySet()) 
            System.out.println("  " + sortedCars.get(key) + " " + key);

        System.out.println("\nSorted by Length: ");
        for(String key : lenSortedCars.keySet()) 
            System.out.println("  " + lenSortedCars.get(key) + " " + key);
    }
}

