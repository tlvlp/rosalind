package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class lcsq {

    /**
     * Takes two DNA strings and
     * Returnst the longes common subsequence 
     * 
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> subSeqColl = new ArrayList<>();
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        String seq1 = inListFasta.get(1);
        String seq2 = inListFasta.get(3);
        String charColl;
        char thisChar;
        int pos;
        
//        AACCTTGG
//        ACACTGTGA
        System.out.println("seq1: "+seq1);
        System.out.println("seq2: "+seq2);
        
        
        //loop through seq1
        for (int s1=0; s1<seq1.length(); s1++) {  //migth not be needed
            pos = -1;
            charColl = "";
            for (int s1var=s1; s1var<seq1.length(); s1var++) {
                thisChar = seq1.charAt(s1var);
                pos = stringSearch(seq2, thisChar, pos);
//                    System.out.print("s1:_"+s1);
//                    System.out.print("  s1var:_"+s1var);
//                    System.out.print("  thisChar:_"+thisChar);
                
                if (pos != -1) {
//                        System.out.print("  Charat_pos_"+pos+":_"+seq2.charAt(pos));
//                        System.out.println(" GET!");
                    charColl = charColl + thisChar;
                } else {
                    subSeqColl.add(charColl);
//                        System.out.print("  Charat_pos_"+pos+":_-1");
//                        System.out.println(" BREAK ===================");
                    break;
                }
            }
        }
        System.out.println(subSeqColl);
                
        
        String longest ="";                         //get the longest entry
        for(String li : subSeqColl) {
            if (li.length()>longest.length()) {
                longest = li;
            }
        }
        
        outList.add(longest);
        System.out.println("outList: "+outList);
        return outList;
    }
    
    /**
     * Loops through a string from a start position and looks for the first occurence of a character
     * Returns the position of the character or -1 if not found
     * 
     * @param str
     * @param checkChar
     * @param startPos
     * @return
     */
    public static Integer stringSearch(String str, Character checkChar, Integer startPos) {
        for (int i = startPos+1; i < str.length(); i++) {
            if (str.charAt(i) == checkChar) {
               return i; 
            }
        }
        return -1;
    }
}