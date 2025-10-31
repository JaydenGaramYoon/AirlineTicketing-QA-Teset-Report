package garam.yoon.airticket.requirements.tests;

import org.junit.Test;

import org.junit.Assert;
import com.cc.airline.passengers.Passenger;
import com.cc.airline.passengers.PassengerName;
import com.cc.airline.passengers.StaffPassenger;
import com.cc.airline.passengers.FrequentFlyer;
import com.cc.airline.ticketing.*;

/** Business Requirements Covered:
 REQ-BR-02: Business = $750
 REQ-BR-03: Economy = $500
 REQ-BR-05: Employee 50% off Economy = $250
 REQ-BR-06: Employee Business = $750 (no discount)
 REQ-BR-07: Frequent Flyer no discount **/
public class SellTicketTest {

    @Test
    public void sellTicket1() {
        // REQ-BR-03: Regular passenger, Economy class = $500
        SeatingClass sClass = SeatingClass.ECONOMY;
        Passenger passenger = new Passenger(new PassengerName("Ga", "Ram", "Yoon"));
        Seat seat = new Seat();
        seat.setRow(3);
        seat.setLetter('D');

        double price = sClass.getPrice(); // Economy base $500
        Ticket ticket = new Ticket(passenger, seat, price);

        System.out.println("Ticket1 issued: " + ticket);
        Assert.assertEquals(500.0, ticket.getPrice(), 0.005);
    }

    @Test
    public void sellTicket2() {
        // REQ-BR-05: Employee gets 50% discount on Economy = $250
        SeatingClass sClass = SeatingClass.ECONOMY;
        StaffPassenger passenger = new StaffPassenger(new PassengerName("Ga", "Ram", "Yoon"), "EMP123");
        Seat seat = new Seat();
        seat.setRow(4);
        seat.setLetter('C');

        double price = sClass.getPrice(); // Discount Applied to Economy base, $250
        Ticket ticket = new Ticket(passenger, seat, price);

        System.out.println("Ticket2 issued: " + ticket);
        Assert.assertEquals(250.0, ticket.getPrice(), 0.005);
    }

    @Test
    public void sellTicket3() {
        // REQ-BR-06: Employee Business class has NO discount = $750
        SeatingClass sClass = SeatingClass.BUSINESS;
        StaffPassenger passenger = new StaffPassenger(new PassengerName("Ga", "Ram", "Yoon"), "EMP123");
        Seat seat = new Seat();
        seat.setRow(1);
        seat.setLetter('A');

        double price = sClass.getPrice(); // Business = $750
        Ticket ticket = new Ticket(passenger, seat, price);

        System.out.println("Ticket3 issued: " + ticket);
        Assert.assertEquals(750.0, ticket.getPrice(), 0.005);
    }

    @Test
    public void sellTicket4() {
        // REQ-BR-07: Frequent Flyer, Economy class = $500 (no discount)
        SeatingClass sClass = SeatingClass.ECONOMY;
        FrequentFlyer passenger = new FrequentFlyer(new PassengerName("Ga", "Ram", "Yoon"), "FF123");
        Seat seat = new Seat();
        seat.setRow(2);
        seat.setLetter('B');

        double price = sClass.getPrice(); // Economy = $500, no discount
        Ticket ticket = new Ticket(passenger, seat, price);

        System.out.println("Ticket4 issued: " + ticket);
        Assert.assertEquals(500.0, ticket.getPrice(), 0.005);
    }

    @Test
    public void sellTicket5() {
        // REQ-BR-02: Regular passenger, Business class = $750
        SeatingClass sClass = SeatingClass.BUSINESS;
        Passenger passenger = new Passenger(new PassengerName("Ga", "Ram", "Yoon"));
        Seat seat = new Seat();
        seat.setRow(1);
        seat.setLetter('B');

        double price = sClass.getPrice();
        Ticket ticket = new Ticket(passenger, seat, price);

        System.out.println("Ticket5 issued: " + ticket);
        Assert.assertEquals(750.0, ticket.getPrice(), 0.005);
    }
}