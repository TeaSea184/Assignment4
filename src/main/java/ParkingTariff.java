
//Question 1
//5 September 2021

public class ParkingTariff {
    private TimePeriod Times;
    private Money Price;

    //create src.main.java.ParkingTariff object
    public ParkingTariff(TimePeriod duration, Money costs) {
        this.Times = duration;
        this.Price = costs;
    }

    //Set the time period
    public void setTime(TimePeriod duration) {
        this.Times = duration;
    }

    // Set the cost
    public void setCost(Money costs) {
        this.Price = costs;
    }

    //Get the time period
    public TimePeriod getTime() {
        return Times;
    }

    //Get the cost
    public Money getCost() {
        return Price;
    }
     /*public boolean equals(src.main.java.ParkingTariff other){
     if (this.Price.equals(other.Price) && this.src.main.java.Time.equals(other.src.main.java.Time)){
     return true;
     }
     return false;
     
     }
     public String toString(){
     return ("["+this.src.main.java.Time+":"+this.Price+"]");
     }
    */

}
     