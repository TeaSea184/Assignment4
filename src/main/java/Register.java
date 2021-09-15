
//Taylor Claassen
//23 August 2021

public class Register {
    public Ticket[] tickets;
    public int numTickets;

    //create new register
    public Register() {
        tickets = new Ticket[100];
        numTickets = 0;
    }

    //a ticket to the list
    public void add(Ticket ticket) {
        tickets[numTickets] = ticket;
        numTickets++;
    }

    //check if an ID matches an existing ticket//Claa; bo
    public boolean contains(String ticketID) {
        int i = 0;
        while (i < numTickets) {
            if (tickets[i].ID().equals(ticketID)) {
                return true;
            } else {
                i++;
            }
        }
        return false;

    }

    //retrieve a ticket from a list
    public Ticket retrieve(String ID) {
        int i = 0;
        while (i < numTickets) {
            if (tickets[i].ID().equals(ID)) {
                return tickets[i];
            } else {
                i++;
            }
        }
        return tickets[numTickets];

    }


}