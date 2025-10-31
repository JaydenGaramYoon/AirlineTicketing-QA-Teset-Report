package garam.yoon.airticket.requirements.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;

import com.cc.airline.ticketing.*;
import com.cc.airline.utilities.*;

/** Business Requirements Covered:
 REQ-NO-01: Each seat must be assigned only once (no duplicate seat assignments) **/
public class SeatDuplicateAutoTest {

    /** Infinite input stream so UserPrompter never reaches EOF */
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
    public void noDuplicateSeats() {
        // (1) Feed infinite input so UserPrompter never triggers NullPointerException
        System.setIn(new LoopingInputStream(regularBundle()));

        // (2) Capture console output to analyze seat assignments
        PrintStream realOut = System.out;
        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        try {
            SeatingPlan plan = new SeatingPlan();
            SeatReserver reserver = plan.getSeatReserver();

            // (3) Sell all 14 tickets (2 Business + 12 Economy)
            for (int i = 0; i < 14; i++) {
                boolean ok = reserver.sellTicket(i < 2 ? SeatingClass.BUSINESS : SeatingClass.ECONOMY);
                assertTrue("Ticket sale #" + (i + 1) + " should succeed within the seat limit", ok);
            }

            // (4) Extract seat codes (1A–4D) from printed ticket info
            String log = outBuf.toString(StandardCharsets.UTF_8.name());
            Pattern seatCode = Pattern.compile("\\b([1-4][A-D])\\b");
            Matcher m = seatCode.matcher(log);

            List<String> issued = new ArrayList<>();
            while (m.find()) {
                issued.add(m.group(1));
            }

            // Ensure at least 14 seat labels were found (for format consistency)
            assertTrue("Expected at least 14 seat labels, got " + issued.size() +
                       ". Check Ticket/Seat toString() output format.", issued.size() >= 14);

            // (5) Verify that all assigned seats are unique
            Set<String> seen = new HashSet<>();
            List<String> dups = new ArrayList<>();
            for (String s : issued) {
                if (!seen.add(s)) dups.add(s);
            }

            if (!dups.isEmpty()) {
                fail("Duplicate seat assignment detected: " + dups +
                     "- the same seat was issued more than once.");
            }
        } catch (UnsupportedEncodingException e) {
            fail("Output decoding error: " + e.getMessage());
        } finally {
            // Restore stdout after test
            System.setOut(realOut);
        }
    }
}
