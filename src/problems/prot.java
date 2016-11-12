/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;
import utils.Converter;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class prot {
    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        String dna = inList.get(0);
        String codon = "";
        String proteinStr = "";

        // does not handle the stop codon!
        for (int i=0; i < dna.length()-3; i +=3 ){
                codon = dna.substring(i,i+3);
                proteinStr = proteinStr + Converter.getAminoAcid_fromRNA(codon);
        }
        
        outList.add(proteinStr);
        return outList;
    }
}