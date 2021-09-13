
//Taylor Claassen
//8 September 2021

import java.util.*;


public class Employee {
    private String name;
    private String uid;
    private CalendarTime startTime;
    private CalendarTime endTime;
    private List<Shift> shifts;

    public Employee(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String name() {
        return name;
    }

    public String UID() {return uid;}

    public void signIn(Date d, Time t) {
        startTime = new CalendarTime(d, t);
    }

    public void signOut(Date d, Time t) {
        endTime = new CalendarTime(d, t);
        Shift newShift = new Shift(startTime, endTime);
        shifts = new ArrayList<Shift>();
        shifts.add(newShift);
    }

    public boolean present() {
        if ((startTime != null) && (endTime == null)) {
            return true;
        }
        return false;
    }
    public boolean present(Date d){
        return (startTime.equals(d));
    }

    public boolean worked(Date d) {
        return (startTime.date().equals(d));
    }

    public boolean worked(Week w) {
        return (w.includes(startTime.date()));
    }

    public List<Shift> get(Date d) {
        List<Shift> sameDates = new ArrayList<Shift>();
        for (Shift f : shifts) {
            if (f.includesDate(d)) {
                sameDates.add(f);
            }
        }
        return sameDates;
    }

    public List<Shift> get(Week w) {
        List<Shift> sameWeek = new ArrayList<Shift>();
        for (Shift f : shifts) {
            if (f.inWeek(w)) {
                sameWeek.add(f);
            }
        }
        return sameWeek;
    }

    public Duration hours(Week w) {
        List<Shift> sameWeek = get(w);
        long totalHoursWorked = 0l;
        for (Shift f : sameWeek) {
            Duration shiftTime = f.length();
            totalHoursWorked += shiftTime.intValue("hour");
        }
        return new Duration("hour",totalHoursWorked);
    }


}