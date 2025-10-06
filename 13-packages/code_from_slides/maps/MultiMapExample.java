import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import java.util.Set;
import java.util.TreeSet;

import java.util.Scanner;

public class MultiMapExample {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, Set<Integer>> cars = new HashMap<>();
        
        while(true) {
            System.out.print("Enter model year (0 to exit) and vehicle: ");
            if(!scanner.hasNextInt()) break;
            int year = scanner.nextInt(); 
            if(year == 0) break;
            String vehicle = scanner.nextLine();
            if(cars.get(vehicle) == null) 
                cars.put(vehicle, new TreeSet<Integer>());
            cars.get(vehicle).add(year);
        }
        
        System.out.println("\n\nCars: ");
        for(String key : cars.keySet()) 
            for(Integer year : cars.get(key)) 
            System.out.println("  " + year + " " + key);
    }
}
