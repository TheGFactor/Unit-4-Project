package me.sgrochowski.garage;

/**
 * Tickets class, created by Sam Grochowski
 */
public class specialTix implements Tickets{
    private int ticketNumber;
    private int inTime = -22; //-22 means to the code reader that this is a special event ticket.


    public specialTix(int tixID, int inTime){
        ticketNumber = tixID;

    }

    /**
     * This simply returns the price of a closed special event ticket
     * @param outTime A randomly generated time signifying when the user left the garage.
     * @return Returns an array of numbers including ticket number (-1 if invalid), in time, out time, and the total cost of the visit.
     */
    public int closeTix(int outTime){
        return 20;
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
