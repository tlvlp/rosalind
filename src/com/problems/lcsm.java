package com.problems;

import java.io.IOException;
import java.util.*;
import com.utils.data.SubstringValidation;
import com.utils.data.SelectOneLongestStringFromList;
import com.utils.parser.InputFastaToArraylist;

/**
 * @author tlvlp
 */
public class lcsm {
    
    /**
     * Returns the longest motif shared by all sequences
     * @see http://rosalind.info/problems/lcsm
     * @param inList
     * @requires inList a list of DNA sequences in Fasta format
     * @return   outList with the longest motif shared by all sequences
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = InputFastaToArraylist.parse(inList);  //parse input to a fasta compatible format
        ArrayList<String> longestList = new ArrayList<>();                              //create a list for the longestList strings and add the first fasta sequence
        longestList = CompareFirstTwoSequence(inListFasta.get(1), inListFasta.get(3));  //collect the common subset of the previous longestList substring and the next full sequence
        String longestStr = "";
        boolean isSubstringOfAll = false;                                               //checks if the string is a substing of all the sequences in the fasta file
        while (!isSubstringOfAll) {                                                     //loop while finding a largest shared sequence
            longestStr = SelectOneLongestStringFromList.get(longestList);              //return the last longest common substring (assuming that there is more than one with identical length)          
            longestList.remove(longestStr);                                             //remove the string from the original list not to be picked again in the future
            boolean isSubstringOfThisRound = true;                                      //checks if the current string is the substring of the current sequence
            for (int i=5; i<inListFasta.size(); i+=2) {                                 //loop through the rest of the sequences in the fasta file - assuming that there is more than two seqences
                if (!SubstringValidation.check(longestStr, inListFasta.get(i))) {    //check if the string is a substring of the current sequence
                   isSubstringOfThisRound = false;
                   break; 
                }
            }
            if (isSubstringOfThisRound) {                                               //check if isSubstringOfThisRound remains true through the loop
                isSubstringOfAll = true;
            }
        }
        outList.add(longestStr);
        return outList;
    }

    /**
     * Compares the substrings of two sequences
     * @param firstSequence
     * @param secondSequence
     * @requires Two DNA sequences as strings
     * @return   A list of substrings from the first sequence that can be found in the second sequence
     */
    public static ArrayList<String> CompareFirstTwoSequence (String firstSequence, String secondSequence) {
        ArrayList<String> sharedSubstringList = new ArrayList<>();
        for (int i=0; i<firstSequence.length()-1; i++) {
            for (int e=i+2; e<=firstSequence.length(); e++) {
                String subOfFirstSequence = firstSequence.substring(i, e);
                if (SubstringValidation.check(subOfFirstSequence, secondSequence)) {
                    sharedSubstringList.add(subOfFirstSequence);
                }
            }
        }
        return sharedSubstringList;
    }
}