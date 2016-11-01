package problems;
import java.io.IOException;
import java.util.*;
import utils.InputParser;

/**
 * @author tlvlp
 */
public class gc {
    /**
     * !!! REQUIRES THE FASTA PARSER !!!
     * 
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {	
        /* get the line with the largest gc count.
        every first item is a header and every second is the base sequence related to it*/
        ArrayList<String> inListFasta = InputParser.parseFastaToArrayList(inList);
        
        double currentCnt;
        double largestCnt = 0.0;
        int largestCntID = 0;

        for (int i=1; i<inListFasta.size(); i+=2) {          //assuming that the last line is always a base sequence
                currentCnt = gcContentCalc(inListFasta.get(i));
                if (currentCnt > largestCnt) {
                        largestCnt = currentCnt;
                        largestCntID = i;
                }
        }
        ArrayList<String> outList = new ArrayList<>();
        // add title of largestCnt to output
        int largestTitleID = largestCntID - 1;
        outList.add(inListFasta.get(largestTitleID).substring(1));
        // add largestCnt to output
        outList.add(Double.toString(largestCnt));
        System.out.println("Title: " + inListFasta.get(largestTitleID).substring(1) + "  largestCnt: " + largestCnt); //debug
        return outList;
    }

    // Calculates the gc content of a dna string
    public static double gcContentCalc(String dna){
        double dnaLen = dna.length();
        int gcCount = 0;
        double gcContent = 0.0;

        for (int i=0 ;i<dnaLen; i++){
                if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C')
                        gcCount++;
        }
        gcContent = (gcCount/dnaLen) * 100;
        System.out.println("gcCount: " + gcCount + " dnaLen: " + dnaLen + " gcContent: " + gcContent );//debug
        return gcContent; 
    }
}
