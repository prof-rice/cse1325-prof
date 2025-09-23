import java.util.Scanner;

public class Chef {
    private static Meal meal;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        meal = new Meal();
        
        String sep = "";    // START: Not part of the exam
        String groups = "";
        for(Group g : Group.values()) {
            groups += sep + g;
            sep = ", ";
        }                  // END: Not part of the exam
        
        while(true) {
            try {
                System.out.print("\nEnter name: "); // Newline NOT requireed
                String name = in.nextLine(); 
                if(name.isEmpty()) break;
            
                System.out.print("Enter food group (" + groups + "): "); // groups NOT required
                Group group = Group.valueOf(in.nextLine());
            
                System.out.print("Enter calories: ");
                int calories = Integer.parseInt(in.nextLine()); // or in.nextInt(); in.nextLine();
            
                meal.addFood(new Food(name, calories, group));
            } catch(Exception e) {
                System.err.println("Bad food: " + e);
                System.exit(-1);  // Bad form, but checking if student knows how!
            }
        }
        System.out.println("\n" + meal);
    }
}
