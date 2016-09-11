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
public class hamm {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
       ArrayList<String> outList = new ArrayList<>();
       
       int inputLength = inList.get(0).length();
       int hammingDist = 0;

       for (int i = 0; i < inputLength; ++i) {
               // if the two string differ in the same position, increment Hamming Distance
               if (inList.get(0).charAt(i) != inList.get(1).charAt(i))
                       ++hammingDist;
       }


       // specify the output here =================================
       outList.add(Integer.toString(hammingDist));
       return outList;
    }
}