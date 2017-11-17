package problems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.custom_data_types.Fasta;
import utils.parser.ParseToFastaObjects;
import java.util.ArrayList;
import static utils.bio.DNABaseComplement.isComplementChar;

public class revp {

    private static final Logger log = LogManager.getLogger(revp.class);
    private static ArrayList<String> outList = new ArrayList<>();
    private static String seq = "";

    public static ArrayList<String> solve(ArrayList<String> inList) {

        ArrayList<Fasta> inListFasta = ParseToFastaObjects.parse(inList);
        seq = inListFasta.get(0).getSequence();

        //check seq length to be at least 4 - terminate if less
        if(seq.length()<4) {
            log.error("Sequence is too short. Terminating run!");
            System.exit(0);
        }

        for(int pos=1; pos<=seq.length()-3; pos++){
            if(isComplementChar(seq.charAt(pos), seq.charAt(pos+1))){
                findReversePalindromes(pos,pos-1,pos+2);
            }
        }
        return outList;
    }

    /**
     * Takes the middle-left character of a palindrome and expands the search in both directions
     */
    private static void  findReversePalindromes(int pos, int left, int right) {
        if(left>=0 && right<=seq.length()-1                                   //characters are still in the sequence
                && left>=pos-5                                                //palindrome total length < 12 char
                && isComplementChar(seq.charAt(left),seq.charAt(right)) )   //the two are complement
        {
            outList.add(Integer.toString(left+1) + " " + Integer.toString(right-left+1));
            findReversePalindromes(pos,left-1, right+1);

        } else { return;}
    }
}
