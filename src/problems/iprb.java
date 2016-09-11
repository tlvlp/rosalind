/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;
import utils.InputParser;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class iprb {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        ArrayList<String> inListParsed = InputParser.parseStrToALString(inList.get(0), ' ');
        System.out.println(inListParsed);
        
        ArrayList<Integer> inListParsedInt = InputParser.parseStrToALInt(inList.get(0), ' ');
        System.out.println(inListParsedInt);
        
        System.out.println(outList);
        return outList;
    }
}