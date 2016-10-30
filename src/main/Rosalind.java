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
        String workDir, module;
        String slash = System.getProperty("file.separator");
        
        //Settings =============================================================
        
        //working directory for in/output files
        workDir = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash;
        
        //Rosalind problem code eg. revc, prot..
        module  = "gc";
        
        //======================================================================        
        
        //parse input
        ArrayList<String> inList = InputParser.selector(workDir, module);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecute.launch(module, inList);
        
        //save output to file
        OutputWriter.save(workDir, module, outList);
    }
}
