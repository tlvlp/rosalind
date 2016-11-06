
package problems;
import java.util.*;
import utils.*;
import data.*;
import java.io.IOException;

/**
 * @author tlvlp
 */
public class mprt {
    
    /**
     * Solution of the Rosalind problem in the class name
     * @param inList
     * @return
     * @throws IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();  // output list
        
      /* Set the file paths ====================================================================================== */
        
        // OS independent slash to be used in the paths
            String slash = System.getProperty("file.separator");
        //Deleted IDs: ftp://ftp.uniprot.org/pub/databases/uniprot/knowledgebase/docs/delac_sp.txt
            String delac_spPath = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"mprt"+slash+"delac_sp.txt";
        //Updated IDs: ftp://ftp.uniprot.org/pub/databases/uniprot/knowledgebase/docs/sec_ac.txt
            String sec_acPath = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"mprt"+slash+"sec_ac.txt";
        //UniProt database: (Reviewed, Swiss-Prot) http://www.uniprot.org/uniprot/?query=*&fil=reviewed%3Ayes
            String dbPath = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"mprt"+slash+"uniprot-all.fasta";
            
      /* ========================================================================================================= */
         
      /* Create a fasta object for each ID on the inList */
        ArrayList<Fasta> inListFasta = makeInListFasta(inList);
        
      /* Check for deleted IDs */
        ArrayList<String> delAcList = FileInputParser.parseDefault(delac_spPath);
        String errorDel = "Terminating run: At least one ID from the input file has been permanently removed from the UniProt database.";
        if (isIdDeleted(inListFasta, delAcList)) {
            System.out.println(errorDel);
            outList.add(errorDel);
            return outList;
        }
        
      /* Update the old UniProt IDs */
        ArrayList<String> secAcList = FileInputParser.parseDefault(sec_acPath);
        // Parse the Updates list
        Map<String, String> secAcListMap = parseUpdateIDsToMap(secAcList);
        //loop through inListFasta
        for (Fasta inListFastaItem : inListFasta) {
            String reqID = inListFastaItem.getHeader().substring(0, 6);
            if (secAcListMap.containsKey(reqID)) { //if the requested ID is on the list of updated IDs
                inListFastaItem.setAltID(secAcListMap.get(reqID)); //set the fasta object's altID to the updated ID
            }
        }
        
      /* Import the UniProt database */
        ArrayList<String> UniProtDatabaseParse = FileInputParser.parseDefault(dbPath);
        ArrayList<Fasta> UniProtDatabase = FileInputParser.parseFastaToFasta(UniProtDatabaseParse);
    
      /* Search for and add the N-Glycosylation Motif coordinates */
        inListFasta = getCoords(inListFasta, UniProtDatabase);
        
      /* Add the entries into the outlist in the requested format */
        for (int q=0; q<inListFasta.size(); q++) {
            if (!inListFasta.get(q).getCoords().isEmpty()) { //only add entries where the motif was found!
                outList.add(inListFasta.get(q).getHeader());
                outList.add(inListFasta.get(q).getCoords());
            }
        }
        
      /* Return the results */
        return outList;
    }
    
     /**
     * Crates a Fasta object list from the original string list input that only contains the headers
     * @param inList
     * @return
     */
    private static ArrayList<Fasta> makeInListFasta(ArrayList<String> inList) {
        ArrayList<Fasta> inListFasta = new ArrayList<>();
        for (int i=0; i<inList.size(); i++) {
            //initializes a new Fasta object with the inList item as the header and adds it to the list
            Fasta thisFasta = new Fasta(inList.get(i));
            inListFasta.add(thisFasta);
        }
        return inListFasta;
    }
    
    /**
     * Checks if any of the requested UniProt IDs have been deleted.
     * @param inListFasta
     */
    private static boolean isIdDeleted (ArrayList<Fasta> inListFasta, ArrayList<String> delAcList) {
        /* Remove the header and footer */
        for (int n=26; n>=0; n--) {
            delAcList.remove(n);
        }
        for (int m=0; m<5; m++) {
            delAcList.remove(delAcList.size()-1);
        }
        /* Check if the ID is on the list - if true: return with the error message */
        for (String delAcListItem : delAcList) {
            for (Fasta inListFastaItem : inListFasta) {
                String reqID = inListFastaItem.getHeader().substring(0, 6);
                if (delAcListItem.equals(reqID)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static Map<String,String> parseUpdateIDsToMap(ArrayList<String> secAcList) {
        Map<String, String> secAcListMap = new HashMap<>();
        /* Remove the header and footer */
        for (int n=29; n>=0; n--) {
            secAcList.remove(n);
        }
        secAcList.remove(secAcList.size()-1);
        /* Add the old and new IDs to a map */
        for (int i=0; i<secAcList.size()-1; i++) {
            int lineLength = secAcList.get(i).length();
            String oldID = secAcList.get(i).substring(0, 10).trim(); // first 10 characters trimmed from remaining sapces
            String newID = secAcList.get(i).substring(lineLength-10, lineLength).trim(); // last 10 characters trimmed from remaining sapces
            secAcListMap.put(oldID, newID);
        }
        return secAcListMap;
    }
    
    /**
     * Collects the coordinates of the N-Glycosylation Motif occurrences and adds them to their Fasta objects
     * @param inListFasta
     * @param UniProtDatabase
     * @return
     */
    private static ArrayList<Fasta> getCoords(ArrayList<Fasta> inListFasta, ArrayList<Fasta> UniProtDatabase) {
        //create a worklist
        ArrayList<Fasta> outListFasta = inListFasta;
        //loop through the UniProtDatabase headers
        for (int u=0; u<UniProtDatabase.size(); u++) {
            //loop through the IDs from the inList
            for (int i=0; i<outListFasta.size(); i++) {
                //parse the ID from the UniProtDatabase header or use the Updated ID if present
                String dbID = UniProtDatabase.get(u).getUniProtID();
                String inID = ""; 
                    if (outListFasta.get(i).getAltID().isEmpty()) {
                        inID = outListFasta.get(i).getHeader().substring(0,6);
                    }
                    else {
                        inID = outListFasta.get(i).getAltID();
                    }
                //if the inList ID matches the ID from the header
                if (dbID.equals(inID)) {
                    //look for the checkNGlycosylationMotif and save the coordinates. 
                    outListFasta.get(i).setCoords(checkNGlycosylationMotif(UniProtDatabase.get(u).getSequence()));
                }
            }
        }
        //List each Fasta object's details
        for (int q=0; q<outListFasta.size(); q++) {
            System.out.println("==========================");
            System.out.println("header: "+outListFasta.get(q).getHeader());
            System.out.println("altID: "+outListFasta.get(q).getAltID());
            System.out.println("coords: "+outListFasta.get(q).getCoords());
        }
        return outListFasta;
    }
    
    /**
     * Checks if the given string contains any N-Glycosylation Motif occurrences and returns the coordinates.
     * @param seq
     * @return
     */
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