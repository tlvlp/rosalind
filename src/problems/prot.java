/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;
import utils.BioInfOperations;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class prot {
    /**
     * Returns the protein strings for a list of RNA strings
     * input: ArrayList
     * output: ArrayList
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        for (int i=0; i<inList.size(); i++) {
            outList.add(BioInfOperations.translate_RNA_to_Prot(inList.get(i)));
        }
        return outList;
    }
}