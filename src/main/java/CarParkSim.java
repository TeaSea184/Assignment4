

import java.util.Scanner;

/**
 * The .CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and ...
 * @version 14/7/2019
 */
public class CarParkSim {
    public static final Currency currency = new Currency("R", "ZAR", 100);
    public static TariffTable tariffs = new TariffTable(11);
    static {
        //adding tariffs
        tariffs.addTariff(new TimePeriod(new Duration("minute", 0), new Duration("minute", 30)), new Money("R10.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("minute", 30), new Duration("hour", 1)), new Money("R15.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 1), new Duration("hour", 3)), new Money("R20.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 3), new Duration("hour", 4)), new Money("R30.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 4), new Duration("hour", 5)), new Money("R40.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 5), new Duration("hour", 6)), new Money("R50.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 6), new Duration("hour", 8)), new Money("R60.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 8), new Duration("hour", 10)), new Money("R70.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 10), new Duration("hour", 12)), new Money("R90.00", currency));
        tariffs.addTariff(new TimePeriod(new Duration("hour", 12), new Duration("day", 1)), new Money("R100.00", currency));
    }
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        Register r = new Register();
        Clock c = new Clock(new Time("00:00:00"));
        long toAdvance;
        Duration b;
        int index = 0;
        // Declare variables to store a .Clock and a .Register object, create the relevant objects and assign them.

        System.out.println("Car Park Simulator");
        System.out.println("The current time is " + c.examine() + ".");
        // Print current time.
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                toAdvance = keyboard.nextLong();
                b = new Duration("minutes", toAdvance);
                c.advance(b);
                System.out.println("The current time is " + c.examine().toString() + ".");
                // Advance the clock, print the current time.
            } else if (input.equals("arrive")) {
                Ticket t = new Ticket(c.examine());
                r.add(t);
                System.out.println("Ticket issued: " + t.toString() + ".");
            }
                // Create a new ticket, add it to the register, print details of ticket issued.
                else if (input.equals("depart")){
                String userID = keyboard.next();
                if (r.contains(userID)) {
                    Ticket k = r.retrieve(userID);
                    Duration d = k.age(c.examine());
                    System.out.println("Ticket details: " + k.toString() + ".");
                    String currTime = c.examine().toString();
                    System.out.println("Current time: " + currTime + ".");
                    System.out.println("Duration of stay: " + d.format(d, "minute") + ".");
                    System.out.println("Cost of stay: " + tariffs.getTariff(d) + ".");
                } else {
                    System.out.println("Invalid ticket ID.");
                }
            }
            // Determine if ticket is valid, i.e. in the register.
            // If not, print error message.
            // If yes, retreive it, calculate duration of stay and print it.
            else if (input.equals("tariffs")) {
                //display tariff
                System.out.println(tariffs.toString());
            } else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");
            }
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }
        System.out.println("Goodbye.");
    }

}
