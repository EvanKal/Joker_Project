/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joker;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Los_e
 */
public class Player {
    
    private String name;
    private int playerid;
    private TreeMap<Integer, Ticket> playerstickets = new TreeMap();

    public Player(String name, int playerid) {
        this.name = name;
        this.playerid = playerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public TreeMap<Integer, Ticket> getPlayerstickets() {
        return playerstickets;
    }

    public void setPlayerstickets(TreeMap<Integer, Ticket> playerstickets) {
        this.playerstickets = playerstickets;
    }
    
    public void playNewTicket(OPAP opap) {
    
        System.out.println("\nInitiating your new ticket.");
        Ticket ticket = new Ticket(opap.returnTicketId(), opap.sc);
        this.playerstickets.put(ticket.getTicketid(), ticket);
        opap.addTicketToOPAP(ticket);
        ticket.addPlayerToTicket(this);
        System.out.println(ticket.toString());
    
    }

    @Override
    public String toString() {
        return "Player{"
                + "\nname=" + name + ", "
                + "\nplayerid=" + playerid + ", "
                + 
//                "\nplayerstickets=" + playerstickets + 
                '}';
    }

    
    

  
}
