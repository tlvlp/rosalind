package com.utils.data;

import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class SelectOneLongestStringFromList {

    /**
     * Selects the last longest item of a list of strings
     * @requires An ArrayList of Strings
     * @return   One from the longest Strings of the list.
     * @param longestList
     */
    public static String get(ArrayList<String> longestList) {
        if (longestList.isEmpty()) {
            // check if the longestList contains any items at all
            System.out.println("SelectLastLongest input file is empty!");
            return "SelectLastLongest input file is empty!";
        }
        String longestStr = longestList.get(0);
        for (int m = 1; m < longestList.size(); m++) {
            if (longestList.get(m).length() > longestStr.length()) {
                longestStr = longestList.get(m);
            }
        }
        return longestStr;
    }
}
