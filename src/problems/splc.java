
package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class splc {
    
    /**
     * Takes a DNA string and a list of intron strings in fasta format
     * Returns a spliced and translated protein string
     * 
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        ArrayList<String> outList = new ArrayList<>();
        outList.add(inListFasta.get(1));
        
        /* Remove introns */
        String collector = outList.get(0);
        for (int i=3; i<inListFasta.size(); i+=2) {
            collector = collector.replaceFirst(inListFasta.get(i), "");
        }
        outList.set(0, collector);
        
        /* Transcribe exons to RNA  */
        outList = rna.solve(outList);
        
        /* Translate to proteine sequence */
        outList = prot.solve(outList);
        outList.set(0,outList.get(0).replaceAll("stop","")); // replace the the original "stop" string for the stop codon
        
        System.out.println(outList.get(0));
        return outList;
    }
}