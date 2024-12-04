public class Event {
    public Event() {
        pending = 0;
    }
    public void generate() {   // Add another event to the "queue"
        ++pending;
    }
    public boolean consume() { // Remove an event from the "queue" if present
      if (pending > 0) {
          --pending; 
          return true;
      }
      return false;
    }
    private int pending;  // Event "queue" (really just a counter)
}

