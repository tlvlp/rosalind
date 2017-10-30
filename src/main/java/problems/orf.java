package problems;

import java.io.IOException;
import java.util.*;
import utils.bio.AllValidProteinSequencesFromRNA;
import utils.bio.DNABaseComplement;
import utils.parser.InputFastaToArraylist;

/**
 * @author tlvlp
 */
public class orf {

    /**
     * Returns every protein string candidate of a DNA sequence
     * @see http://rosalind.info/problems/orf
     * @requires inList with at most one DNA sequence in Fasta format
     * @return   outList with all the protein string candidates as the list items
     *           Each item can only appear at most once
     * @param inList
     * @throws IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = InputFastaToArraylist.parse(inList);
        inListFasta.remove(0);                                                              //Remove the fasta header        
        inListFasta.add(DNABaseComplement.dnaBaseComplement(inListFasta.get(0)));            //Add complement string                
        inListFasta = rna.solve(inListFasta);                                               //Transcribe exons to RNA
        outList.addAll(AllValidProteinSequencesFromRNA.get(inListFasta.get(0)));       //Collect all the protein sequence candidates for both directions
        outList.addAll(AllValidProteinSequencesFromRNA.get(inListFasta.get(1)));
        Collections.sort(outList);                                                          //Remove duplicate entries
        for (int s=outList.size()-1; s>0; s--) {
            if (outList.get(s).equals(outList.get(s-1))) {
                outList.remove(s);
            }
        }
        return outList;
    }
        
}