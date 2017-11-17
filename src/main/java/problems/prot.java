package problems;

import java.util.*;
import utils.bio.TranslateRNAToProt;

/**
 * @author tlvlp
 */
public class prot {
    
    /**
     * Returns the protein strings for a list of RNA strings
     * @see http://rosalind.info/problems/prot
     * @param inList
     * @requires inList a list of RNA strings
     * @return   outList the list of translated protein strings
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        for (int i=0; i<inList.size(); i++) {
            outList.add(TranslateRNAToProt.get(inList.get(i)));
        }
        return outList;
    }
}