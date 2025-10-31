package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cc.airline.ticketing.*;

/** Business Requirements Covered:
 REQ-BR-01: Two seating classes must exist (Business, Economy)
 REQ-NO-03/04/05: Total 14 seats (2 Business and 12 Economy) **/
public class SeatingClassTest {

    @Test
    public void testSeatClassesExist() {
        SeatingClass[] values = SeatingClass.values();
        assertEquals("There should be exactly two seating classes", 2, values.length);
        assertTrue(values[0] == SeatingClass.BUSINESS || values[1] == SeatingClass.BUSINESS);
        assertTrue(values[0] == SeatingClass.ECONOMY  || values[1] == SeatingClass.ECONOMY);
    }

    @Test
    public void testSeatCountsByClassAndTotal() {
        // Verifies getNumSeats() values used internally by SeatingClass#setIndexSeats
        assertEquals("Business class should have 2 seats", 2, SeatingClass.BUSINESS.getNumSeats());
        assertEquals("Economy class should have 12 seats", 12, SeatingClass.ECONOMY.getNumSeats());
        assertEquals("Total number of seats should be 14", 14, SeatingClass.getTotalSeats());
    }
}
