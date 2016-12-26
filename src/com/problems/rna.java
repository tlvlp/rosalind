package com.problems;

import java.util.*;

/**
 * @author tlvlp
 */
public class rna {
    
    /**
     * Converts a list of DNA sequences to RNA sequences
     * @see http://rosalind.info/problems/rna
     * @param inList
     * @requires inList with a list of DNA sequences
     * @return   outList with a list of RNA sequences
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        for (String inList1 : inList) {
            outList.add(inList1.replaceAll("T", "U"));
        }
        return outList;
    }
}