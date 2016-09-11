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
        //Settings =============================================================
        String workDir, module, parser;
        
        
        workDir = "rosalind_data";  // user~/workDir
        parser  = "default";        // default, fasta.. (utils/InputParser)
        module  = "iprb";            // Rosalind problem code eg. revc, prot..
        
        
        //======================================================================        
        //parse input
        ArrayList<String> inList = InputParser.selector(workDir, module, parser);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecute.launch(module, inList);
        
        //save output to file
        OutputWriter.save(workDir, module, outList);
    }
}
