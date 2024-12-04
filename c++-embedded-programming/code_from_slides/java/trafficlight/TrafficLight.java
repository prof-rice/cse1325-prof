public class TrafficLight {
    public TrafficLight(State state) {
        this.state = state;        
    }
    public Color color() {
        return state.color(); // polymorphic
    }
    public void tic() {       // called each second
        state = state.tic();
    }
    State state;
    static Event e_enable_green_1 = new Event();
    static Event e_enable_green_2 = new Event();

    // The State subclasses are defined as static inner nested classes
    // of TrafficLight, but it's just as valid to define them separately

    static class Green_1 extends State {
        Green_1() {
            super(27);  // We remain in this state for 27 seconds
        }
        @Override
        Color color() {
          return Color.GREEN;  // The light is green
        }
        @Override
        protected State handle() {
            if (seconds <= 0) {  // The state transition depends
                return new Yellow_1();  // only on the timer
           } else {
                return this;
           }
        }
    }
      
    static class Yellow_1 extends State {
        Yellow_1() {
            super(3);
        }
        @Override
        Color color() {
          return Color.YELLOW;
        }
        @Override
        protected State handle() {
            if (seconds <= 0) {
                e_enable_green_2.generate();
                return new Red_1();
            } else {
              return this;
            }
        }
    }
    
    static class Red_1 extends State {
        Red_1() {
            super(0);
        }
        @Override
        Color color() {
            return Color.RED;
        }
        @Override
        protected State handle() {
            if (e_enable_green_1.consume()) {
                return new Green_1();
            } else {
                return this;
            }
        }
    }
    
    static class Green_2 extends State {
        Green_2() {
            super(27);
        }
        @Override
        Color color() {
          return Color.GREEN;
        }
        @Override
        protected State handle() {
            if (seconds <= 0) {
                return new Yellow_2();
            } else {
                return this;
            }
        }
    }
      
    static class Yellow_2 extends State {
        Yellow_2() {
            super(3);
        }
        @Override
        Color color() {
            return Color.YELLOW;
        }
        @Override
        protected State handle() {
            if (seconds <= 0) {
                e_enable_green_1.generate();
                return new Red_2();
            } else {
                return this;
            }
        }
    }
    
    static class Red_2 extends State {
        Red_2() {
            super(0);
        }
        @Override
        Color color() {
            return Color.RED;
        }
        @Override
        protected State handle() {
            if (e_enable_green_2.consume()) {
                return new Green_2();
            } else {
                return this;
            }
        }
    }
    
}
    
