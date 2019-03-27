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
public class Utils {
    
    
    public static String inputString(Scanner sc) {
        String input;
        input = sc.nextLine();
        String regex1 = "^[a-zA-Z]*$";
        
        while (!input.matches(regex1) || input.equals("") || input.matches("^\\s*$")) {

            if(input.equals("") || input.matches("^\\s*$")) {
            System.out.println("No data input. Please type word characters");
            input = sc.nextLine();
            } else {
            System.out.println("Invalid data input. Please type word characters");
            input = sc.nextLine();
            }
            
        }
        
        return input;
    }
    
    public static int inputInt(Scanner sc) {
    String input;
    input = sc.nextLine();
    String regex1 = "^[0-9]*$";
    
    while (!input.matches(regex1) || input.equals("") || input.matches("^\\s*$")) {
        
             if(input.equals("") || input.matches("^\\s*$")) {
            System.out.println("No data input. Please type Please type a number.");
            input = sc.nextLine();
            } else {
             System.out.println("Invalid data input. Please type a number.");
             input = sc.nextLine();
            }
             
        }
    
        return Integer.parseInt(input);
}
    
    
    public static ArrayList<Integer> CollectChoices(Scanner sc, int startnum, int minimumnums, int endnum, int maxnums) {
    
    //Returns an arrayList of integers corresponding to the indexes of the user's choices
        System.out.println("\nHow many numbers do u want to play?");
        int totalnumbers = Utils.inputInt(sc);
        
        while(totalnumbers<minimumnums || totalnumbers>endnum) {
            System.out.println("Number must be from "+minimumnums+ " to " +maxnums+ ". Input valid total of numbers.");
            totalnumbers = Utils.inputInt(sc);
        }
        
    
    int input;
    ArrayList<Integer> choices = new ArrayList<>(totalnumbers);
    
//    this.printList(arraylist);    
    System.out.println("Choose numbers from "+ startnum + " to " + endnum + " by typing each number and hitting enter.\n");
        
        for (int i = 0; i < totalnumbers; i++) {
            input = Utils.inputInt(sc);
            while(input<startnum || input>endnum){
                System.out.println("Input value must be from "+startnum+" to "+ endnum);
                input = Utils.inputInt(sc);
            }
            choices.add(input);
        }

    return choices;
}
    
public static boolean checkNumbersInput(ArrayList arraylist) {
    
SortedSet settoreturn = new TreeSet<>();
settoreturn.addAll(arraylist);

if(arraylist.size()==settoreturn.size()) {
    return true;
} else { 
    return false;
}

}

//public static void printList(TreeMap treemap) {
//
//    if(treemap.size()>0) {
//        
//        System.out.println("\nPrinting list with " + treemap.size() + " elements:");
//        for (Map.Entry<K, V> entry : treemap.entrySet()) {
//    System.out.println(entry.getKey() + "/" + entry.getValue());
//}
//        
//        
//        
////        for (Iterator it = treemap.entrySet().iterator(); it.hasNext();) {
////            TreeMap.Entry entry = it.next();
////            System.out.println(">>>" + treemap.get(i).getClass().getSimpleName() + " " + (i+1));
////            System.out.println(treemap.get(i).toString());
////        }
//    }else if(treemap.isEmpty()) {
//        System.out.println("Currently no items in list.");
//    }
//    
//}
    
//    public void printList(ArrayList arraylist) {
//
//    if(arraylist.size()>0) {
//            System.out.println("\nPrinting list with " + arraylist.size() + " elements:");
//        for (int i = 0; i < arraylist.size(); i++) {
//            if(arraylist.get(i) instanceof IndividualAssignment) {
//            System.out.println(">>>" + arraylist.get(i).getClass().getSuperclass().getSimpleName() + " " + (i+1));
//            System.out.println(arraylist.get(i).toString());
//            } else {
//            System.out.println(">>>" + arraylist.get(i).getClass().getSimpleName() + " " + (i+1));
//            System.out.println(arraylist.get(i).toString());
//            }
//
//        }
//    }else if(arraylist.isEmpty()) {
//        System.out.println("Currently no items in list");
//    }
//    
//}
}
