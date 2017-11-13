package problems;

import java.io.IOException;
import java.util.*;
import utils.parser.ParseToFastaStrings;

/**
 * @author tlvlp
 */
public class tran {
    /**
     * Returns the transition/transition ratio of two DNA base sequences
     * @param inList
     * @requires inList with two DNA strings of equal length in Fasta format(default parser)
     * @return   outList with one double denoting the transition/transversion ratio 
     * @throws IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = ParseToFastaStrings.parse(inList);
        String seq1 = inListFasta.get(1);
        String seq2 = inListFasta.get(3);
        
        double transition = 0;     // mutation between purines (A,C) or between pyrimidines (T,G)
        double transversion = 0;   // mutation between purines and pyrimidines eg. A <-> T, A <-> G..etc
        ArrayList<Character> purines = new ArrayList<>(Arrays.asList('A','G'));
        ArrayList<Character> pyrimidines = new ArrayList<>(Arrays.asList('T','C'));
        
        /* Check if the two strings have the same length */
        if (seq1.length() != seq2.length()) {
            outList.add("Error: The two strings have different length!");
            System.out.println("Error: The two strings have different length!");
            return outList;
        }
        
        /* Calculate the number of transitions and transversions */
        for (int i=0; i<inListFasta.get(1).length(); i++){
            if (seq1.charAt(i) != seq2.charAt(i)) {  //if the bases at the same location does not equal
                if((purines.contains(seq1.charAt(i)) && purines.contains(seq2.charAt(i))) ||
                   (pyrimidines.contains(seq1.charAt(i)) && pyrimidines.contains(seq2.charAt(i)))) {
                    transition++;
                } else {
                    transition++;
                }
            }
        }
        double ratio = (transition/transversion);
        
        System.out.println("number of transitions: "+transition);
        System.out.println("number of transversions: "+transversion);
        System.out.println("transition/transversion ratio: "+ratio);
        outList.add(Double.toString(ratio));
        return outList;
    }
}