package com.problems;

import java.util.*;

/**
 * @author tlvlp
 */
public class dna {
    /**
     * Returns the number of occurrences of each base
     * @see http://rosalind.info/problems/dna
     * @param inList
     * @requires 
     * @return   
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {
        ArrayList<String> outList = new ArrayList<>();
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        String str = inList.get(0);
        for (int i=0; i<str.length(); ++i) {	
            switch (str.charAt(i)) {
                        case 'A':
                                ++a;
                                break;
                        case 'C':
                                ++c;
                                break;
                        case 'G':
                                ++g;
                                break;
                        case 'T':
                                ++t;
                                break;
            }
        }
        outList.add(a +" "+ c +" "+ g +" "+ t);
        return outList; 
    }
}
