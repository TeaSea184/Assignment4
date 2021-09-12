import java.util.Scanner;
/**
 * A Shift object records the shift worked by an employee on a given date.
 * 
 * @author Stephan Jamieson 
     * @version 25/11/2011
 */
public class Shift {

    private final CalendarTime start;
    private final CalendarTime finish;
    
    /**
     * Create a Shift object representing a shift worked between the given times on the given dates.
     */
    public Shift(final CalendarTime start, final CalendarTime finish) {
        this.start = start;
        this.finish = finish;
    }
    
    /**
     * Obtain the start time for this shift.
     */
    public CalendarTime start() { return start; }
    
    /**
     * Obtain the finish time for thsi shift.
     */
    public CalendarTime finish() { return finish; }
    
    /**
     * Obtain the length of this shift.
     */
    public Duration length() { return finish.subtract(start); }
    
    /**
     * Determine whether the shift occurred during the given ISO week.
     */
    public boolean inWeek(final Week week) { return week.includes(start.date()) || week.includes(finish.date()); }
    
    /**
     * Determine whether this shift includes the given date.
     */
    public boolean includesDate(final Date date) { 
        return date.compareTo(start.date())>=0 && date.compareTo(finish.date())<=0;
    }
    
    /**
     * Obtain a string representation of this shift of the form "&lt;date&gt;%:&lt;time&gt;-&lt;date&gt;%:&lt;time&gt;".
     */
    public String toString() {
        return start()+" - "+finish();
    }
}
