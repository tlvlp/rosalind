/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems_inProgress;
import java.util.*;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class fibd {
    public static String parser = "default";
    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        String strIn = inList.get(0);
        String nStr ="", mStr = "";
        Boolean sep = false;
        
        for (int i=0; i< strIn.length(); ++i) {
                if (strIn.charAt(i) == ' ') sep = true;
                else if (sep) mStr = mStr + strIn.charAt(i);
                else if (!sep) nStr = nStr + strIn.charAt(i);
        }
        
        int n = Integer.parseInt(nStr);
        int m = Integer.parseInt(mStr);

        
        /*
        
        
        GIVES THE WRONG ANSWER ATM. NEED TO DEBUG THE PART BELOW :P
        
        
        */
        
        // calculating + storing population numbers in a long array
        long[] popMonth = new long[n];
        for (int i=0; i < popMonth.length; ++i) {
                //if (m <=2) the rabbits are fucked
                // while all bunnys are still alive
                if (i < m){
                        if (i <= 1) {
                                popMonth[i] = 1; 
                                System.out.println(popMonth[i]); //debug
                        }
                        if (i > 1) {
                                popMonth[i] = popMonth[i-1] + popMonth[i-2]; 
                                System.out.println(popMonth[i]); //debug
                        }
                }

                // DEATH. DEATH EVERYWHERE. - i can't figure out why it does not work with else instead of the last if
                else {
                        popMonth[i] = popMonth[i-1] + popMonth[i-2] - popMonth[i-m]; 
                        System.out.println(popMonth[i]); //debug
                }
        }

        outList.add(Long.toString(popMonth[n-1]));        
        return outList;
    }
}