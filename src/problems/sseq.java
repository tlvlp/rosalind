package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class sseq {

    /**
     * Takes two DNA strings in fasta format 
     * Returns the subsequence positions of the second string inside the first string
     * 
     * @param inList
     * @return
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
        System.out.println(outList);
        return outList;
    }
}