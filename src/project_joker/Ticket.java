/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Los_e
 */
public class Ticket {
    
    private int ticketid;
    
    private LocalDateTime ticketdate;
    private SortedSet<Integer> selectednumbers = new TreeSet<>();
    private SortedSet<Integer> selectedjokernumbers = new TreeSet<>();
    final double cost = 2.0;
    final int startnum = 1;
    final int endnum = 45;
    final int minimumnums = 5;
    final int maxnums = 45;
    final int startjokernum = 1;
    final int endjokernum = 20;
    final int minimumjokernums = 1;
    final int maxjokernums = 20;
    
    //Constructor

    public Ticket(int ticketid, Scanner sc) {
        this.ticketid = ticketid;
        chooseNumbers(sc);
        chooseJokerNumbers(sc);
        this.toString();
    }
    

    public void chooseNumbers(Scanner sc) {
    
        ArrayList numbersplayedarraylist = Utils.CollectChoices(sc, startnum, minimumnums, endnum, maxnums);
        
        if( Utils.checkNumbersInput(numbersplayedarraylist)) {
            
            selectednumbers.addAll(numbersplayedarraylist);
            System.out.println("Your numbers sorted: " + selectednumbers.toString());
            
    } else {
            System.out.println("Your choices should be unique numbers.");
        }
    }
    
    public void chooseJokerNumbers(Scanner sc) {
    
        ArrayList numbersplayedarraylist = Utils.CollectChoices(sc, startjokernum, minimumjokernums, endjokernum, maxjokernums);
        
        if( Utils.checkNumbersInput(numbersplayedarraylist)) {
            
            selectedjokernumbers.addAll(numbersplayedarraylist);
            System.out.println("Your numbers sorted: " + selectedjokernumbers.toString());
            
    } else {
            System.out.println("Your choices should be unique numbers.");
        }
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketid=" + ticketid + ", ticketdate=" + ticketdate + ", \nselectednumbers=" + selectednumbers + ", \nselectedjokernumbers=" + selectedjokernumbers + ", \ncost=" + cost + ", startnum=" + startnum + ", endnum=" + endnum + ", minimumnums=" + minimumnums + ", maxnums=" + maxnums + ", startjokernum=" + startjokernum + ", endjokernum=" + endjokernum + ", minimumjokernums=" + minimumjokernums + ", maxjokernums=" + maxjokernums + '}';
    }
    
    
}