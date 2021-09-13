
//Taylor Claassen
//8 September 2021

import java.util.*;

public class Employee {
    private String name;
    private String uid;
    private CalendarTime startTime;
    private CalendarTime endTime;
    private Shift newShift;
    private List<Shift> shifts;

    public Employee(String name, String uid) {
        this.name = name;
        this.uid = uid;
        this.shifts = new ArrayList<Shift>();
        ;

    }

    public String name() {
        return name;
    }

    public void uid() {
        this.uid = uid;
    }

    public void signIn(Date d, Time t) {
        startTime = new CalendarTime(d, t);
    }

    public void signOut(Date d, Time t) {
        endTime = new CalendarTime(d, t);
        this.newShift = new Shift(startTime, endTime);
        shifts.add(newShift);
    }

    public boolean present() {
        if (startTime != null) {
            return true;
        }
        return false;
    }

    public boolean worked(Date d) {
        return (startTime.date().equals(d));
    }

    public boolean worked(Week w) {
        return (w.includes(startTime.date()));
    }

    public List<Shift> get(Date d) {
        for (Shift f : shifts) {
            if (worked(d)) {
                List<Shift> sameDates = new ArrayList<Shift>();
                sameDates.add(f);
                return sameDates;
            }
        }
        return null;
    }

    public List<Shift> get(Week w) {
        List<Shift> sameWeek = new ArrayList<Shift>();
        for (Shift f : shifts) {
            if (worked(w)) {
                sameWeek.add(f);
            }
        }
        return sameWeek;
    }

    public Duration hours(Week w) {
        List<Shift> sameWeek = get(w);
        long totalHoursWorked = 0l;
        for (Shift f : sameWeek) {
            Duration shiftTime = f.finish().subtract(f.start());
            totalHoursWorked += shiftTime.intValue("hour");
        }
        return new Duration("hour",totalHoursWorked);
    }


}