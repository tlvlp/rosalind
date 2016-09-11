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
public class revc {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        String strIn = inList.get(0);
        String strOut = "";
        for (int i=strIn.length()-1; i>=0; --i) {
                switch (strIn.charAt(i)) {
                        case 'A':
                                strOut = strOut + 'T';
                                break;
                        case 'C':
                                strOut = strOut + 'G';
                                break;
                        case 'G':
                                strOut = strOut + 'C';
                                break;
                        case 'T':
                                strOut = strOut + 'A';
                                break;
                }
        }
        outList.add(strOut);
        return outList;
    }
}