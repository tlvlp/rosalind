package problems;

import java.util.*;
import utils.converter.AminoAcidMass;

/**
 * @author tlvlp
 */
public class prtm {
    /**
     * Calculates net protein mass
     * @see http://rosalind.info/problems/prtm
     * @param inList
     * @requires inList with one protein sequence
     * @return   outList with one double: the net mass of all the amino acids in the protein sequence 
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        String proteinStr = inList.get(0);
        double currentMass = 0.0;
        double allMass = 0.0;
        for (int i=0; i < proteinStr.length(); ++i){
            currentMass = AminoAcidMass.get(proteinStr.charAt(i));
            allMass = allMass + currentMass;
        }
        outList.add(Double.toString(allMass));
        return outList;
    }
}