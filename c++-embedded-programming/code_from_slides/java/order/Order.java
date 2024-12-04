enum State {
  PENDING, 
  FILLED, 
  PAID, 
  COMPLETE, 
  DISCARDED
}

enum Event {
  FILL,
  PAY,
  CANCEL
}

public class Order {
    public Order() {
        state = State.PENDING;
        id = nextID++;
    }
    public void handle(Event event) {
        switch(event) {
            case FILL: fill(); break;
            case PAY:  pay(); break;
            case CANCEL: cancel(); break;
            default: throw new IllegalStateException("Unknown event: " + event);
        }
    }
    
    // Event handlers
    
    protected void fill() {
        switch(state) {
             case FILLED:
             case COMPLETE:
             case DISCARDED: 
               throw new IllegalStateException("Attempt to fill " + state + " order " + id);
             case PENDING: state = State.FILLED; break;
             case PAID: state = State.COMPLETE; break;
             default: throw new IllegalStateException("Unknown state: " + state);
       }
   }
    protected void pay() {
        switch(state) {
             case PAID:
             case COMPLETE:
             case DISCARDED: 
               throw new IllegalStateException("Attempt to pay " + state + " order " + id);
             case PENDING: state = State.PAID; break;
             case FILLED: state = State.COMPLETE; break;
             default: throw new IllegalStateException("Unknown state: " + state);
       }
   }
    protected void cancel() {
        switch(state) {
             case COMPLETE:
             case DISCARDED: 
               throw new IllegalStateException("Attempt to cancel " + state + " order " + id);
             case FILLED:
             case PENDING:
             case PAID: state = State.DISCARDED; break;
             default: throw new IllegalStateException("Unknown state: " + state);
       }
   }
   
   @Override
   public String toString() {
       return "Order " + id + " is " + state;
   }
   private static int nextID = 0;
   private final int id;
   private State state;
}
