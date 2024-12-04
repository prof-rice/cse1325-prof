import java.util.Scanner;

public class TestOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Order[] orders = new Order[5];
        for(int i=0; i<orders.length; ++i) orders[i] = new Order();
        
        Event[] events = new Event[3];
        events[0] = Event.CANCEL;
        events[1] = Event.PAY;
        events[2] = Event.FILL;
        
        while(true) {
            for(int i=0; i<orders.length; ++i)
                System.out.println("  " + i + ") " + orders[i]);

            System.out.print("\nWhich order (-1 to exit)? ");
            int orderNum = in.nextInt();
            if(orderNum < 0) break;
            
            System.out.print("Which event (0-Cancel  1-Pay  2-Fill)? ");
            int eventNum = in.nextInt();
            try {
                orders[orderNum].handle(events[eventNum]);
            } catch(IllegalStateException e) {
                System.err.println("#### " + e);
            }
        }
    }
}
