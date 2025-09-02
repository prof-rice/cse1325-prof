import java.util.Scanner;

class Item {
    String task;
    int priority;
}

public class ToDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = (args.length > 0) ? Integer.parseInt(args[0]) : 5;
        Item[] list = new Item[length];
        for(int i=0; i<length; ++i) {
            list[i] = new Item();
            System.out.print("Task #" + i + ": ");
            list[i].task = scanner.nextLine();
            System.out.print("Priority from 1 (highest) to 5 (lowest): ");
            list[i].priority = scanner.nextInt(); scanner.nextLine();
        }
        for(int i=1; i<=5; ++i) 
            for(Item item : list) 
                if(item.priority == i) 
                    System.out.println(item.priority + " " + item.task);
    }
}
