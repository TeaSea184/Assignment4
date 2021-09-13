import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TariffTest {
    @Test
    public void testTariffCalc(){
        Duration twoHours = new Duration("hour",2);
        final Money expectedTariff = new Money("R30.00", CarParkSim.currency);
        final Money calcTariff = CarParkSim.tariffs.getTariff(twoHours);

        Assertions.assertEquals(expectedTariff,calcTariff);

    }
}