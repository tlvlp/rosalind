/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;
import java.util.*;
import utils.*;
import java.io.IOException;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class mprt {

    /**
     * @param inList
     * @return
     */
    // main method for the solution of the rosalind problem in the class name
    
    public static String parser = "fasta";
    
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        /* import the UniProt database 
        original source is the fasta format downloaded (Reviewed, Swill-Prot) http://www.uniprot.org/uniprot/?query=*&fil=reviewed%3Ayes */
        String slash = System.getProperty("file.separator");
        ArrayList<String> UniProtDatabase = InputParser.parseFasta(System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"uniprot-all.fasta");
        
        //reparse inList to only contain the relevant IDs
        
        //loop through the UniProtDatabase headers 
            //parse the ID from the UniProtDatabase header
            //loop through the IDs from the inList
                //if the inList ID matches the ID from the header 
                    //get the checkNGlycosylationMotif for the ID
                        //if the mofif is empty leave the ID
                        //if the motif has coordinates, add the header and coordinates to the outlist
        
        
        return outList;
    }
    
    public static String checkNGlycosylationMotif (String seq) {
    /*  To allow for the presence of its varying forms, a protein motif is represented by a shorthand as follows: 
        [XY] means "either X or Y" 
        {X} means "any amino acid except X." 
        For example, the N-glycosylation motif is written as 
        N{P}[ST]{P}.*/
        String collectMotifLocations = "";
    
        //loop through the sequence to look for the N-glycosylation motif
        for (int i=0; i<seq.length()-3; i++) {
            String seqSub = seq.substring(i,i+4);
            if (seqSub.charAt(0)=='N' &&
                seqSub.charAt(1)!='P' &&
               (seqSub.charAt(2)=='S' || seqSub.charAt(2)=='T') &&
                seqSub.charAt(3)!='P') {
                    //collecting the coordinates for the motif - addig +1 as the Rosalind coordinates start with 1 instead of 0
                    collectMotifLocations = collectMotifLocations + (i+1) + " ";
            }
        }
        //return the collected coordinates (or empty) with a trimmed the last space
        return collectMotifLocations.trim();
    }
}