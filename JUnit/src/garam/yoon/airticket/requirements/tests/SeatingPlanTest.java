package garam.yoon.airticket.requirements.tests;

import org.junit.Assert;

import org.junit.Test;
import com.cc.airline.ticketing.*;

/** Business Requirements Covered:
 REQ-NO-03/04/05: Seating plan has 14 seats. **/
public class SeatingPlanTest {
	@Test
	public void testSeatingPlan() {
		SeatingPlan sp = new SeatingPlan();
		Assert.assertNotNull(sp);
		Assert.assertEquals(sp.getSeats().size(), 14);
		Assert.assertNotNull(sp.getSeatReserver());
	}
}
