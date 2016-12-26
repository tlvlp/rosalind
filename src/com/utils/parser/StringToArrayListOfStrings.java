package com.utils.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static ArrayList<String> parse(String strIn, String delimiter) {
        ArrayList<String> outList = new ArrayList<>(Arrays.asList(strIn.split(delimiter)));
        return outList;
    }
}
