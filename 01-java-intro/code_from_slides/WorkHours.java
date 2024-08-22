class WorkHours {
    public float expectedWorkingTime(DayOfWeek dow) { 
        // A WorkHours statement with the new ->
        switch (dow) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> {return 8f;}
            case FRIDAY -> {return 6f;}
            default -> {return 0f;}
        }
    }
    public static void main(String[] args) {
        WorkHours sw = new WorkHours();
        System.out.println(sw.expectedWorkingTime(DayOfWeek.FRIDAY));
    }
}

