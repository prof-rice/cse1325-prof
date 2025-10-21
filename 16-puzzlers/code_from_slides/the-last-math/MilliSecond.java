public class MilliSecond {
    public static void main(String[] args) {
        final int msPerSecond = 1000;
        final int secPerMinute = 60;
        final int minPerHour = 60;
        final int msPerHour = msPerSecond * secPerMinute * minPerHour;
        System.out.println("ms per hour = " + msPerHour);
        
        int minutes = 0;
        for(int ms = 0; ms < msPerHour; ++ms)
            if(ms % msPerSecond*secPerMinute == 0) ++minutes;
        System.out.println("min per hour = " + minutes);
    }
}
