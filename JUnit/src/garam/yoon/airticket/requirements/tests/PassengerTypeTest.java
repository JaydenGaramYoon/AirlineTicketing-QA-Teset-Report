package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cc.airline.passengers.*;
import com.cc.airline.ticketing.Discountable;

/** Business Requirements Covered:
 REQ-BR-04: Passenger types must be mutually exclusive (FF, Employee, Regular) **/
public class PassengerTypeTest {

    @Test
    public void regularType() {
        Passenger p = new Passenger(new PassengerName("A", "B", "C"));
        assertFalse("Regular passenger should not be Discountable", p instanceof Discountable);
    }

    @Test
    public void employeeType() {
        StaffPassenger staff = new StaffPassenger(new PassengerName("A", "B", "C"), "EMP001");
        assertTrue("Employee passenger should be Discountable", staff instanceof Discountable);
    }

    @Test
    public void frequentFlyerType() {
        FrequentFlyer ff = new FrequentFlyer(new PassengerName("A", "B", "C"), "FF001");
        assertFalse("Frequent Flyer should not be Discountable", ff instanceof Discountable);
    }
}
