
package problems;
import data.*;
import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Pattern;

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
         
      /* Create a fasta object for each ID on the inList */
        ArrayList<Fasta> inListFasta = makeInListFasta(inList);
        
      /* Add the N-Glycosylation Motif coordinates */
        for (int i=0; i<inListFasta.size(); i++) { //loop through the IDs from the inList
            URL uniProt = new URL("http://www.uniprot.org/uniprot/"+inListFasta.get(i).getHeader().substring(0, 6)+".fasta");
            BufferedReader in = new BufferedReader(
            new InputStreamReader(uniProt.openStream()));
            in.readLine(); // skip the first line (fasta header)
            String sequence =""; String inLine = "";
            while ((inLine = in.readLine()) != null) {  //collect the sequence
                sequence = sequence.concat(inLine);
            }
            inListFasta.get(i).setCoords(checkNGlycosylationMotif(sequence)); //check for the motif
        } 
        for (int q=0; q<inListFasta.size(); q++) { //List each Fasta object's details
            System.out.println("==========================");
            System.out.println("header: "+inListFasta.get(q).getHeader());
            System.out.println("coords: "+inListFasta.get(q).getCoords());
        }
        
      /* Add the entries into the outlist in the requested format */
        for (int q=0; q<inListFasta.size(); q++) {
            if (!inListFasta.get(q).getCoords().isEmpty()) { //only add entries where the motif was found!
                outList.add(inListFasta.get(q).getHeader());
                outList.add(inListFasta.get(q).getCoords());
            }
        }
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
            Fasta thisFasta = new Fasta(inList.get(i)); //initializes a new Fasta object with the inList item as the header and adds it to the list
            inListFasta.add(thisFasta);
        }
        return inListFasta;
    }
    
    /**
     * Checks if the given string contains any N-Glycosylation Motif occurrences and returns the coordinates.
     * @param seq
     * @return
     */
    public static String checkNGlycosylationMotif (String seq) {
        String motifRegex = "N[^P][ST][^P]";
        String motifCoords = "";
        for (int i=0; i<seq.length()-3; i++) {
            String seqSub = seq.substring(i,i+4);
            if (Pattern.matches(motifRegex, seqSub)) {
                motifCoords = motifCoords.concat((i+1)+" ");  //add +1 as the Rosalind coordinates start with 1 instead of 0  
            }
        }
        return motifCoords.trim(); //return the collected coordinates (or empty) - extra spaces are trimmed
    }
}