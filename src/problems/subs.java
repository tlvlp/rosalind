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
public class subs {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        String dna = inList.get(0);
        String dnaSub = inList.get(1);
        int dnaSubLen = dnaSub.length();
        String dnaSubPos = "";

        for (int i=0; i < dna.length()-dnaSubLen; ++i) {
                if (dna.substring(i, i + dnaSubLen).equals(dnaSub)) {
                        // counting with i+1 as the first pos is 1 according to the spec. 
                        dnaSubPos = dnaSubPos + " " + (i+1);
                        System.out.println(dnaSubPos); //debug
                }
        }
        
        outList.add(dnaSubPos);
        return outList;
    }
}