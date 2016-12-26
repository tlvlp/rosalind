package com.utils.bio;

import com.utils.convert.AminoAcidFromRNA;

/**
 * @author tlvlp
 */
public class TranslationOfRNAToProt {

    /**
     * Returns the protein(amino acid) sequence of an RNA sequence.
     * @requires A String containing an RNA sequence
     * @return   A String containing the Amino acid sequence that forms a protein
     * @param rna
     */
    public static String get(String rna) {
        String codon = "";
        String proteinStr = "";
        // does not handle the stop codon!
        for (int i = 0; i < rna.length() - 2; i += 3) {
            codon = rna.substring(i, i + 3);
            proteinStr = proteinStr + AminoAcidFromRNA.get(codon);
        }
        return proteinStr;
    }
}
