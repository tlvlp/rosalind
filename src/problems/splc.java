
package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class splc {
    
    /**
     * Solution of the Rosalind problem in the class name
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
    /* main method for the solution of the rosalind problem in the class name */
        ArrayList<String> inListFasta = new ArrayList<>();
        ArrayList<String> outList = new ArrayList<>();
        inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        outList.add(inListFasta.get(1));
        /* Remove the introns */
        String collector = outList.get(0);
        for (int i=3; i<inList.size(); i+=2) {
            collector = collector.replaceAll(inList.get(i), "");
        }
        outList.set(0, collector);
        /* Transcribe the exons to RNA  */
        outList = rna.solve(outList);
        //outlist.set(0,outlist.get(0).replaceAll("Stop",""))
        /* Translate to proteine sequence */
        outList = prot.solve(outList);
        return outList;
    }
}