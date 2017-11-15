package utils.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * @author tlvlp
 */
public class SelectOneLongestStringFromList {
    private static final Logger log = LogManager.getLogger(SelectOneLongestStringFromList.class);

    /**
     * Selects the last longest item of a list of strings
     * @requires An ArrayList of Strings
     * @return   One from the longest Strings of the list.
     * @param longestList
     */
    public static String get(ArrayList<String> longestList) {
        if (longestList.isEmpty()) {
            // check if the longestList contains any items at all
            log.error("SelectLastLongest input file is empty!");
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
