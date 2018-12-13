package me.sgrochowski.garage;
//Sets up the interface in which tickets are spawned from
public interface Tickets{
    int closeTix(int t);
    int lostTix();
    int getID();
    int getIn();
}