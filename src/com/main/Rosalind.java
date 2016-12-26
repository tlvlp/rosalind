package com.main;

import com.utils.file.InputReader;
import com.utils.file.OutputWriter;
import java.nio.file.*;
import java.util.*;

/**
 * @author tlvlp
 */
public class Rosalind {

    /**
     * Runs one selected Rosalind problem module at a time.
     * 
     * It is intended to be used directly from an IDE!
     * 
     * 1. Parses an input txt file that is a problem specific dataset downloaded from Rosalind
     * 2. Runs the parsed data through the selected problem module.
     * 3. Writes the results to an output file that can be uploaded to Rosalind for evaluation.
     * 
     * @param args the command line arguments
     * @throws java.lang.Exception
     * @requires problemID to be set directly in this class:
     *           problemID = (class name in the problems package) = (ID in Rosalind url) = (ID in input txt file name)
     * @requires Input txt file at filePathIn from Rosalind
     */
    public static void main(String[] args) throws Exception {
        //======================================================================
        
        String problemID  = "dna";   // <---------------- THE FUN SWITCH
        
        //======================================================================
        
        //Full path for input file
        Path filePathIn = Paths.get(System.getProperty("user.home") + "/Documents/rosalind_data/rosalind_" + problemID + ".txt");
        //Full path for output file
        Path filePathOut = Paths.get(System.getProperty("user.home") + "/Documents/rosalind_data/rosalind_" + problemID + "_out.txt");
        
        //Main workflow
        System.out.println("Run starting with problem module: [ " + problemID+" ]");
        ArrayList<String> inList = InputReader.read(filePathIn);                       //Parse the input file
        System.out.println("Processing input..");
        ArrayList<String> outList = ProblemModuleExecution.run(problemID, inList);     //Execute the selected module
        System.out.println("Writing output to file");
        OutputWriter.save(filePathOut, outList);                                       //Save the output to file
        System.out.println("Run complete.");
    }
}