package utils.parser;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.custom_data_types.Fasta;

/**
 * @author tlvlp
 */
public class ParseToFastaObjects {
    private static final Logger log = LogManager.getLogger(ParseToFastaObjects.class);

    /**
     * Parses the output of the default parser to an ArrayList of Fasta objects.
     * Optional step: This method is only used where necessary for Fasta inputs.
     * @requires ArrayList of Strings (the output of the default parser)
     * @return   ArrayList of Fasta objects
     * @param inList
     */
    public static ArrayList<Fasta> parse(ArrayList<String> inList) {
        log.info("Parsig input to FASTA objects");
        ArrayList<Fasta> inListFasta = new ArrayList<>();
        for (int i = 0; i < inList.size();) {
            Fasta thisFasta = new Fasta();
            thisFasta.setHeader(inList.get(i)); //get the header
            i++;
            boolean breaker = true;
            while (breaker) {
                //collect the multi-line sequence into one string
                if (i < inList.size() - 1 && inList.get(i + 1).startsWith(">")){
                    breaker = false; //stop collection at the end of a sequence
                }
                if (i == inList.size() - 1) {
                    breaker = false; //stop collection at the end of the input
                }
                thisFasta.sequenceAdd(inList.get(i));
                i++;
            }
            inListFasta.add(thisFasta);
        }
        return inListFasta;
    }
}
