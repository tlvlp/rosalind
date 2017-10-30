package problems;

import java.io.IOException;
import java.util.*;
import utils.bio.ConsensusSequenceMap;

/**
 * @author tlvlp
 */
public class cons {
    
    /**
     * Returns a consensus of the input Fasta sequences with a profile map
     * @see http://rosalind.info/problems/cons
     * @param inList
     * @requires 
     * @return   
     * @throws IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        Map<Character,String> profiles = ConsensusSequenceMap.getMap(inList);
        outList.add(profiles.get('S'));
        outList.add(profiles.get('A'));
        outList.add(profiles.get('C'));
        outList.add(profiles.get('G'));
        outList.add(profiles.get('T'));
        return outList;
    }
}