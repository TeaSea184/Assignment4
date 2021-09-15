
//Question2 
//5 September 2021

public class TariffTable {
    private ParkingTariff[] tickets;
    private int index;
    private ParkingTariff toAdd;
    private String all;


    public TariffTable(int maxSize) {
        tickets = new ParkingTariff[maxSize];
        index = 0;
        all = " ";
    }

    // add tariffs to list, throw exception if not preceding or adjacent
    public void addTariff(TimePeriod period, Money tariff) {
        toAdd = new ParkingTariff(period, tariff);
        if (index == 0) {
            tickets[index] = toAdd;
            index++;
        } else if ((tickets[index - 1].getTime()).precedes(period) && (period).adjacent(tickets[index-1].getTime())) {
            tickets[index] = toAdd;
            index++;
        } else {
            throw new IllegalArgumentException("Tariff periods must be adjacent.");
        }
    }

    //Return amount corresponding with length of stay
    public Money getTariff(Duration lengthOfStay) {
        int i;
        for (i = 0; i < tickets.length; i++) {
            if (tickets[i].getTime().includes(lengthOfStay)) {
                return tickets[i].getCost();
            }
        }
        return null;
    }

    //convert Tariff table to string with certain format
    public String toString() {
        final StringBuilder output = new StringBuilder(tickets.length);
        for (int tariffCounter = 0; tariffCounter < tickets.length; tariffCounter++) {
            final ParkingTariff currentTariff = tickets[tariffCounter];
            if (currentTariff != null) {
                output.append(currentTariff.getTime())
                        .append(" : ")
                        .append(currentTariff.getCost())
                        .append('\n');
            }

        }
        final String response = output.toString();
        if (response.length() > 0) {
            return response.substring(0, response.length() - 1);
        } else {
            return "";
        }
    }
}
    
   
    
  