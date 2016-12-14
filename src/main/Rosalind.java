package main;

import utils.*;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class Rosalind {

    /**
     * Runs one selected Rosalind problem module at a time.
     * 1. Parses an input txt file that is a problem specific dataset downloaded from Rosalind
     * 2. Runs the parsed data through the selected problem module.
     * 3. Writes the results to an output file that can be uploaded to Rosalind for evaluation.
     * 
     * @requires problemID to be set:
     *           problemID = classname in the problems package = ID in Rosalind url = ID in input txt file name
     * @requires Input txt file at filePathIn from Rosalind
     * @effects  Output txt file to filePathOut
     * 
     * @see http://rosalind.info/
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        String filePathIn, filePathOut, problemID;
        String l = System.getProperty("file.separator");
        
        /* ===================================================================== */
        
        problemID  = "lcsq";   // <---------------- THE FUN SWITCH
        
        /* ===================================================================== */
        
        /* Full path for input file */
        filePathIn = System.getProperty("user.home")+l+"Documents"+l+"rosalind_data"+l+"rosalind_" + problemID + ".txt";
        /* Full path for output file */
        filePathOut = System.getProperty("user.home")+l+"Documents"+l+"rosalind_data"+l+"rosalind_" + problemID + "_out.txt";
        
        /* Parse the input file */
        ArrayList<String> inList = FileInputParser.parseDefault(filePathIn);
        /* Execute the selected module */
        ArrayList<String> outList = ModuleExecuter.launch(problemID, inList);
        /* Save the output to file */
        FileOutputWriter.save(filePathOut, outList);
    }
}
