package utils.bio;

import java.util.ArrayList;
import utils.converter.AminoAcidFromRNA;

/**
 * @author tlvlp
 */
public class AllValidProteinSequencesFromRNA {

    /**
     * Returns all the valid protein sequences from an RNA String
     * @see Reading frames
     * @requires An RNA String
     * @return   An ArrayList of all valid protein sequence candidates from the input.
     *           Note that the complement String need to be processed as well to get all the valid results for a given RNA string.
     * @param rnaSeq
     */
    public static ArrayList<String> get(String rnaSeq) {
        ArrayList<String> frameList = new ArrayList<>();
        for (int i = 0; i < rnaSeq.length() - 2; i++) {
            String subSeq;
            String codon;
            String proteinStr;
            if (rnaSeq.substring(i, i + 3).equals("AUG")) {
                subSeq = rnaSeq.substring(i);
                proteinStr = "";
                for (int g = 0; g < subSeq.length() - 2; g += 3) {
                    codon = subSeq.substring(g, g + 3);
                    proteinStr = proteinStr + AminoAcidFromRNA.get(codon);
                }
                if (proteinStr.contains("stop")) {
                    proteinStr = proteinStr.substring(0, proteinStr.indexOf("stop"));
                    frameList.add(proteinStr);
                }
            }
        }
        return frameList;
    }
}
