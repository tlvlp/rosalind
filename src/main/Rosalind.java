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
        String workDirIn, workDirOut, module;
        String slash = System.getProperty("file.separator");
        
        //Settings =============================================================
                      
        //Rosalind problem code eg. revc, prot..
        module  = "gc";
        
        //working directory for input files
        workDirIn = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + module + ".txt";
        //working directory for output files
        workDirOut = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + module + "_out.txt";
        //======================================================================        
        
        //parse input - parser selections are indicated in the problem classes
        ArrayList<String> inList = InputParser.selector(workDirIn, module);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecute.launch(module, inList);
        
        //save output to file
        OutputWriter.save(workDirOut, outList);
    }
}
