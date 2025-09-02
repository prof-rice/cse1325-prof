import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = (args.length > 0) ? Integer.parseInt(args[0]) : 5;
        Item[] list = new Item[length];
        for(int i=0; i<length; ++i) {
            System.out.print("Task #" + i + ": ");
            String task = scanner.nextLine();
            System.out.print("Priority from 1 (highest) to 5 (lowest): ");
            int priority = scanner.nextInt(); scanner.nextLine();
            list[i] = new Item(task, priority);
        }
        for(int i=1; i<=5; ++i) 
            for(Item item : list) 
                if(item.isPriority(i))
                    System.out.println(item);
    }
}
