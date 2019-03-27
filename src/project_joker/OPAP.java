
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
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
    public Scanner sc = new Scanner(System.in);
    
    private  TreeMap<Integer, Draw> alldraws = new TreeMap();
    private  TreeMap<Integer, Player> allplayers = new TreeMap();
    private  TreeMap<Integer, Ticket> alltickets = new TreeMap();
    

    public static int returnPlayerId() {
        OPAP.numofplayers++;
        return OPAP.numofplayers;        
    }
    public static int returnTicketId() {
        OPAP.ticketsplayed++;
        return OPAP.ticketsplayed;        
    }
    public static int returnDrawId() {
        OPAP.numofdraws++;
        return OPAP.numofdraws;        
    }
    
    public void addTicketToOPAP(Ticket ticket) {
        this.alltickets.put(ticket.getTicketid(), ticket);
    }
    
    public Player createPlayer() {
        System.out.println("Type name (only word characters, no digits):");
        Player player = new Player(Utils.inputString(sc), returnPlayerId());
        this.allplayers.put(player.getPlayerid(), player);
        System.out.println("Created player: " + player);
        
        return player;
    }
    
    public void printPlayers() {
        
        for (Map.Entry<Integer, Player> entry : this.allplayers.entrySet()) {
                System.out.println("Player " + entry.getKey() + "\n " + entry.getValue() + "\n");
        }
            
    }
    
    public void printDraws() {
        
        for (Map.Entry<Integer, Draw> entry : this.alldraws.entrySet()) {
                System.out.println("Draw " + entry.getKey() + "\n " + entry.getValue() + "\n");
        }
            
    }
            
    public void choosePlayerAndPlayTicket() {
        
        if(this.allplayers.isEmpty()){
        System.out.println("\nNo players created. Please create a new player in order to play.");
        } else {
            
        System.out.println("\nSelect an item from the list to access, by typing their item number:");
        this.printPlayers();
 

        int input = Utils.inputInt(sc);

        while(!(input<=this.allplayers.size()) || input==0) {
               System.out.println("Invalid data input. Invalid integer (integer cannot be greater than the size of the list, or zero)");
               input = Utils.inputInt(sc);
        }
        
        this.allplayers.get(input).playNewTicket(this);
        
        }
        }
        
        
    public void newDraw() {
    Draw draw = new Draw(returnDrawId());
    this.alldraws.put(draw.getDrawid(), draw);
    System.out.println("New Draw " + draw.toString());
    
    }    

    
    
    public void initiate() {
    System.out.println("Welcome!");
    
    while(1==1) {
            System.out.println("\nChoose what you want to do by typing the corresponding number.\n"
            + "\n1. Create new player."
            + "\n2. Play new ticket."
            + "\n3. View Players."
            + "\n4. New draw."
            + "\n5. View draws."
//            + "\n6. To view or access  courses."
//            + "\n7. To view or access trainers."
//            + "\n8. To view or access assignments."
//            + "\n9. To view students that need to submit an assignment by a given date."
//            + "\n10. To view students enrolled to more than one courses."
//            + "\n11. To create synthetic data."
            );
            
            int choice = Utils.inputInt(sc);
            
            while(choice<1 || choice >11) {
                System.out.println("Invalid choice. Please type a number again.");
                choice = Utils.inputInt(sc);
            }
            
            if(choice == 1) {this.createPlayer();}
            if(choice == 2) {this.choosePlayerAndPlayTicket();}
            if(choice == 3) {this.choosePlayerAndPlayTicket();}
            if(choice == 4) {this.newDraw();}
            if(choice == 5) {this.printDraws();}
//            if(choice == 6) {this.printAccessEntity("course", "courses", this.courseList);}
//            if(choice == 7) {this.printAccessEntity("trainer", "trainers", this.trainerList);}
//            if(choice == 8) {this.printAccessEntity("assignment", "assignments", this.assignmentList);}
//            if(choice == 9) {System.out.println("Input date: ");this.printStudentsThatNeedToSubmitThisWeek(this.inputStringDate());}
//            if(choice == 10) {System.out.println("Printing student's enrolled to more than one course: "); this.printStudentsToMoreThanOneCourse(this.studentList);}
//            if(choice == 11) {this.createSyntheticData();}
            
    }
    
}
}