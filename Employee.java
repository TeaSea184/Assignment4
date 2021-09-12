//Employee class
//Taylor Claassen
//8 September 2021
import java.util.*;

public class Employee{
   private String name;
   private String uid;
   private CalendarTime startTime;
   private CalendarTime endTime;
   private Shift newShift;
   private List<Shift> shifts;
   
   public Employee(String name, String uid){
   this.name = name;
   this.uid = uid;
   this.shifts = new ArrayList<Shift>();
   ;
   
   }
   public String name(){
   return name;
   }
   public void uid(){
   this.uid = uid;
   }
   public void signIn (Date d,Time t){
   startTime = new CalendarTime(d,t);
   }
   public void signOut(Date d, Time t){
   endTime = new CalendarTime(d,t);
   this.newShift = new Shift(startTime ,endTime);
   shifts.add(newShift);
   }
   public boolean present(){
   if (startTime != null){
   return true;
   }
   return false;
   }
   public boolean worked(Date d){
   if (startTime.date().equals(d)){
    return true;
    }  
    else{
    return false;
      }
    }
        
    public boolean worked(Week w){
    if (w.includes(startTime.date())){
    return true;
      }
    else{
    return false;
      }
    }
    
    public List<Shift> get(Date d){
    for(Shift f:shifts){
    if (worked(d)){
    List<Shift> sameDates = new ArrayList<Shift>();
    sameDates.add(f);
    return sameDates;
    }
         }
    return null ;
    }
    
    public List<Shift> get(Week w){
    for(Shift f: shifts){
    if (worked(w)){
    List<Shift> sameWeek = new ArrayList<Shift>();
    sameWeek.add(f);
    return sameWeek;
    }
      }
    return null;
    }
    
    public Duration hours(Week w){
    List<Shift> sameWeek = new ArrayList<Shift>();
    for(Shift f: shifts){
    if (worked(w)){
    sameWeek.add(f);
    Duration fin; 
    fin = (sameWeek.get(0)).subtract(sameWeek.get(-1));
    return fin;
    }
    }
    }
    
    
    
  
   
}