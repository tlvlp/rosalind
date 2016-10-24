/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;

/**
 *
 * @author tlvlp
 */
public class dna {
    public static String parser = "default";
    /**
     * @param inList
     * @return
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {
        ArrayList<String> outList = new ArrayList<>();
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        String str = inList.get(0);

        for (int i=0; i<str.length(); ++i) {	
            switch (str.charAt(i)) {
                        case 'A':
                                ++a;
                                break;
                        case 'C':
                                ++c;
                                break;
                        case 'G':
                                ++g;
                                break;
                        case 'T':
                                ++t;
                                break;
            }
        }
        
        outList.add(a +" "+ c +" "+ g +" "+ t);
        return outList; 
    }
}
