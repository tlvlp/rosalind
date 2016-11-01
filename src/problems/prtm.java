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
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class prtm {
    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        String proteinStr = inList.get(0);
        double currentMass = 0.0;
        double allMass = 0.0;
        System.out.println("String: " + proteinStr); // debug 

        for (int i=0; i < proteinStr.length(); ++i){
                currentMass = Converter.getAminoAcidMass(proteinStr.charAt(i));
                allMass = allMass + currentMass;
                System.out.println(proteinStr.charAt(i) +" mass: "+ currentMass +" total:"+ allMass ); // debug 
        }

        outList.add(Double.toString(allMass));
        
        return outList;
    }
}