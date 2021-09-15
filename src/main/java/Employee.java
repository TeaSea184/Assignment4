
//Taylor Claassen
//8 September 2021

import java.util.*;


public class Employee {
    private String name;
    private String uid;
    private CalendarTime startTime;
    private CalendarTime endTime;
    private final List<Shift> shifts;

    public Employee(String name, String uid) {
        this.name = name;
        this.uid = uid;
        shifts = new ArrayList<Shift>();
    }
    //return name
    public String name() {
        return name;
    }
    //return UID
    public String UID() {return uid;}
    //indicate start of shift
    public void signIn(Date d, Time t) {
        startTime = new CalendarTime(d, t);
    }
    //indicate end of shift
    public void signOut(Date d, Time t) {
        endTime = new CalendarTime(d, t);
        Shift newShift = new Shift(startTime, endTime);

        shifts.add(newShift);
    }
    //check if an employee is present
    public boolean present() {
        if ((startTime != null) && (endTime == null)) {
            return true;
        }
        return false;
    }
    //check if employee is present on a date
    public boolean present(Date d){
        return (startTime.equals(d));
    }
    //check if Employee worked on a date
    public boolean worked(Date d) {
        for (int i = 0; i < shifts.size();i++) {
            final Shift currentShift = shifts.get(i);
            if (currentShift.includesDate(d) || (currentShift.includesDate(d))){
                return true;
            }

        }
        return false;
    }
    //check if Employee worked in a week
    public boolean worked(Week w) {
        for (int i = 0; i<shifts.size();i++) {
            final Shift currentShift = shifts.get(i);
            if (w.includes(currentShift.start().date()) || (w.includes(currentShift.finish().date()))){

                return true;
            }
        }
        return false;
    }
    //return a list of shifts worked on a date
    public List<Shift> get(Date d) {
        List<Shift> sameDates = new ArrayList<Shift>();
        for (Shift f : shifts) {
            if (f.includesDate(d)) {
                sameDates.add(f);
            }
        }
        return sameDates;
    }
    //return a list of shifts worked in a week
    public List<Shift> get(Week w) {
        List<Shift> sameWeek = new ArrayList<Shift>();
        for (Shift f : shifts) {
            if (f.inWeek(w)) {
                sameWeek.add(f);
            }
        }
        return sameWeek;
    }
    // return the amount of hours worked in a week
    public Duration hours(Week w) {
        List<Shift> sameWeek = get(w);
        Duration totalHoursWorked = new Duration("hours",0);
        for (Shift f : sameWeek) {
            Duration shiftTime = f.length();
            totalHoursWorked = totalHoursWorked.add(shiftTime);
        }
        return totalHoursWorked;
    }


}