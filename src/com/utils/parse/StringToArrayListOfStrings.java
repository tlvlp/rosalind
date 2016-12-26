package com.utils.parse;

import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class StringToArrayListOfStrings {  

    /**
     * Parses the input String into an ArrayList of Strings with a given delimiter
     * @requires A string with substrings separated by a character(delimiter)
     * @return   The ArrayList of substrings found in the input string
     * @param strIn
     * @param delimiter
     */
    public static ArrayList<String> parse(String strIn, Character delimiter) {
        ArrayList<String> outList = new ArrayList<>();
        String strColl = "";
        int listCnt = 0;
        int strLen = strIn.length();
        for (int i = 0; i < strLen; ++i) {
            //if reached the delimiter or the end of the string save the currently collected string to the current list item
            if (i == strLen - 1) {
                strColl = strColl + strIn.charAt(i);
                outList.add(strColl);
                strColl = "";
            }
            if (strIn.charAt(i) == delimiter) {
                outList.add(strColl);
                strColl = "";
            } else {
                strColl = strColl + strIn.charAt(i);
            }
        }
        return outList;
    }
}
