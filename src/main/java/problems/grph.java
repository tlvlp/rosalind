package problems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.custom_data_types.Fasta;
import utils.parser.ParseToFastaObjects;

import java.util.ArrayList;

public class grph {
    private static final Logger log = LogManager.getLogger(grph.class);
    public static ArrayList<String> solve(ArrayList<String> inList) {
        ArrayList<String> outList = new ArrayList<>();


        ArrayList<Fasta> inListFasta = ParseToFastaObjects.parse(inList);
        for(Fasta tail:inListFasta){
            String tailSeq = tail.getSequence();
            log.debug("### Tail sequence: "+tailSeq);
            if (tailSeq.length()<=2) {continue;}            //skip if shorter than 3bp
            for(Fasta head:inListFasta){
                String headSeq = head.getSequence();
                log.debug("Head sequence: "+headSeq);
                if (headSeq.length()<=2) {continue;}        //skip if shorter than 3bp
                if (tailSeq.equals(headSeq)){
                    log.debug("SKIPPING: tailSeq = headSeq "); continue;}    //skip equal sequences
                if (tailSeq.endsWith(headSeq.substring(0,3))) { //keep if overlaps by at least 3bp
                    log.debug("MATCH: overlap found for:"+ tail.getHeader().substring(1) + " " + head.getHeader().substring(1));
                    String adjacentVertices = tail.getHeader().substring(1) + " " + head.getHeader().substring(1);
                    outList.add(adjacentVertices);
                }
            }
        }
        return outList;
    }
}
