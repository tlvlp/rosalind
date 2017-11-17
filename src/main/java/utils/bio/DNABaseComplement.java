package utils.bio;

/**
 * @author tlvlp
 */
public class DNABaseComplement {  

    /**
     * Returns the complement sequence of a DNA sequence.
     * @requires A String with a DNA sequence.
     * @return   A String with the complement of the original DNA sequence
     * @param strIn
     */
    public static String getComplementSequence(String strIn) {
        String strOut = "";
        for (int i = strIn.length() - 1; i >= 0; --i) {
            switch (strIn.charAt(i)) {
                case 'A':
                    strOut = strOut + 'T';
                    break;
                case 'C':
                    strOut = strOut + 'G';
                    break;
                case 'G':
                    strOut = strOut + 'C';
                    break;
                case 'T':
                    strOut = strOut + 'A';
                    break;
            }
        }
        return strOut;
    }

    /**
     * Returns true if the two input characthers are base complements.
     */
    public static Boolean isComplementChar(Character base1, Character base2) {
        Character.toUpperCase(base1);
        Character.toUpperCase(base2);

        if( (base1=='A' && base2=='T')||
            (base1=='T' && base2=='A')||
            (base1=='G' && base2=='C')||
            (base1=='C' && base2=='G')
            ){return true;}
        else {return false;}
    }
}
