package com.utils.converter;

/**
 * @author tlvlp
 */
public class AminoAcidVarNum {

    /**
     * Returns the number of codon variations that exist for an amino acid.
     * It is used for calculating the number of possible DNA/RNA sequence variations for an amino acid (protein) sequence.
     * @requires A char containing a valid amino acid single letter code
     * @return   An integer with the number of codon variation for the given amino acid
     * @param AminoAcid
     */
    public static int get(char AminoAcid) {
        int varNum = 0;
        switch (AminoAcid) {
            case 'A':
                varNum = 4;
                break;
            case 'C':
                varNum = 2;
                break;
            case 'D':
                varNum = 2;
                break;
            case 'E':
                varNum = 2;
                break;
            case 'F':
                varNum = 2;
                break;
            case 'G':
                varNum = 4;
                break;
            case 'H':
                varNum = 2;
                break;
            case 'I':
                varNum = 3;
                break;
            case 'K':
                varNum = 2;
                break;
            case 'L':
                varNum = 6;
                break;
            case 'M':
                varNum = 1;
                break;
            case 'N':
                varNum = 2;
                break;
            case 'P':
                varNum = 4;
                break;
            case 'Q':
                varNum = 2;
                break;
            case 'R':
                varNum = 6;
                break;
            case 'S':
                varNum = 6;
                break;
            case 'T':
                varNum = 4;
                break;
            case 'V':
                varNum = 4;
                break;
            case 'W':
                varNum = 1;
                break;
            case 'Y':
                varNum = 2;
                break;
        }
        return varNum;
    }
}
