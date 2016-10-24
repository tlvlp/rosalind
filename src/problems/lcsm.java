/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class lcsm {
    public static String parser = "fasta";
    /**
     * @param inList
     * @return
     */
    
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        System.out.println("start");
        
        //declaring the longest string and giving it the initial value of the first fasta sequence
        String longest = inList.get(1);
        
        //loop through the longest common sequence and see if the next fasta sequence contains it too 
        for (int i=1;i) {
            longest = inList.get(1);
            String next = inList.get(3);
            System.out.println(longest);
        }
            //the common subset of longest and next becomes the new longest
            
            
        
        
        // return the longest common substring
        outList.add(longest);
        return outList;
    }
}