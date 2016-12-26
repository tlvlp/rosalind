package com.utils.parse;

import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class InputFastaToArraylist {

    /**
     * Parses the specific output of the default parser into an ArrayList of Strings.
     * Optional step: This method is only used where necessary for Fasta inputs
     * @requires ArrayList of Strings (the output of the default parser)
     * @return   ArrayList of Strings where every first line is a header and every second is the related sequence
     * @param inList
     */
    public static ArrayList<String> parse(ArrayList<String> inList) {
        System.out.println("Parsig with: FASTA to ArrayList parser");
        ArrayList<String> inListProc = new ArrayList<>();
        int cnt = 0; // copy over to the other list concatenating the multi-line sequences
        String collector = "";
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i).startsWith(">")) {
                //get the header
                inListProc.add(cnt, inList.get(i));
                cnt++;
            } else {
                //collect the multi-line sequence into one string
                collector = collector + inList.get(i);
                if (i == inList.size() - 1) {
                    //stop collection at the end of the input list
                    inListProc.add(cnt, collector);
                    collector = "";
                    cnt++;
                }
                if (i < inList.size() - 1 && inList.get(i + 1).startsWith(">")) {
                    //stop collection at the end of the sequence
                    inListProc.add(cnt, collector);
                    collector = "";
                    cnt++;
                }
            }
        }
        return inListProc;
    }
    
}
