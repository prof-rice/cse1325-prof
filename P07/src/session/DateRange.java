package session;

import java.time.ZonedDateTime;
import java.time.Duration;

import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

import java.util.Scanner;

/**
 * Encapsulates a date and a starting and ending time for an event.
 *
 * Dates should follow ISO 8601, which is YYYY-MM-DD (where YYYY is the 
 * 4 (or more)-digit year, MM is the 2-digit month (with a leading 0 
 * if needed), and DD is the 2-digit day (with a leading 0 if needed).
 * <p/>
 * Similarly, time should follow a 24-hour clock in the ISO 8601 format,
 * which is HH:MM (where HH is 00 to 23 hours and MM is 00 to 59 minutes).
 * <p/>
 * The start and end time are on the same date.
 *
 * @author             Prof Rice
 * @version            1.3
 * @since              1.3
 * @license.agreement  Gnu General Public License 3.0
 */
public class DateRange {

//  ====================
//  Using String Methods
//  ====================


    /**
     * Creates a DateRange given the date, start, and ending time.
     *
     * With this constructor, the starting and ending time are explicitly
     * specified and the duration between them is calculated.
     *
     * @param date         the date that includes both starting and ending time
     * @param startTime    the starting time 
     * @param endTime      the ending time
     * @since              1.3
     */
    public DateRange(String date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Creates a DateRange given the date, starting time, and specific duration.
     *
     * With this constructor, the ending time is calculated from the starting
     * time and the duration.
     *
     * @param date         the date that includes both startTime and endTime
     * @param startTime    the starting time 
     * @param duration     the number of minutes between startTime and endTime
     * @since              1.3
     */
    public DateRange(String date, String startTime, long duration) { // in minutes
        this.date = date;
        this.startTime = startTime;
        int hours = getHours(startTime);
        long minutes = getMinutes(startTime) + duration;
        while(minutes > 59) {
            minutes -= 60;
            ++hours;
        }
        this.endTime = String.format("%02d:%02d", hours, minutes);
    }
    private static int getHours(String time) {
       return Integer.parseInt(time.substring(0,2));
    }
    private static int getMinutes(String time) {
       return Integer.parseInt(time.substring(3,5));
    }
    /**
     * Returns the difference between starting and ending time.
     *
     * @return          the difference in starting and ending time in minutes
     * @since           1.3
     */
    public long duration() {
        return (getHours(endTime)   - getHours(startTime)) * 60 + 
               (getMinutes(endTime) - getMinutes(startTime));
    }
    /**
     * Represents the date, starting and ending time, and duration.
     *
     * The format is as follows, where YYYY is the year, MM is the month,
     * DD is the day, HH is the hour, MM is the minutes, and XX is the
     * difference in minutes between starting and ending time..
     *
     * <pre>
     * {@code
     * YYYY-MM-DD HH:MM - HH:MM (XX minutes)
     * }</pre>
     * 
     * @return          the date, times, and duration
     * @since           1.0
     */
    @Override
    public String toString() {
        return date + " " + startTime + " - " + endTime + " (" + duration() + " minutes)";
    }
    private String date;
    private String startTime;
    private String endTime;


//  ===================
//  Using ZonedDateTime
//  ===================

/*
    // For Zone IDs, see https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/ZoneId.html
    public static final String ZONE_ID = " America/Chicago"; // UTA's time zone
    public DateRange(String date, String startTime, String endTime) {
        start = ZonedDateTime.parse(date + "T" + startTime + ZONE_ID, IN_FORMAT);
        end   = ZonedDateTime.parse(date + "T" + endTime   + ZONE_ID, IN_FORMAT);
    }
    public DateRange(String date, String startTime, long duration) { // in minutes
        start = ZonedDateTime.parse(date + "T" + startTime + ZONE_ID, IN_FORMAT);
        end   = start.plusMinutes(duration);
    }
    public long duration() { // in minutes
        return Duration.between(start, end).toMinutes();
    }
    @Override
    public String toString() {
         return start.format(ISO_LOCAL_DATE) + " " + start.format(LOCAL_TIME) +
               " to " + end.format(LOCAL_TIME) + 
               " (" + duration() + " minutes)";
    }
    private static final DateTimeFormatter IN_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm VV");
    private static final DateTimeFormatter LOCAL_TIME = 
        DateTimeFormatter.ofPattern("HH:mm");
    private ZonedDateTime start;
    private ZonedDateTime end;

*/ 
    /**
     * Simple main method to explore the DateRange class.
     *
     * @param           the program arguments, currently ignored
     * @since           1.0
     */
    public static void main(String[] args) {
        System.out.println("Enter date start_time duration (2025-09-26 10:15 30) OR");
        System.out.print(  "      date start_time end_time (2025-09-26 10:15 10:45): ");
        
        Scanner in = new Scanner(System.in);
        String date = in.next();
        String startTime = in.next();
        String endTime = in.next();
        int duration = -1;
        
        try {
            duration = Integer.parseInt(endTime);
        } catch(Exception e) {
        }
        
        DateRange dr;
        if(duration < 0) dr = new DateRange(date, startTime, endTime);
        else dr = new DateRange(date, startTime, duration);
        
        System.out.println(dr);
    }
}

