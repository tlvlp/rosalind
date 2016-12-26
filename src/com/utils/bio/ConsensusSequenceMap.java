package com.utils.bio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.utils.parser.InputFastaToArraylist;

/**
 * @author tlvlp
 */
public class ConsensusSequenceMap {

    /**
     * Returns a Map with the consensus sequence in Fasta format.
     * @requires An ArrayList of DNA sequences in Fasta format
     * @return   A map containing:
     *      # The consensus of the input Fasta sequences (Stored under the 'S' key)
     *      # A profile map (Stored under the 'A', 'C', 'G' and 'T' keys
     * @param inList
     * @throws IOException
     */
    public static Map<Character, String> getMap(ArrayList<String> inList) throws IOException {
        /*
        
        It should eventually be refactored to a separate consensus sequence generator.
        Right now it is too specific to the "cons" problem.
        
        */
        ArrayList<String> inListFasta = InputFastaToArraylist.parse(inList);
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
}
