package com.problems;

import java.io.IOException;
import java.util.*;
import com.utils.data.LongestCommonSubsequence;
import com.utils.parse.InputFastaToArraylist;

/**
 * @author tlvlp
 */
public class lcsq {

    /**
     * Returns the longest common subsequence of two DNA sequences
     * @see http://rosalind.info/problems/lcsq
     * @param inList
     * @requires inList with two DNA sequences in Fasta format
     * @return   outList with one string that is the longest common subsequence of two DNA sequences
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = InputFastaToArraylist.parse(inList);
        outList.add(LongestCommonSubsequence.get(inListFasta.get(1), inListFasta.get(3)));
        return outList;
    }
}