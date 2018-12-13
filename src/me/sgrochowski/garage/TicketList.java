/**
 * Here I created my Singleton class. This acts as a list of all current tickets. It reads from the file, and upon close, will write all new information to the file.
 */
package me.sgrochowski.garage;

import java.util.ArrayList;

public class TicketList {
    private static TicketList instance;

    private String[] header; //This header contains data like the id of the most recent ticket, how many tickets were sold, etc.
    private ArrayList<Tickets> tix = new ArrayList<>();
    /**
     * When ticket list is created, it reads from the ticket file that is currently stored, then puts it into array lists.
     */
    private TicketList(){
        FileInput input = new FileInput("tickets.csv");
        String currentLine;
        String[] eval;
        header = input.readFile().split(",");
        if(header == null){
            header[0] = "0";
            header[1] = "0";
            header[2] = "0";
            header[3] = "0";
        }
        while((currentLine = input.readFile()) != null){

            eval = currentLine.split(",");
            tix.add(ticketFactory.newTicket(Integer.parseInt(eval[0]), Integer.parseInt(eval[1])));

        }
        input.closeFile();

    }

    /**
     * Our singleton constructor
     */
    public static synchronized TicketList getInstance(){
        if (instance == null){
            instance = new TicketList();
        }
        return instance;

    }

    /**
     * This outputs everything that is currently in the array to the file so it can be accessed later.
     */
    public String[] closeFile(){
        FileOutput output = new FileOutput("tickets.csv");
        output.fileWrite(header[0] + "," + header[1] + "," + header[2] + "," + header[3]+ "\r");
        for(Tickets t:tix){
            output.fileWrite(t.getID() + "," + t.getIn() + "\r");
        }
        output.fileClose();


        return header;
    }

    /**
     * This creates a new ticket from the array. Utilizes ticketFactory to create a new ticket
     * @param inTime
     * @return
     */

    public int newTicket(int inTime){

        header[0] = String.valueOf(Integer.parseInt(header[0]) + 1);
        tix.add(ticketFactory.newTicket(Integer.parseInt(header[0]), inTime));

        return Integer.parseInt(header[0]);
    }

    /**
     * Calls for a lost ticket to be filed as lost. Will return to the user that they had an invalid ticket number if it is invalid.
     * @param id
     * @return
     */

    public int lostTix(int id){
        int tixIndex = -1;
        int cost = 0;

        for(int x = 0; x < tix.size(); x++){
            if(tix.get(x).getID() == id){
                tixIndex = x;
                break;
            }
        }

        if(tixIndex == -1){
            return tixIndex;
        }
        else{
            cost = tix.get(tixIndex).lostTix();
            tix.remove(tixIndex);
            header[3] = String.valueOf(Integer.parseInt(header[3]) + 1);
            return tixIndex;
        }
    }

    /**
     * Same thing as the lost ticket, except this time it passes a check out command to the ticket in the array.
     * @param id
     * @param out
     * @return
     */

    public int[] checkOut(int id, int out){
        int tixIndex = -1;
        int[] data = {-1,0,0,0};

        for(int x = 0; x < tix.size(); x++){
            if(tix.get(x).getID() == id){
                tixIndex = x;
                break;
            }
        }

        if(tixIndex == -1){
            return data;
        }
        else{
            data[0] = tixIndex;
            data[1] = tix.get(tixIndex).getIn();
            data[2] = out;
            data[3] = tix.get(tixIndex).closeTix(data[2]);
            tix.remove(tixIndex);
            header[1] = String.valueOf(Integer.parseInt(header[1]) + 1);
            header[2] = String.valueOf(Integer.parseInt(header[2]) + data[3]);
            return data;
        }
    }
/*
    public void debug(){
        for(int x = 0; x < tix.size(); x++){
            System.out.println(tix.toString());
        }
    }
*/
    public void resetFile(){
        header[0] = "0";
        header[1] = "0";
        header[2] = "0";
        header[3] = "0";

        for(int x = 0; x < tix.size(); x++){
            tix.remove(x);
        }

        closeFile();
    }
}


