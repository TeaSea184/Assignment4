
//Question 1
//5 September 2021

public class ParkingTariff {
    private TimePeriod Times;
    private Money Price;

    //create .ParkingTariff object
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
    //check if two tariffs are equal
     public boolean equals(ParkingTariff other){
     if (this.Price.equals(other.Price) && this.getTime().equals(other.getTime())){
     return true;
     }
     return false;
     
     }
     //convert tariff to string
     public String toString(){
     return ("["+this.getTime()+":"+this.getCost()+"]");
     }


}
     