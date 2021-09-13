import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TariffTest {
    @Test
    public void testTariffCalc(){
        Duration twoHours = new Duration("hour",2);
        final Money expectedTariff = new Money("R20.00", CarParkSim.currency);
        final Money calcTariff = CarParkSim.tariffs.getTariff(twoHours);

        Assertions.assertEquals(expectedTariff,calcTariff);
    }
    @Test
    public void testTariffToString(){
        final TariffTable testTariff = new TariffTable(1);
        testTariff.addTariff(new TimePeriod(new Duration("day",1),new Duration("day",4)),
                new Money("R150",CarParkSim.currency));
        final String output = testTariff.toString();

        Assertions.assertEquals("[1 day .. 4 days] : R150.00",output);
    }
}