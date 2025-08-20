enum DayOfWeek {M, T, W, R, F, A, U};
public class Switch {
    public static void main(String[] args) {
        classicSwitch();
        ifElse();
        javaSwitch();
        javaSwitchExpression();
    }
    public static void classicSwitch() {
        int hours = 0;
        for(var day : DayOfWeek.values()) {
            switch(day) {
                case M:
                case T:
                case W:
                case R: hours += 8; break;
                case F: hours += 6; break;
                default: hours += 1; break;
            }
        }
        System.out.println("Hours per week is " + hours);
    }
    public static void ifElse() {
        int hours = 0;
        for(var day : DayOfWeek.values()) {
            if(day == DayOfWeek.M || day == DayOfWeek.T ||
               day == DayOfWeek.W || day == DayOfWeek.R)
               hours += 8;
            else if (day == DayOfWeek.F) hours += 6;
            else hours += 1;
        }
        System.out.println("Hours per week is " + hours);
    }
    public static void javaSwitch() {
        int hours = 0;
        for(var day : DayOfWeek.values()) {
            switch(day) {
                case M, T, W, R -> hours += 8;
                case F  -> hours += 6; 
                default -> hours += 1;
            }
        }
        System.out.println("Hours per week is " + hours);
    }
    public static void javaSwitchExpression() {
        int hours = 0;
        for(var day : DayOfWeek.values()) {
            hours += switch(day) {
                         case M, T, W, R -> 8;
                         case F  -> 6; 
                         default -> 1;
                     };
        }
        System.out.println("Hours per week is " + hours);
    }
}
