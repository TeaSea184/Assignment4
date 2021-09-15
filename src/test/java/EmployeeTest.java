import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    public void testEmployeeWorkShift(){
        Employee e1 = new Employee("Taylor Claassen","641464788");
        e1.signIn(new Date(30,6,2019),new Time(7,10));
        e1.signOut(new Date(30,6,2019),new Time(15,15));

        e1.signIn(new Date(5,7,2019),new Time(7,15));
        e1.signOut(new Date(5,7,2019),new Time(16,00));

        e1.signIn(new Date(6,7,2019),new Time(7,20));
        e1.signOut(new Date(6,7,2019),new Time(16,01));

        e1.signIn(new Date(11,8,2019),new Time(22,00));
        e1.signOut(new Date(12,8,2019),new Time(6,00));

       Assertions.assertFalse(e1.worked(new Week(25,2019)));
        Assertions.assertTrue(e1.worked(new Week(26,2019)));
        Assertions.assertTrue(e1.worked(new Week(27,2019)));
        Assertions.assertFalse(e1.worked(new Week(28,2019)));
        Assertions.assertFalse(e1.worked(new Week(31,2019)));
        Assertions.assertTrue(e1.worked(new Week(32,2019)));
        Assertions.assertTrue(e1.worked(new Week(33,2019)));
        Assertions.assertFalse(e1.worked(new Week(34,2019)));

        Duration expectedWorkMinutes = new Duration("minute",1046);
        Assertions.assertEquals(expectedWorkMinutes.intValue(),e1.hours(new Week(27,2019)).intValue());
    }

}
