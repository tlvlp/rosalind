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
        String machine, module, parser;
        
        
        machine = "Windows"; // Windows, Linux - should be automated.
        parser = "default";    // default, fasta
        module = "rna";       // Rosalind module eg. revc, prot..
        
        
        //======================================================================        
        //parse input
        ArrayList<String> inList = InputParser.selector(machine, module, parser);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecute.launch(module, inList);
        
        //save output to file
        OutputWriter.save(machine, module, outList);
    }
}
