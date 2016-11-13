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
public class fibd {
    /**
     * Mortal Fibonacci rabbits. All rabbits must perish
     * @param inList
     * @return
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        int sep = inList.get(0).indexOf(" ");
        int months = Integer.parseInt(inList.get(0).substring(0, sep));
        int maxLifespan = Integer.parseInt(inList.get(0).substring(sep+1, inList.get(0).length()));
        List<Long> pop = new ArrayList<>();
        pop.add(1l); //first 2 months
        pop.add(1l);
        
        /* Calculate population details */
        for (int i=2; i < months; i++) {
            if (i < maxLifespan) {
                pop.add(pop.get(i-1) + pop.get(i-2));
            } else {
                pop.add(pop.get(i-1) + pop.get(i-2) - pop.get(i-maxLifespan));
            }
        }
        System.out.println("months: "+months);
        System.out.println("maxLifespan: "+maxLifespan);
        System.out.println("population: "+pop);
        outList.add(Long.toString(pop.get(pop.size()-1)));
        return outList;
    }
}