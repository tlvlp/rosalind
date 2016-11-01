
package problems;
import java.util.*;
import utils.*;
import data.*;
import java.io.IOException;

/**
 * @author tlvlp
 */
// class name should correspond to the rosalind problem code eg. FIB, GC, DNA..
public class mprt {
    
    // main method for the solution of the rosalind problem in the class name  
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        
        //create the fasta list that needs to retrieve the numbers
        ArrayList<Fasta> inListFasta = makeInListFasta(inList);
        
        //update UniProt IDs that have received a second ID as the database only contains these - source: ftp://ftp.uniprot.org/pub/databases/uniprot/knowledgebase/docs/sec_ac.txt
        //parse the file
        InputParser.parseDefault(System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"mprt"+slash+"sec_ac.txt");
        //loop through inListFasta
            //check each item if the ID is present in the selcond ID list, if yes, change them to that
        
        /* import the UniProt database 
        original source of the fasta: (Reviewed, Swiss-Prot) http://www.uniprot.org/uniprot/?query=*&fil=reviewed%3Ayes */
        String slash = System.getProperty("file.separator");
        ArrayList<String> UniProtDatabaseParse = InputParser.parseDefault(System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"mprt"+slash+"uniprot-all.fasta");
        ArrayList<Fasta> UniProtDatabase = InputParser.parseFastaToFasta(UniProtDatabaseParse);
    
        //check the requested IDs agains the database and return with the items that have the 
        inListFasta = getCoords(inListFasta, UniProtDatabase);
        
        //add the relevant info into the outlist
        for (int q=0; q<inListFasta.size(); q++) {
            if (!inListFasta.get(q).getCoords().isEmpty()) {
                outList.add(inListFasta.get(q).getHeader());
                outList.add(inListFasta.get(q).getCoords());
            }
        }
        return outList;
    }
    
    public static ArrayList<Fasta> makeInListFasta(ArrayList<String> inList) {
    /* crates a fasta list from the original string list input that only contains the headers*/
        ArrayList<Fasta> inListFasta = new ArrayList<>();
        for (int i=0; i<inList.size(); i++) {
            //initializes a new Fasta object with the inList item as the header and adds it to the list
            Fasta thisFasta = new Fasta(inList.get(i));
            inListFasta.add(thisFasta);
        }
        return inListFasta;
    }
    
    public static ArrayList<Fasta> getCoords(ArrayList<Fasta> inListFasta, ArrayList<Fasta> UniProtDatabase) {
        //create a worklist
        ArrayList<Fasta> outListFasta = inListFasta;
        //loop through the UniProtDatabase headers
        for (int u=0; u<UniProtDatabase.size(); u++) {
            //loop through the IDs from the inList
            for (int i=0; i<outListFasta.size(); i++) {
                //parse the ID from the UniProtDatabase header
                String dbID = UniProtDatabase.get(u).getUniProtID();
                String inID = outListFasta.get(i).getHeader().substring(0,6);
                //if the inList ID matches the ID from the header
                if (dbID.equals(inID)) {
                    //look for the checkNGlycosylationMotif and save the coordinates. 
                    outListFasta.get(i).setCoords(checkNGlycosylationMotif(UniProtDatabase.get(u).getSequence()));
                }
            }
        }
        //debug info
        for (int q=0; q<outListFasta.size(); q++) {
            System.out.println("==========================");
            System.out.println("header: "+outListFasta.get(q).getHeader());
            System.out.println("sequence: "+outListFasta.get(q).getSequence());
            System.out.println("coords: "+outListFasta.get(q).getCoords());
        }
        return outListFasta;
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