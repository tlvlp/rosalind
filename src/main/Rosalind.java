package main;

import utils.*;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class Rosalind {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        String filePathIn, filePathOut, module;
        String slash = System.getProperty("file.separator");
        
        //Settings =============================================================
                      
        //Rosalind problem code eg. revc, prot..
        module  = "mprt";
        
        //working directory for input files
        filePathIn = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + module + ".txt";
        //working directory for output files
        filePathOut = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + module + "_out.txt";
        
        //======================================================================        
        
        //parse input - parser selections are indicated in the problem classes
        ArrayList<String> inList = InputParser.selector(filePathIn, module);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecuter.launch(module, inList);
        
        //save output to file
        OutputWriter.save(filePathOut, outList);
    }
}
