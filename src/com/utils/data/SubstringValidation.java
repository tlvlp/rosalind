package com.utils.data;

/**
 * @author tlvlp
 */
public class SubstringValidation {  

    /**
     * Loops through a string(baseStr) to find another string(checkStr)
     * @requires Two Strings
     * @return   True if a match is found, returns false at the end of the loop
     * @param checkStr
     * @param baseStr
     */
    public static boolean check(String checkStr, String baseStr) {
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
}
