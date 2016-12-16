package problems;
import java.util.*;

/**
 * @author tlvlp
 */
public class hamm {
    
    /**
     * Returns the Hamming distance of two DNA sequences
     * @see http://rosalind.info/problems/hamm
     * @param inList
     * @requires inList with two DNA sequences of equal length
     * @return   outList with one integer: The Hamming distance between the two sequences
     *           (the number of point mutations)
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
       ArrayList<String> outList = new ArrayList<>();
       int inputLength = inList.get(0).length();
       int hammingDist = 0;
       for (int i = 0; i < inputLength; ++i) {
            if (inList.get(0).charAt(i) != inList.get(1).charAt(i))
                ++hammingDist;
       }
       outList.add(Integer.toString(hammingDist));
       return outList;
    }
}