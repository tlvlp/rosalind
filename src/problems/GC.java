package problems;
import java.util.*;

/**
 *
 * @author tlvlp
 */
public class GC {

    /**
     *
     * @param inList
     * @return
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        /* get the line with the largest GC count.
        every first item is a header and every second is the base sequence related to it*/
        double currentCnt;
        double largestCnt = 0.0;
        int largestCntID = 0;

        for (int i=1; i<inList.size(); i+=2) {          //assuming that the last line is always a base sequence
                currentCnt = gcContentCalc(inList.get(i));
                if (currentCnt > largestCnt) {
                        largestCnt = currentCnt;
                        largestCntID = i;
                }
        }
        ArrayList<String> outList = new ArrayList<>();
        // add title of largestCnt to output
        int largestTitleID = largestCntID - 1;
        outList.add(inList.get(largestTitleID).substring(1));
        // add largestCnt to output
        outList.add(Double.toString(largestCnt));
        System.out.println("Title: " + inList.get(largestTitleID).substring(1) + "  largestCnt: " + largestCnt); //debug
        return outList;
    }

    // Calculates the GC content - move it to a separate class if it will be needed elsewhere :)
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