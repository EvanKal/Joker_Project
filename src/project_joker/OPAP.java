/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joker;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Los_e
 */
public class OPAP {
    
    private int jackpot;
    private static int ticketsplayed;
    private static int numofdraws;
    private static int numofplayers;
    Scanner sc = new Scanner(System.in);
    
    private TreeMap<Integer, Draw> alldraws = new TreeMap();
    private TreeMap<Integer, Player> allplayers = new TreeMap();
    

    public int returnPlayerId() {
        OPAP.numofplayers++;
        return this.numofplayers;        
    }
    public int returnTicketId() {
        OPAP.ticketsplayed++;
        return this.ticketsplayed;        
    }
    public int returnDrawId() {
        OPAP.numofdraws++;
        return this.numofdraws;        
    }
    
    public void createPlayer() {
        System.out.println("Type name (only word characters, no digits):");
        Player player = new Player(Utils.inputString(sc), returnPlayerId());
        this.allplayers.put(player.getPlayerid(), player);
        System.out.println("Created player: " + player);
    }
    
    
            
    public void initiate() {
        System.out.println("Welcome! Create player.\n");
        createPlayer();
        
        System.out.println("\nInitiating your new ticket.");
        Ticket ticket = new Ticket(this.returnTicketId(), sc);
        
        

    }
    
}
