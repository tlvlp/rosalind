package problems;

import java.io.IOException;
import java.util.*;
import utils.bio.GCContent;
import utils.parser.ParseToFastaStrings;

/**
 * @author tlvlp
 */
public class gc {
    
    /**
     * Returns the item with the largest GC content
     * @see http://rosalind.info/problems/gc
     * @param inList
     * @requires inList a list of DNA sequences in Fasta format
     * @return   outList containing the sequence with the highest GC count
     *           The first item is the Fasta ID and the second is an integer with the GC content percentage
     * @throws IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {	
        ArrayList<String> inListFasta = ParseToFastaStrings.parse(inList);
        double currentCnt;
        double largestCnt = 0.0;
        int largestCntID = 0;
        for (int i=1; i<inListFasta.size(); i+=2) {                             //assuming that the last line is always a base sequence
                currentCnt = GCContent.get(inListFasta.get(i));
                if (currentCnt > largestCnt) {
                        largestCnt = currentCnt;
                        largestCntID = i;
                }
        }
        ArrayList<String> outList = new ArrayList<>();
        int largestTitleID = largestCntID - 1;                                  // add title of largestCnt to output
        outList.add(inListFasta.get(largestTitleID).substring(1));
        outList.add(Double.toString(largestCnt));                               // add largestCnt to output
        return outList;
    }
}
