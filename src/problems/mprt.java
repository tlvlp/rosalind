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

    // main method for the solution of the rosalind problem in the class name  
    public static String parser = "default";
    
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> workList = new ArrayList<>();
        
        /* import the UniProt database 
        original source is the fasta format downloaded (Reviewed, Swill-Prot) http://www.uniprot.org/uniprot/?query=*&fil=reviewed%3Ayes */
        String slash = System.getProperty("file.separator");
        ArrayList<String> UniProtDatabase = InputParser.parseFasta(System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"uniprot-all.fasta");
        
        //prepare the workList
        for (int n=0; n<inList.size(); n++) {
            workList.add(inList.get(n));
            workList.add("");
        }
        
        //check the requested IDs agains the database and return with the items that have the 
        workList = getCoords(workList, UniProtDatabase);
        
        //clean the output
        for (int m=0; m<workList.size(); m+=2) {
            if (m<workList.size()-1 && !workList.get(m+1).isEmpty()) {
                outList.add(workList.get(m));
                outList.add(workList.get(m+1));
            }
        }
        return outList;
    }
    
    public static ArrayList<String> getCoords(ArrayList<String> workList, ArrayList<String> UniProtDatabase) {
        //loop through the UniProtDatabase headers
        for (int u=0; u<UniProtDatabase.size(); u+=2) {
            //parse the ID from the UniProtDatabase header
            String dbID = UniProtDatabase.get(u).substring(4,10);
            //loop through the IDs from the inList - the ID in all inList item is the first 6 char
            for (int i=0; i<workList.size(); i+=2) {
                String inID = workList.get(i).substring(0,6);
                //if the inList ID matches the ID from the header
                if (dbID.equals(inID)) {
                    //get the checkNGlycosylationMotif for the ID
                    String motifCoords = checkNGlycosylationMotif(UniProtDatabase.get(u+1));
                    //if the motif has been found add the inList header and coordinates to the workList
                    if (!motifCoords.isEmpty()) {
                        workList.set(i+1, motifCoords);
                        System.out.println(inID + " motif coordinates: " + motifCoords);
                    }
                    else System.out.println(inID + " Was not found!");
                }
            }
        }
        return workList;
    }
    
    public static String checkNGlycosylationMotif (String seq) {
    /*  
        To allow for the presence of its varying forms, a protein motif is represented by a shorthand as follows: 
        [XY] means "either X or Y" 
        {X} means "any amino acid except X." 
        For example, the N-glycosylation motif is written as 
        N{P}[ST]{P}.
    */
        String collectMotifLocations = "";
        //loop through the sequence to look for the N-glycosylation motif
        for (int i=0; i<seq.length()-3; i++) {
            String seqSub = seq.substring(i,i+4);
            if (seqSub.charAt(0)=='N' &&
                seqSub.charAt(1)!='P' &&
               (seqSub.charAt(2)=='S' || seqSub.charAt(2)=='T') &&
                seqSub.charAt(3)!='P') {
                    //collecting the coordinates for the motif - addig +1 as the Rosalind coordinates start with 1 instead of 0
                    collectMotifLocations = collectMotifLocations.concat((i+1)+" ");
            }
        }
        //return the collected coordinates (or empty) - extra spaces are trimmed
        return collectMotifLocations.trim();
    }
}