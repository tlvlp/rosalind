/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;
import utils.Converter;

/**
 * @author tlvlp
 */
public class mrna {
    /**
     * @param inList
     * @return
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
       
        String proteinStr = inList.get(0);
        int varNum = 0;
        // already counting in the 3 variations of the stop codon. It can be done as all we do from here on is multiplication
        long allVar = 3;

        for (int i=0; i < proteinStr.length(); ++i){
                varNum = Converter.getVarNum(proteinStr.charAt(i));
                allVar = (allVar * varNum)%1000000;
                System.out.println(proteinStr.charAt(i) +" varNum: "+ varNum +" allVar:"+ allVar ); // debug 
        }
        outList.add(Long.toString(allVar));
        return outList;
    }
}