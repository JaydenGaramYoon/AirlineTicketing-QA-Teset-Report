package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import com.cc.airline.ticketing.*;
import com.cc.airline.utilities.*;

/** Business Requirements Covered:
 REQ-NO-03/04/05: Seat allocation limits (Business = 2, Economy = 12, Total = 14)
 Prevents EOF and NPE by using an infinite looping input stream. **/
public class SeatReserverAutoTest {

    /** Infinite looping input stream so UserPrompter never reaches EOF */
    static final class LoopingInputStream extends InputStream {
        private final byte[] data;
        private int i = 0;
        LoopingInputStream(byte[] data) { this.data = data; }
        @Override public int read() { int b = data[i]; i = (i + 1) % data.length; return b & 0xFF; }
    }

    /** Standard passenger input (repeated infinitely) */
    private static byte[] regularBundle() {
        // first name, last name, initial, FF?(Y/N), Employee?(Y/N)
        return "Ga\nYoon\nR\nN\nN\n".getBytes(StandardCharsets.UTF_8);
    }

    @Test
    public void BusinessSeatLimit() {
        // REQ-NO-04: Business seats = 2 only
        System.setIn(new LoopingInputStream(regularBundle()));

        SeatingPlan plan = new SeatingPlan();
        SeatReserver reserver = plan.getSeatReserver();

        boolean b1 = reserver.sellTicket(SeatingClass.BUSINESS);
        boolean b2 = reserver.sellTicket(SeatingClass.BUSINESS);
        boolean b3 = reserver.sellTicket(SeatingClass.BUSINESS); // 3rd should fail

        System.out.println("Business seat sales: " + b1 + ", " + b2 + ", " + b3);

        assertTrue(b1);
        assertTrue(b2);
        assertFalse("Business seat limit exceeded (only 2 should be available)", b3);
    }

    @Test
    public void EconomySeatLimit() {
        // REQ-NO-05: Economy seats = 12 only
        System.setIn(new LoopingInputStream(regularBundle()));

        SeatingPlan plan = new SeatingPlan();
        SeatReserver reserver = plan.getSeatReserver();

        for (int i = 1; i <= 12; i++) {
            boolean ok = reserver.sellTicket(SeatingClass.ECONOMY);
            System.out.println("Economy sale #" + i + ": " + ok);
            assertTrue("Economy seat #" + i + " should be successful", ok);
        }

        boolean fail13th = reserver.sellTicket(SeatingClass.ECONOMY);
        System.out.println("Economy sale #13: " + fail13th);

        assertFalse("Economy seat limit exceeded (only 12 should be available)", fail13th);
    }

    @Test
    public void TotalSeatLimit() {
        // REQ-NO-03: Total seats = 14 (2 business + 12 economy)
        System.setIn(new LoopingInputStream(regularBundle()));

        SeatingPlan plan = new SeatingPlan();
        SeatReserver reserver = plan.getSeatReserver();

        // Sell 2 Business seats
        assertTrue(reserver.sellTicket(SeatingClass.BUSINESS));
        assertTrue(reserver.sellTicket(SeatingClass.BUSINESS));

        // Sell 12 Economy seats
        for (int i = 1; i <= 12; i++) {
            boolean ok = reserver.sellTicket(SeatingClass.ECONOMY);
            System.out.println("Economy sale #" + i + ": " + ok);
            assertTrue(ok);
        }

        // 15th attempt should fail (all seats sold)
        boolean extra = reserver.sellTicket(SeatingClass.ECONOMY) || reserver.sellTicket(SeatingClass.BUSINESS);
        System.out.println("15th sale attempt: " + extra);

        assertFalse("Total seat limit exceeded (14 max allowed)", extra);
    }

    @Test
    public void BusinessSoldOutAllowsEconomySales() {
        // REQ-NO-04/05: Even if Business is sold out, Economy should still be available
        System.setIn(new LoopingInputStream(regularBundle()));

        SeatingPlan plan = new SeatingPlan();
        SeatReserver reserver = plan.getSeatReserver();

        // Business sold out
        assertTrue(reserver.sellTicket(SeatingClass.BUSINESS));
        assertTrue(reserver.sellTicket(SeatingClass.BUSINESS));
        assertFalse("Business overbooked", reserver.sellTicket(SeatingClass.BUSINESS));

        // Economy should still sell successfully
        for (int i = 1; i <= 12; i++) {
            boolean ok = reserver.sellTicket(SeatingClass.ECONOMY);
            System.out.println("Economy sale after business full #" + i + ": " + ok);
            assertTrue(ok);
        }

        // After all 14 seats used, further sales must fail
        assertFalse("Total 14 seat limit reached - further sales should fail",
                reserver.sellTicket(SeatingClass.ECONOMY));
    }
}
