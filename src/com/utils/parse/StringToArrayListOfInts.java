package com.utils.parse;

import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class StringToArrayListOfInts {

    /**
     * Parses the input String into an ArrayList of Integers with a given delimiter.
     * @requires A string containing integers separated by a character(delimiter)
     * @return   The ArrayList of integers found in the input string
     * @param strIn
     * @param delimiter
     */
    public static ArrayList<Integer> parse(String strIn, Character delimiter) {
        ArrayList<Integer> outList = new ArrayList<>();
        String strColl = "";
        int strLen = strIn.length();
        for (int i = 0; i < strLen; ++i) {
            //if reached the delimiter or the end of the string save the currently collected string to the current list item
            if (i == strLen - 1) {
                strColl = strColl + strIn.charAt(i);
                outList.add(Integer.parseInt(strColl));
                strColl = "";
            }
            if (strIn.charAt(i) == delimiter) {
                outList.add(Integer.parseInt(strColl));
                strColl = "";
            } else {
                strColl = strColl + strIn.charAt(i);
            }
        }
        return outList;
    }   
}
