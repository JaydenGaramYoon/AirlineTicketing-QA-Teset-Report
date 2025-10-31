package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cc.airline.ticketing.*;

/** Business Requirements Covered:
 REQ-NO-02: Row 1 must contain Business class seats 1A and 1B **/
public class BusinessRowTest {

    @Test
    public void row1Seats() {
        SeatingPlan plan = new SeatingPlan();
        int first = SeatingClass.BUSINESS.getIndexFirstSeat();
        int count = SeatingClass.BUSINESS.getNumSeats();

        assertEquals(2, count);

        Seat s1 = plan.getSeats().get(first);
        Seat s2 = plan.getSeats().get(first + 1);

        assertEquals(1, s1.getRow());
        assertEquals(1, s2.getRow());
        assertEquals('A', s1.getLetter());
        assertEquals('B', s2.getLetter());
    }
}
