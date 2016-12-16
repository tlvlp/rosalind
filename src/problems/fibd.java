package problems;

import java.util.*;

/**
 * @author tlvlp
 */
public class fibd {
    
    /**
     * Mortal Fibonacci rabbits
     * http://rosalind.info/problems/fibd/
     * @param inList
     * @requires inList with one string containing two integers
     * @return   outList with a string containing a long: The number of rabbit pairs after the given number of months
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

    /**
     * Mortal Fibonacci rabbits
     * Solution found here but still can't figure out what's going on:
     * @see https://github.com/niemasd/Algorithm-Problem-Solutions/blob/master/ROSALIND%20Solutions/Bioinformatics%20Stronghold/014%20-%20FIBD%20-%20Mortal%20Fibonacci%20Rabbits/MortalFibonacciRabbits.java
     * @param months
     * @param maxlifespan
     * @return
     */
    public static long mortalFibRabbits( int months, int maxlifespan ) {
        long[] arr = new long[maxlifespan];
        arr[maxlifespan-1] = 1;
        System.out.println("arr start: "+Arrays.toString(arr));
        System.out.println("=======================");
        for(int generation = 1; generation < months; ++generation) {
          long newR = 0;
          System.out.println("FOR 1 -------------");
          for(int i = 0; i < maxlifespan-1; ++i) {
            newR += arr[i];
            System.out.println("newR"+i+": "+newR);
          }
          System.out.println("FOR 2 -------------");
          for(int i = 0; i < maxlifespan-1; ++i) {
            arr[i] = arr[i+1];
            System.out.println("arr: "+Arrays.toString(arr));
          }
          System.out.println("-------------------");

          arr[maxlifespan-1] = newR;
          System.out.println("arr cycle: "+Arrays.toString(arr));
          System.out.println("=======================");

        }
        System.out.println("arr finish: "+Arrays.toString(arr));
        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
          sum += arr[i];
        }
        return sum;
  }
}