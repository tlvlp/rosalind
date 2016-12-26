package com.utils.converter;

/**
 * @author tlvlp
 */
public class AminoAcidFromRNA {

    /**
     * Returns the amino acid of a codon form an RNA sequence.
     * @requires An RNA string of 3 characters (codon)
     * @return   The amino acid that is created frome the input codon (String of 1 character )
     * @param codon
     */
    public static String get(String codon) {
        String AminoAcid = "";
        switch (codon) {
            case "UUU":
            case "UUC":
                AminoAcid = "F";
                break;
            case "UUA":
            case "UUG":
            case "CUU":
            case "CUC":
            case "CUA":
            case "CUG":
                AminoAcid = "L";
                break;
            case "AUU":
            case "AUC":
            case "AUA":
                AminoAcid = "I";
                break;
            case "AUG":
                AminoAcid = "M"; //start codon (the most likely variant)
                break;
            case "GUU":
            case "GUC":
            case "GUA":
            case "GUG":
                AminoAcid = "V";
                break;
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
            case "AGU":
            case "AGC":
                AminoAcid = "S";
                break;
            case "CCU":
            case "CCC":
            case "CCA":
            case "CCG":
                AminoAcid = "P";
                break;
            case "ACU":
            case "ACC":
            case "ACA":
            case "ACG":
                AminoAcid = "T";
                break;
            case "GCU":
            case "GCC":
            case "GCA":
            case "GCG":
                AminoAcid = "A";
                break;
            case "UAU":
            case "UAC":
                AminoAcid = "Y";
                break;
            case "CAU":
            case "CAC":
                AminoAcid = "H";
                break;
            case "AAU":
            case "AAC":
                AminoAcid = "N";
                break;
            case "GAU":
            case "GAC":
                AminoAcid = "D";
                break;
            case "UAA":
            case "UAG":
            case "UGA":
                AminoAcid = "stop"; //stop codons
                break;
            case "CAA":
            case "CAG":
                AminoAcid = "Q";
                break;
            case "AAA":
            case "AAG":
                AminoAcid = "K";
                break;
            case "GAA":
            case "GAG":
                AminoAcid = "E";
                break;
            case "UGU":
            case "UGC":
                AminoAcid = "C";
                break;
            case "CGU":
            case "CGC":
            case "CGA":
            case "CGG":
            case "AGA":
            case "AGG":
                AminoAcid = "R";
                break;
            case "GGU":
            case "GGC":
            case "GGA":
            case "GGG":
                AminoAcid = "G";
                break;
            case "UGG":
                AminoAcid = "W";
                break;
        }
        return AminoAcid;
    }
}
