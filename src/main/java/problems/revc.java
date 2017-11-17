package problems;

import java.util.*;
import utils.bio.DNABaseComplement;

/**
 * @author tlvlp
 */
public class revc {
    
    /**
     * Returns the reverse complements of a list of DNA sequences 
     * @see http://rosalind.info/problems/revc
     * @param inList
     * @requires inList with a list of DNA sequences
     * @return   outList a list of reverse complement DNA sequences
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        for (String i : inList) {
            outList.add(DNABaseComplement.getComplementSequence(i));
        }
        return outList;
    }
    
}