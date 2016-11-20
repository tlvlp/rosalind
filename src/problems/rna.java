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
public class rna {
    /**
     * Takes a list of DNA sequences and converts them to RNA sequences
     * @param inList
     * @return
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        for (String inList1 : inList) {
            outList.add(inList1.replaceAll("T", "U"));
        }
        return outList;
    }
}