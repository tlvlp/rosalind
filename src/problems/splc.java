package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class splc {
    
    /**
     * Returns a spliced and translated protein string.
     * @see http://rosalind.info/problems/splc
     * @param inList
     * @requires inList with a DNA string and a list of intron strings in Fasta format
     * @return   outList with a a spliced and translated protein string
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        ArrayList<String> outList = new ArrayList<>();
        outList.add(inListFasta.get(1));
        String collector = outList.get(0);                                  // Remove introns
        for (int i=3; i<inListFasta.size(); i+=2) {
            collector = collector.replaceFirst(inListFasta.get(i), "");
        }
        outList.set(0, collector);
        outList = rna.solve(outList);                                       //Transcribe exons to RNA
        outList = prot.solve(outList);                                      //Translate to proteine sequence
        return outList;
    }
}