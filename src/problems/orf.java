package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class orf {

    /**
     * Solution of the Rosalind problem in the class name
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        System.out.println(inListFasta);
        inListFasta.remove(0);
        System.out.println(inListFasta);
        
        inListFasta = rna.solve(inListFasta);   //Transcribe exons to RNA
        System.out.println(inListFasta);
        
        //find start and stop codons before translation
        //AUG ... [UAA, UAG, UGA]
        
        //collect all the possible sequences
        
        //translate the sequences - prot has been prepared to translate each item of the list it receives!
        
        inListFasta = prot.solve(inListFasta);  //Translate  to proteine sequence
        System.out.println(inListFasta);
        
        System.out.println(inListFasta);
        return inListFasta;
    }
}