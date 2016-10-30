/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class lcsm {
    public static String parser = "fasta";
    /**
     * @param inList
     * @return
     */
    
    //main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        System.out.println("***************************************************");
        System.out.println("START solve");
        ArrayList<String> outList = new ArrayList<>();
        //create a list for the longestList strings and addig the first fasta sequence
        ArrayList<String> longestList = new ArrayList<>();
        longestList.add(inList.get(1));
        //loop through all the fasta sequences in the output (every even numbered entry is a header, every odd is a sequence)
        for (int i=3; i<inList.size(); i+=2) {            
            //get the currentFullSequence sequence
            String currentFullSequence = inList.get(i);
            System.out.println("======================================================================================================");
            System.out.println("======================================================================================================");
            System.out.println("solve currentFullSequence " + currentFullSequence);
            System.out.println("solve longestList BEFORE"+longestList);
            //collect the common subset of the previous longestList substring and the next full sequence
            longestList = CompareLongestList_to_currentFullSequence(currentFullSequence,longestList);
            System.out.println("solve longestList AFTER" + longestList);
        }        
        // return the last longest common substring (assuming that there are more than one with identical length)
        System.out.println("solve longestList FINAL" + longestList);
        
        
        String longestStr = SelectLastLongest(longestList);
        outList.add(longestStr);
        return outList;
        
    }
    
    public static ArrayList<String> CompareLongestList_to_currentFullSequence (String currentFullSequence, ArrayList<String> longestList) {
     /* 1. takes the previous longest list and loops through it
            2. compares its items to the currentFullSequence
            3. only keeps the items or the substrings of the items that can be found in the currentFullSequence
        4. returns the new longest list */
     System.out.println("======================================================================================================");   
     System.out.println("START CompareLongestList_to_currentFullSequence");
        ArrayList<String> longestListCurrent = new ArrayList<>();        
        for (int g=0; g<longestList.size(); g++) {
            System.out.println("CompareLongestList_to_currentFullSequence longestListCurrent BEFORE "+longestListCurrent);
            System.out.println("CompareLongestList_to_currentFullSequence longestList.size() BEFORE " +longestList.size());
            System.out.println("CompareLongestList_to_currentFullSequence longestList BEFORE " +longestList);
            System.out.println("CompareLongestList_to_currentFullSequence longestList.get(g) BEFORE " +longestList.get(g));
            System.out.println("CompareLongestList_to_currentFullSequence currentFullSequence BEFORE "+ currentFullSequence);
            longestListCurrent = CompareLongestListItem_to_currentFullSequence(currentFullSequence, longestList.get(g));
            System.out.println("CompareLongestList_to_currentFullSequence longestListCurrent AFTER "+longestListCurrent);
            System.out.println("CompareLongestList_to_currentFullSequence longestList.size() AFTER " +longestList.size());
            System.out.println("CompareLongestList_to_currentFullSequence longestList AFTER " +longestList);
            System.out.println("CompareLongestList_to_currentFullSequence longestList.get(g) AFTER " +longestList.get(g));
            
        }
        return longestListCurrent;
    }
    
    public static ArrayList<String> CompareLongestListItem_to_currentFullSequence (String currentFullSequence, String longestList_CurrentItem) {
    /*  2. compares its items to the currentFullSequence
        3. only keeps the items or the substrings of the items that can be found in the currentFullSequence */
        System.out.println("===========================================================");
        System.out.println("START CompareLongestListItem_to_currentFullSequence");
        System.out.println("CompareLongestListItem_to_currentFullSequence currentFullSequence BEFORE " + currentFullSequence);
        System.out.println("CompareLongestListItem_to_currentFullSequence longestList_CurrentItem BEFORE " + longestList_CurrentItem);
//a list to collect the shared subsequences
        ArrayList<String> sharedSubstringList = new ArrayList<>();
        //loop through all the substring variations of longestList
        System.out.println("CompareLongestListItem_to_currentFullSequence longestList_CurrentItem.length() " + longestList_CurrentItem.length());
        for (int i=0; i<longestList_CurrentItem.length()-1; i++) {
            for (int e=i+2; e<longestList_CurrentItem.length(); e++) {                
                System.out.println("CompareLongestListItem_to_currentFullSequence longestList_CurrentItem.length() IN FOR " + longestList_CurrentItem.length());
                //this substring variation of longestList
                String subOfLongestList_CurrentItem = longestList_CurrentItem.substring(i, e);
                System.out.println("CompareLongestListItem_to_currentFullSequence subOfLongestList_CurrentItem " + subOfLongestList_CurrentItem);
                // if this substring of longestList is a substring of currentFullSequence as well it is added to the list
                if (isValidSubStr(subOfLongestList_CurrentItem, currentFullSequence)) {
                    sharedSubstringList.add(subOfLongestList_CurrentItem);
                    System.out.println("CompareLongestListItem_to_currentFullSequence sharedSubstringList.size() "+sharedSubstringList.size());
                }  
            }
        }   
        return sharedSubstringList;
    }
    
    public static boolean isValidSubStr(String checkStr, String baseStr) {
    /*  loop through a string to find another string 
        returns true if a match is found, returns false at the end of the loop */
        System.out.println("----------------------------------------------------");
        System.out.println("START isValidSubStr");
        int checkStrLength = checkStr.length();
        int baseStrLength = baseStr.length();
        for (int j=0; j<(baseStrLength-checkStrLength+1); j++) {
            String baseStrSub = baseStr.substring(j,j+checkStrLength);
            System.out.println("isValidSubStr checkStr   "+checkStr);
            System.out.println("isValidSubStr baseStrSub "+baseStrSub);
            if (baseStrSub.equals(checkStr)) return true;            
        }
        return false;
    }
    
    public static String SelectLastLongest(ArrayList<String> longestList) {
    /* Selects the last longest item of a list of strings */
        System.out.println("START SelectLastLongest");
        // check if the longestList contains any items at all
        if (longestList.isEmpty()) {
            System.out.println("SelectLastLongest There is no shared substring!");
            return "There is no shared substring!";
        }
        String longestStr = longestList.get(0);
        for (int m=1; m<longestList.size(); m++) {
            if (longestList.get(m).length() > longestStr.length()) {
                longestStr = longestList.get(m);
            }
        }        
        System.out.println("SelectLastLongest BEWARE TEH SOLUTION longestStr: "+longestStr);
        return longestStr;
    }
}