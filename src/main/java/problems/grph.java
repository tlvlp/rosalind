package problems;

import utils.custom_data_types.Fasta;
import utils.parser.InputFastaToFastaObjects;

import java.util.ArrayList;

public class grph {
    public static ArrayList<String> solve(ArrayList<String> inList) {
        ArrayList<String> outList = new ArrayList<>();


        ArrayList<Fasta> inListFasta = InputFastaToFastaObjects.parse(inList);
        for(Fasta tail:inListFasta){
            String tailSeq = tail.getSequence();
            if (tailSeq.length()<=2) {continue;}            //skip if shorter than 3bp
            for(Fasta head:inListFasta){
                String headSeq = head.getSequence();
                if (headSeq.length()<=2) {continue;}        //skip if shorter than 3bp
                if (!tailSeq.equals(headSeq)){continue;}    //skip equal sequences
                if (tailSeq.endsWith(headSeq.substring(0,3))) { //keep if overlaps by at least 3bp
                    String adjacentVertices = tail.getHeader().substring(1) + " " + head.getHeader().substring(1);
                    outList.add(adjacentVertices);
                }
            }
        }
        return outList;
    }
}
