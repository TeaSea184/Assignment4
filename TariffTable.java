//Taylor Claassen
//Question2 
//5 September 2021

public class TariffTable{
   public ParkingTariff[] tickets;
   private int index;
   public ParkingTariff toAdd;
   private String all;
  
  
    public TariffTable(int maxSize){
    tickets = new ParkingTariff[maxSize];
    index = 0;
    all = " ";
    }
    
    // add tariffs to list, throw exception if not preceding or adjacent
    public void addTariff(TimePeriod period, Money tariff){
    toAdd = new ParkingTariff(period,tariff);
    if (index == 0){
    tickets[index] = toAdd;
    index++;
    }
    else if ((tickets[index-1].getTime()).precedes((tickets[index].getTime()))){ 
     tickets[index] = toAdd;
     index ++;
     }
     else{
       throw new IllegalArgumentException("Time periods must be adjacent.");
    }
      }
      
    //Return amount corresponding with length of stay
    public Money getTariff(Duration lengthOfStay){
    int i;
    for (i=0; i < tickets.length; i++){
    if (tickets[i].getTime().includes(lengthOfStay)){
        return tickets[i].getCost();
        }
       } 
       return null;    
    }
    //convert Tariff table to string with certain format
    public String toString(){
    // if there are no tariffs
    if (tickets == null){
    return all;
    }
    else{
    //make first tariff a string
    all = tickets[0].getTime().toString()+" : "+ tickets[0].getCost()+"\n";
    //make rest of tariffs strings
    if (tickets.length > 1){
    int j= 1;
    while (j < tickets.length){
    //if it is the last tariff
      if (j == tickets.length-1){
      all = all +  tickets[j].getTime().toString()+" : "+ tickets[j].getCost();
      }
      //if it is not the last tariff
      else{
      all = all +  tickets[j].getTime().toString()+" : "+ tickets[j].getCost()+"\n";
      }
      j++;
      }
      }
    return all;
      }
      }
  
  }
    
   
    
  