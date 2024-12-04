// The abstract base class for our states 
//   - derive each state type (class) from this superclass
//   - instance a subclass each time a new state is entered
// (We may well instance all states at startup and reuse them instead)

public abstract class State {
    public State(int seconds) {
        this.seconds = seconds;
    }
    abstract Color color();  // Return the color this state represents
    public State tic() {     // Run timer, if expired possibly change state
        if (seconds > 0) --seconds;
        return handle();
    }
    protected abstract State handle();  // Handle state transitions
    
    int seconds;  // Number of seconds until the next state transition
}

