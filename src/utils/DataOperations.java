/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;

/**
 *
 * @author tlvlp
 */
public class DataOperations {

    public static ArrayList<String> parseByDelimiter_Str(String strIn, Character delimiter) {
        //parses the input String into an ArrayList of Strings with a given delimiter
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

    public static ArrayList<Integer> parseByDelimiter_Int(String strIn, Character delimiter) {
        //parses the input String into an ArrayList of Integers with a given delimiter
        ArrayList<Integer> outList = new ArrayList<>();
        String strColl = "";
        int listCnt = 0;
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

    public static boolean isValidSubStr(String checkStr, String baseStr) {
        /*  loop through a string to find another string
        returns true if a match is found, returns false at the end of the loop */
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

    public static String SelectLastLongestItem(ArrayList<String> longestList) {
        /* Selects the last longest item of a list of strings */
        // check if the longestList contains any items at all
        if (longestList.isEmpty()) {
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
