package problems;

import java.util.*;
import utils.converter.AminoAcidVarNum;

/**
 * @author tlvlp
 */
public class mrna {
    
    /**
     * Returns the number of different RNA strings from which the protein could have been translated
     * @see http://rosalind.info/problems/mrna
     * @param inList
     * @requires inList with a protein string (amino acid sequence)
     * @return   outList with one integer:
     *           The number of different RNA strings from which the protein could have been translated
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        String proteinStr = inList.get(0);
        int varNum = 0;
        long allVar = 3;  // already counting in the 3 variations of the stop codon.
        for (int i=0; i < proteinStr.length(); ++i){
                varNum = AminoAcidVarNum.get(proteinStr.charAt(i));
                allVar = (allVar * varNum)%1000000;
        }
        outList.add(Long.toString(allVar));
        return outList;
    }
}