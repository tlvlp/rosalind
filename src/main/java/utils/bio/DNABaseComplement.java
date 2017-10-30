package utils.bio;

/**
 * @author tlvlp
 */
public class DNABaseComplement {  

    /**
     * Returns the complementer sequence of a DNA sequence.
     * @requires A String with a DNA sequence.
     * @return   A String with the complementer of the original DNA sequence
     * @param strIn
     */
    public static String dnaBaseComplement(String strIn) {
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
}
