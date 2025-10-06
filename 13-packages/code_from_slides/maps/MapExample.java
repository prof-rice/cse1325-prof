import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;

public class MapExample {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();
        Map<String, Integer> sortedCars = new TreeMap<>();
        
        while(true) {
            System.out.print("Enter model year (0 to exit) and vehicle: ");
            if(!scanner.hasNextInt()) break;
            int year = scanner.nextInt(); 
            if(year == 0) break;
            String vehicle = scanner.nextLine();
            cars.put(vehicle, year);
            sortedCars.put(vehicle, year);
        }
        
        System.out.println("\n\nCars: ");
        for(String key : cars.keySet()) 
            System.out.println("  " + cars.get(key) + " " + key);
        
        System.out.println("\nSorted: ");
        for(var entry : sortedCars.entrySet()) 
            System.out.println("  " + entry.getValue() + " " + entry.getKey());
    }
}
