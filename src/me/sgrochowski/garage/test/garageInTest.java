package me.sgrochowski.garage.test;

import me.sgrochowski.garage.TicketList;
import me.sgrochowski.garage.Tickets;
import org.junit.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class garageInTest {
    @Test
    public void testNoTicketFound(){
        TicketList tix = TicketList.getInstance();
        tix.newTicket(6);
        Integer[] test = new Integer[]{-1,0,0,0};
        assertEquals(test, tix.checkOut(-6, 8), "This should return -1, as -6 is not a valid ticket number");
    }
}
