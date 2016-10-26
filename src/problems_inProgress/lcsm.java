/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems_inProgress;
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
        
        //loop through all the fasta sequences in the output (everey 2nd entry as every 1st is the header)
        for (int i=3; i<inList.size(); i+=2) {
            //get the currentSeq sequence
            String currentSeq = inList.get(i);
            //collect the longest common subset of the previous longest substring and the next full sequence 
            longest = getLongest(currentSeq,longest);
            System.out.println(longest); //debug - print out the longest after checking each sequence
        }
        
        // return the longest common substring
        outList.add(longest);
        return outList;
    }
    
    public static String getLongest (String currentSeq, String longest) {
     /* collects the longest common subset of the previous longest substring and the next full sequence */
        
        //list to collect the common sub
        ArrayList<String> commonList = new ArrayList<>();
        
        //loop through all the substring variations of longest
        for (int i=0; i<longest.length()-1; i++) {
            for (int e=1; e<longest.length(); e++) {
                //this substring variation of longest
                String subOfLongest = longest.substring(i, e);
                // if this substring of longest is a substring of currentSeq as well it is added to the list 
                if (isValidSubStr(subOfLongest, currentSeq)) {
                    commonList.add(subOfLongest);
                }
                
            }
        }
        
        //the elements of commonList are checked and the longest will be chosen
        /* 
        !! should be a list if there are more than one !! 
        fuck then it will have to be done for each element of the new longest list isntead of handling only one string
        */
        
        return longest;
    }
    
    public static boolean isValidSubStr(String checkStr, String baseStr) {
        //loop through the currentSeq and see if subOfLongest is contained at all - returns true if a match is found, returns false at the end of the loop
    }
}