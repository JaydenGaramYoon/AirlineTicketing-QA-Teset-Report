package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.cc.airline.passengers.*;

/** Business Requirements Covered:
 REQ-BR-04/07: Frequent Flyer should not receive any discount **/
public class FrequentFlyerTest {

    @Test
    public void testFrequentFlyerIsNotDiscountable() {
        FrequentFlyer ff = new FrequentFlyer(new PassengerName("A", "B", "C"), "FF-001");
        assertFalse("FrequentFlyer should not be Discountable (no price discount)", 
            ff instanceof com.cc.airline.ticketing.Discountable);
    }
}