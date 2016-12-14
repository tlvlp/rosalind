package utils;

import java.util.ArrayList;

/**
 * A collection of data operations
 * @author tlvlp
 */
public class DataOperations {

    /**
     * Parses the input String into an ArrayList of Strings with a given delimiter
     * @requires A string with substrings separated by a character(delimiter)
     * @return   The ArrayList of substrings found in the input string
     * @param strIn
     * @param delimiter
     */
    public static ArrayList<String> parseByDelimiter_Str(String strIn, Character delimiter) {
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

    /**
     * Parses the input String into an ArrayList of Integers with a given delimiter.
     * @requires A string containing integers separated by a character(delimiter)
     * @return   The ArrayList of integers found in the input string
     * @param strIn
     * @param delimiter
     */
    public static ArrayList<Integer> parseByDelimiter_Int(String strIn, Character delimiter) {
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

    /**
     * Loops through a string(baseStr) to find another string(checkStr)
     * @requires Two Strings
     * @return   True if a match is found, returns false at the end of the loop
     * @param checkStr
     * @param baseStr
     */
    public static boolean isValidSubStr(String checkStr, String baseStr) {
        int checkStrLength = checkStr.length();
        int baseStrLength = baseStr.length();
        for (int j = 0; j < (baseStrLength - checkStrLength + 1); j++) {
            String baseStrSub = baseStr.substring(j, j + checkStrLength);
            if (baseStrSub.equals(checkStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Selects the last longest item of a list of strings
     * @requires An ArrayList of Strings
     * @return   One from the longest Strings of the list.
     * @param longestList
     */
    public static String SelectOneLongestItem(ArrayList<String> longestList) {
        if (longestList.isEmpty()) {    // check if the longestList contains any items at all
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
