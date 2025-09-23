public class Meal {
    private Food[] foods = new Food[10]; // <== Do this...
    private int nextFood;
    
    public void addFood(Food food) {
        // ... OR this ==> if(foods == null) foods = new Food[10];
        if(nextFood < 10) foods[nextFood++] = food;
    }
    public int totalCalories() {
        int calories = 0;
        for(Food f : foods)
            if(f != null) 
                calories += f.getCalories();
        return calories;
    }
    @Override
    public String toString() {
        String s = "";
        for(Food f : foods)
            if(f != null)
                s += f.toString() + "\n";
        s += "Total calories: " // or "Total energy: "
                + totalCalories(); // or + totalEnergy();
        return s;
    }
}
