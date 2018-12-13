package me.sgrochowski.garage;

import java.util.ArrayList;

/**
 * Tickets class, created by Sam Grochowski
 */
public class normalTix implements Tickets{
    private int ticketNumber;
    private int inTime;

    public normalTix(int tixID, int inTime){
        ticketNumber = tixID;
        this.inTime = inTime;
    }

    /**
     * This calculates the cost of the user being in the garage and returns it to the Ticket List
     * @param outTime A randomly generated time signifying when the user left the garage.
     * @return Returns an array of numbers including ticket number (-1 if invalid), in time, out time, and the total cost of the visit.
     */
    public int closeTix(int outTime){
        int cost;
        int totalTime = 12 - inTime + outTime;

        if((totalTime) <= 3){
            cost = 5;
        }
        else if((5 + (totalTime - 3)) > 15){
            cost = 15;
        }
        else{
            cost = 5 + (totalTime - 3);
        }
        return cost;
    }

    /**
     * lostTix is used when a user lost their ticket. They enter their vehicle ID. This program then reads through the data file. If it can not find the user supplied ID, it will return a -1 value to the driver so it can prompt for another input. if it is found, it is removed from the datasheet and the fee is assessed
     * @param tixNum The user input ticket number
     * @return Returns a single value (-1 if invalid input, the ticket number if it is valid)
     */
    public int lostTix(){
        return 25;
    }

    public int getID(){ return ticketNumber; }
    public int getIn() { return inTime; }
}
