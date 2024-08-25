// Demonstrate

public class Elevator {
    public Elevator(int startingFloor)  {
        this.currentFloor = startingFloor;
    }
    public Elevator() {
        this(1);
    }
    public void move(int targetFloor) {
        floorsTraversed += Math.abs(targetFloor - currentFloor);
         currentFloor = targetFloor;
    }
    public static int getFloorsTraversed() {
        return floorsTraversed;
    }
    
    private static int floorsTraversed;
    private int currentFloor;
    
    public static void main(String[] args) {
        Elevator e1 = new Elevator();  // An elevator on floor 1
        Elevator e2 = new Elevator();  // A second elevator on floor 1
        e1.move(7);                    // Move each elevator a bit
        e2.move(2);
        e1.move(4);
        e2.move(1);
        // The correct answer is 9 + 2 = 11
        // e1 moved from 1 to 7 to 4 - that's 9 floors
        // e2 moved from 1 to 2 to 1 - that's 2 floors
        System.out.println("Elevators traversed " 
                         + Elevator.getFloorsTraversed() + " total floors.");
    }
}

