package utils;

public class Converter {
	
    /**
     * Returns the amino acid of a codon form an RNA sequence.
     * @requires An RNA string of 3 characters (codon)
     * @return   The amino acid that is created frome the input codon (String of 1 character )
     * @param codon
     */
    public static String getAminoAcid_fromRNA(String codon) {
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

    /**
     * Returns the number of codon variations that exist for an amino acid.
     * It is used for calculating the number of possible DNA/RNA sequence variations for an amino acid (protein) sequence.
     * @requires A char containing a valid amino acid single letter code
     * @return   An integer with the number of codon variation for the given amino acid
     * @param AminoAcid
     */
    public static int getVarNum(char AminoAcid) {
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

    /**
     * Returns the mass of an amino acid
     * @requires A char containing a valid amino acid single letter code
     * @return   A double with the mass of the given amino acid
     * @param AminoAcid
     */
    public static double getAminoAcidMass(char AminoAcid) {
        double mass = 0.0;
        switch (AminoAcid) {
            case 'A':
                    mass = 71.03711;
                    break;
            case 'C':  
                    mass = 103.00919;
                    break;
            case 'D':  
                    mass = 115.02694;
                    break;
            case 'E':  
                    mass = 129.04259;
                    break;
            case 'F':  
                    mass = 147.06841;
                    break;
            case 'G':  
                    mass = 57.02146;
                    break;
            case 'H':  
                    mass = 137.05891;
                    break;
            case 'I':  
                    mass = 113.08406;
                    break;
            case 'K':  
                    mass = 128.09496;
                    break;
            case 'L':  
                    mass = 113.08406;
                    break;
            case 'M':  
                    mass = 131.04049;
                    break;
            case 'N':  
                    mass = 114.04293;
                    break;
            case 'P':  
                    mass = 97.05276;
                    break;
            case 'Q':  
                    mass = 128.05858;
                    break;
            case 'R':  
                    mass = 156.10111;
                    break;
            case 'S':  
                    mass = 87.03203;
                    break;
            case 'T':  
                    mass = 101.04768;
                    break;
            case 'V':  
                    mass = 99.06841;
                    break;
            case 'W':  
                    mass = 186.07931;
                    break;
            case 'Y':  
                    mass = 163.06333;
                    break;
        }
        return mass;
    }
}


