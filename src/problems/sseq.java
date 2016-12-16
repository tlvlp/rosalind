package problems;

import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class sseq {
    
    /**
     * Returns the subsequence positions
     * @see http://rosalind.info/problems/sseq
     * @param inList
     * @requires inList with two DNA strings in Fasta format
     * @return   outList with all the locations (space separated integers) of the second string's characters as a subsequence of the first. 
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        String mainSeq = inListFasta.get(1);
        String subSeq = inListFasta.get(3);
        String coords = "";
        int posm=0;
        int poss=0;
        for (int s=poss; s<subSeq.length(); s++) {
            for (int m=posm; m<mainSeq.length(); m++) {
                if (mainSeq.charAt(m) == subSeq.charAt(s)) {                    
                    coords = coords + (m+1) + " ";
                    posm = m+1;
                    poss = s+1;
                    break;
                }
            }
        }
        coords = coords.trim();
        outList.add(coords);
        return outList;
    }
}