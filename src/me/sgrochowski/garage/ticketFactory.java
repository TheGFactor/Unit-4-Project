package me.sgrochowski.garage;
/**
 * This is my factory for tickets. It sees what the in time is for the ticket. If the in time is -22, then it knows it is a special event ticket, and creates a special event. Otherwise, it returns a normal ticket.
 */
public abstract class ticketFactory {
    public static Tickets newTicket(int ID, int in){
        Tickets re;
        if(in == -22){
            re = new specialTix(ID, in); //Returns a new special event ticket
        }
        else
            re = new normalTix(ID, in); //Returns a new normal ticket
        return re;
    }
}
