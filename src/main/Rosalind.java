package main;

import utils.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * @author tlvlp
 */
public class Rosalind {

    /**
     * Runs one selected Rosalind problem module at a time.
     * 
     * This application is intended to be used directly from an IDE!
     * 
     * 1. Parses an input txt file that is a problem specific dataset downloaded from Rosalind
     * 2. Runs the parsed data through the selected problem module.
     * 3. Writes the results to an output file that can be uploaded to Rosalind for evaluation.
     * 
     * @param args the command line arguments
     * @requires problemID to be set directly in this class:
     *           problemID = (class name in the problems package) = (ID in Rosalind url) = (ID in input txt file name)
     * @requires Input txt file at filePathIn from Rosalind
     * @effects  Output txt file to filePathOut
     * 
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        //======================================================================
        
        String problemID  = "lcsq";   // <---------------- THE FUN SWITCH
        
        //======================================================================
        
        // Full path for input file
        Path filePathIn = Paths.get(System.getProperty("user.home") + "/Documents/rosalind_data/rosalind_" + problemID + ".txt");
        // Full path for output file
        Path filePathOut = Paths.get(System.getProperty("user.home") + "/Documents/rosalind_data/rosalind_" + problemID + "_out.txt");
        
        System.out.println("Run starting with: " + problemID);
        ArrayList<String> inList = FileInputParser.parseDefault(filePathIn);    // Parse the input file         - IO ERRORS ARE NOT HANDLED YET!
        ArrayList<String> outList = ModuleExecuter.launch(problemID, inList);   // Execute the selected module  - ERRORS ARE NOT HANDLED YET!
        FileOutputWriter.save(filePathOut, outList);                            // Save the output to file      - IO ERRORS ARE NOT HANDLED YET!
        System.out.println("Run complete");
    }
}