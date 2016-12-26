package com.utils.parse;

import java.util.ArrayList;
import com.utils.custom_data_types.Fasta;

/**
 *
 * @author tlvlp
 */
public class InputFastaToFastaObjects {

    /**
     * Parses the specific output of the default parser into an ArrayList of Fasta objects.
     * Optional step: This method is only used where necessary for Fasta inputs.
     * @requires ArrayList of Strings (the output of the default parser)
     * @return   ArrayList of Fasta objects
     * @param inList
     */
    public static ArrayList<Fasta> parse(ArrayList<String> inList) {
        System.out.println("Parsig with: FASTA to FASTA(Object) parser");
        ArrayList<Fasta> inListFasta = new ArrayList<>();
        for (int i = 0; i < inList.size();) {
            Fasta thisFasta = new Fasta();
            thisFasta.setHeader(inList.get(i)); //get the header
            i++;
            boolean breaker = true;
            while (breaker) {
                //collect the multi-line sequence into one string
                if (i < inList.size() - 1 && inList.get(i + 1).startsWith(">")) {
                    breaker = false; //stop collection at the end of the sequence
                }
                if (i == inList.size() - 1) {
                    breaker = false; //stop collection at the end of the input list
                }
                thisFasta.sequenceAdd(inList.get(i));
                i++;
            }
            inListFasta.add(thisFasta);
        }
        return inListFasta;
    }
}
