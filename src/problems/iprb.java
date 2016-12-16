package problems;
import java.util.*;
import utils.DataOperations;

/**
 * @author tlvlp
 */
public class iprb {
    
    /**
     * Returns the probability of the offspring will display a dominant phenotype
     * 
     * 
     * 
     *             !!! IN PROGRESS !!!
     * 
     * 
     * 
     * @see http://rosalind.info/problems/iprb/
     * @param inList
     * @requires 
     * @return   
     */
    public static ArrayList<String> solve(ArrayList<String> inList) {	
        ArrayList<String> outList = new ArrayList<>();
        
        ArrayList<String> inListParsed = DataOperations.parseByDelimiter_Str(inList.get(0), ' ');
        System.out.println(inListParsed);
        
        ArrayList<Integer> inListParsedInt = DataOperations.parseByDelimiter_Int(inList.get(0), ' ');
        System.out.println(inListParsedInt);
        
        System.out.println(outList);
        return outList;
    }
}