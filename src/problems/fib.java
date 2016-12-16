package problems;

import java.util.*;

/**
 * @author tlvlp
 */
public class fib {
    
    /**
     * Fibonacci's rabbits
     * @see http://rosalind.info/problems/fib
     * @param inList
     * @requires inList with one string containing two integers
     * @return   outList
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
       ArrayList<String> outList = new ArrayList<>();
       /* notess
        f[n] = F[n-1] + F[n-2]
        rabbit paris at = 1
        n - number of months
        k - new rabbit paris per month 
        return = total number of rabbit pairs 
        */
        String strIn = inList.get(0);
        String nStr = "";
        String kStr = "";
        Boolean sep = false;
        for (int i=0; i< strIn.length(); ++i) {                 //parse input integers
            if (strIn.charAt(i) == ' ') sep = true;
            else if (sep) kStr = kStr + strIn.charAt(i);
            else if (!sep) nStr = nStr + strIn.charAt(i);
        }
        int n = Integer.parseInt(nStr);
        int k = Integer.parseInt(kStr);
        long[] popMonth = new long[n];
        for (int i=0; i < popMonth.length; ++i) {
            if (i <= 1){
                popMonth[i] = 1; System.out.println(popMonth[i]);
            } else {
             popMonth[i] = popMonth[i-1] + popMonth[i-2]*k; System.out.println(popMonth[i]);
            }
        }
        outList.add(Long.toString(popMonth[n-1]));
        return outList;
    }
}