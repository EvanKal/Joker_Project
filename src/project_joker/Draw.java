/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joker;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Los_e
 */
public class Draw {
    
    private LocalDateTime drawdate;
    private int drawid;
    private SortedSet<Integer> winningnumbers = new TreeSet<Integer>();
    private SortedSet<Integer> winningjokernumber = new TreeSet<Integer>();
    private Random generator = new Random();
    final int startnum = 1;
    final int endnum = 45;
    final int minimumnums = 5;
    final int maxnums = 45;
    final int startjokernum = 1;
    final int endjokernum = 20;
    final int minimumjokernums = 1;
    final int maxjokernums = 20;

    public Draw(int drawid) {
        this.drawid = drawid;
        this.drawdate = LocalDateTime.now();
        this.winningnumbers.addAll(drawNumbers(minimumnums, startnum, endnum));
        this.winningjokernumber.addAll(drawNumbers(minimumjokernums, startjokernum, endjokernum));
    }

    public int getDrawid() {
        return drawid;
    }

    public SortedSet<Integer> getWinningnumbers() {
        return winningnumbers;
    }

    public SortedSet<Integer> getWinningjokernumber() {
        return winningjokernumber;
    }
    
    
    
    public Set drawNumbers(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        IntStream drawnumbers = generator.ints(streamSize, randomNumberOrigin, (randomNumberBound+1));
        Set<Integer> drawnumbersset =  drawnumbers.boxed().collect(Collectors.toSet());
        
        while(drawnumbersset.size()<streamSize) {
            drawnumbers = generator.ints(streamSize, randomNumberOrigin, (randomNumberBound+1));
            drawnumbersset =  drawnumbers.boxed().collect(Collectors.toSet());
            
            System.out.println("Draw brought duplicate numbers. Drawed anew.");
        }
        
        return drawnumbersset;    
    }

    @Override
    public String toString() {
        return "\nDraw date: " + drawdate + ", "
                + "\nDraw ID: " + drawid + ", "
                + "\nWinning numbers: " + winningnumbers + ", "
                + "\nWinning joker number: " + winningjokernumber;
    }
    

    
}
