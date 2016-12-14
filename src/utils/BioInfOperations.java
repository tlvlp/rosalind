package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A collection of bio informatics operations
 * @author tlvlp
 */
public class BioInfOperations {

    /**
     * Returns a Map with the consensus sequence in Fasta format.
     * @requires An ArrayList of DNA sequences in Fasta format
     * @return   A map containing:
     *      # The consensus of the input Fasta sequences (Stored under the 'S' key)
     *      # A profile map (Stored under the 'A', 'C', 'G' and 'T' keys
     * @param inList
     * @throws IOException
     */
    public static Map<Character, String> consensusSeq_Map(ArrayList<String> inList) throws IOException {
        ArrayList<String> inListFasta = FileInputParser.parseFastaToArrayList(inList);
        Map<Character, String> profiles = new HashMap<>(); //String collectors
        profiles.put('S', ""); // S for the consensus String
        profiles.put('A', "A:");
        profiles.put('C', "C:");
        profiles.put('G', "G:");
        profiles.put('T', "T:");
        int maxSeqLen = inListFasta.get(1).length();
        for (int pos = 0; pos < maxSeqLen; pos++) {
            //loop through the char positions of a sequence (all seq length should be equal)
            Map<Character, Integer> baseColl = new HashMap<>(); //counter for ACGT bases on each position
            baseColl.put('A', 0);
            baseColl.put('C', 0);
            baseColl.put('G', 0);
            baseColl.put('T', 0);
            for (int seq = 1; seq < inListFasta.size(); seq += 2) {
                //loop through fasta sequences in inListFasta
                char base = inListFasta.get(seq).charAt(pos);
                baseColl.put(base, baseColl.get(base) + 1); //collect base occurennces
            }
            char winBase = '\u0000';
            int winCnt = 0;
            for (char key : baseColl.keySet()) {
                //add baseColl counters to profiles and select the most common to add to the consensus
                String toConcat = " " + Integer.toString(baseColl.get(key));
                profiles.put(key, profiles.get(key).concat(toConcat));
                //determine the most frequent base at this pos
                if (baseColl.get(key) > winCnt) {
                    winCnt = baseColl.get(key);
                    winBase = key;
                }
            }
            profiles.put('S', profiles.get('S') + winBase); //add the most frequent base to consensus string
        }
        return profiles;
    }

    /**
     * Returns the protein(amino acid) sequence of an RNA sequence.
     * @requires A String containing an RNA sequence
     * @return   A String containing the Amino acid sequence that forms a protein
     * @param rna
     */
    public static String translate_RNA_to_Prot(String rna) {
        String codon = "";
        String proteinStr = "";
        // does not handle the stop codon!
        for (int i = 0; i < rna.length() - 2; i += 3) {
            codon = rna.substring(i, i + 3);
            proteinStr = proteinStr + Converter.getAminoAcid_fromRNA(codon);
        }
        return proteinStr;
    }

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

    /**
     * Returns all the valid protein sequences from an RNA String.
     * @requires An RNA String
     * @return   An ArrayList of all valid protein sequence candidates from the input.
     *           Note that the complement String need to be processed as well to get all the valid results for a given RNA string.
     * @param rnaSeq
     */
    public static ArrayList<String> readingFrames_RNAtoProt(String rnaSeq) {
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
                    proteinStr = proteinStr + Converter.getAminoAcid_fromRNA(codon);
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
