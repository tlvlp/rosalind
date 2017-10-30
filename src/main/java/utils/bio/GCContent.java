package utils.bio;

/**
 * @author tlvlp
 */
public class GCContent {

    /**
     * Calculates the GC content of a DNA or RNA sequence
     * @param dna
     * @requires A string with a DNA or RNA sequence
     * @return   A double with the GC content of the sequence
     */
    public static double get(String dna) {
        double dnaLen = dna.length();
        int gcCount = 0;
        double gcContent = 0.0;
        for (int i = 0; i < dnaLen; i++) {
            if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C') {
                gcCount++;
            }
        }
        gcContent = (gcCount / dnaLen) * 100;
        return gcContent;
    }
}
