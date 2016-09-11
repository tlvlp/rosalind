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
public class rna {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
   
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        String strIn = inList.get(0);
        String strOut = "";
        for (int i=0; i<strIn.length(); ++i) {
                switch (strIn.charAt(i)) {
                        case 'A':
                        case 'C':
                        case 'G':
                                strOut = strOut + strIn.charAt(i);
                                break;
                        case 'T':
                                strOut = strOut + 'U';
                                break;
                }
        }
        
        outList.add(strOut);
        return outList;
    }
}