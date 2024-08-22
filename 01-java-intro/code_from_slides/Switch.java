enum DayOfTheWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

class Switch {
    public float expectedWorkingTime(DayOfTheWeek dow) { 
    
        // A switch statement with the new ->
        switch (dow) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> {return 8f;}
            case FRIDAY -> {return 6f;}
            default -> {return 0f;}
        }
    }
    
    public float expectedWorkingTimeExp(DayOfTheWeek dow) { 
    
        // A single statement with a switch expression
        return switch(dow) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> 8f;
            case FRIDAY -> 6f;
            default -> 0f;
        };
    }
    public static void main(String[] args) {
        Switch sw = new Switch();
        System.out.println(sw.expectedWorkingTime(DayOfTheWeek.FRIDAY));
        System.out.println(sw.expectedWorkingTimeExp(DayOfTheWeek.FRIDAY));
    }
}
