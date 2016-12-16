package problems;
import java.util.*;

/**
 * @author tlvlp
 */
public class subs {
    
    /**
     * Returns the substring positions
     * @see http://rosalind.info/problems/subs
     * @param inList
     * @requires inList with two DNA strings
     * @return   outList with all the locations (space separated integers) of the second string as a substring of the first.
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        String dna = inList.get(0);
        String dnaSub = inList.get(1);
        int dnaSubLen = dnaSub.length();
        String dnaSubPos = "";
        for (int i=0; i < dna.length()-dnaSubLen; ++i) {
            if (dna.substring(i, i + dnaSubLen).equals(dnaSub)) {
                dnaSubPos = dnaSubPos + " " + (i+1);                //the first pos is 1 according to the spec.
            }
        }
        outList.add(dnaSubPos);
        return outList;
    }
}