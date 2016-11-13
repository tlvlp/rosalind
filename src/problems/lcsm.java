/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.io.IOException;
import java.util.*;
import utils.DataOperations;
import utils.FileInputParser;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class lcsm {
    /**
     * Returns the longest motif shared by all sequences
     * @param inList
     * @return
     * @throws java.io.IOException
     */

    //main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        
        //parse input to a fasta compatible format
        ArrayList<String> inListFasta = FileInputParser.parseFastaToArrayList(inList);
        
        //create a list for the longestList strings and addig the first fasta sequence
        ArrayList<String> longestList = new ArrayList<>();
        
        //collect the common subset of the previous longestList substring and the next full sequence
        longestList = CompareFirstTwoSequence(inListFasta.get(1), inListFasta.get(3));
        
        String longestStr = "";
        //checks if the string is a substing of all the sequences in the fasta file
        boolean isSubstringOfAll = false;
        //loop while finding a largest shared sequence
        while (!isSubstringOfAll) {
            //return the last longest common substring (assuming that there are more than one with identical length)            
            longestStr = DataOperations.SelectLastLongestItem(longestList);
            //remove the string from the original list not to be picked again in the future
            longestList.remove(longestStr);
            //checks if the current string is the substring of the current sequence
            boolean isSubstringOfThisRound = true;
            //loop through the rest of the sequences in the fasta file - assuming that there is more than two seqences
            for (int i=5; i<inListFasta.size(); i+=2) {
                //check if the string is a substring of the current sequence
                if (!DataOperations.isValidSubStr(longestStr, inListFasta.get(i))) {
                   isSubstringOfThisRound = false;
                   break; 
                }
            }
            //check if isSubstringOfThisRound remains true through the loop
            if (isSubstringOfThisRound) {
                isSubstringOfAll = true;
            }
        }
        
        //add the longestStr to the standard output list
        outList.add(longestStr);
        return outList;
    }

    public static ArrayList<String> CompareFirstTwoSequence (String firstSequence, String secondSequence) {
    /*  2. compares its items to the second sequence
        3. only keeps the items or the substrings of the items that can be found in the second sequence */
        System.out.println("firstSequence: " + firstSequence);
        System.out.println("secondSequence: " + secondSequence);
        //a list to collect the shared subsequences
        ArrayList<String> sharedSubstringList = new ArrayList<>();
        //loop through all the substring variations of longestList
        for (int i=0; i<firstSequence.length()-1; i++) {
            for (int e=i+2; e<=firstSequence.length(); e++) {
                //this substring variation of longestList
                String subOfFirstSequence = firstSequence.substring(i, e);
                //if this substring of longestList is a substring of second sequence as well it is added to the list
                //adding !sharedSubstringList.contains(subOfFirstSequence) && to the if statement reduces redundance but adds 10s to the runtime instead of shortening it
                if (DataOperations.isValidSubStr(subOfFirstSequence, secondSequence)) {
                    sharedSubstringList.add(subOfFirstSequence);
                }
            }
        }
        return sharedSubstringList;
    }
}