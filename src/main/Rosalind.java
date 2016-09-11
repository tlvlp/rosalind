package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import problems.*;
import utils.*;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author tlvlp
 */
public class Rosalind {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //Settings =============================================================
        String machine, module, parser;
        
        machine = "Windows"; // Windows, Linux - should be automated.
        parser = "default";    // default, fasta
        module = "subs";       // Rosalind module eg. revc, prot..
        

        //======================================================================        
        //parse input
        ArrayList<String> inList = InputParser.selector(machine, module, parser);
        
        //execute the selected module
        ArrayList<String> outList = ModulExecute.launch(machine, module, inList);
        //ArrayList<String> outList = subs.solve(inList);
        
                
        //save output to file
        OutputWriter.save(machine, module, outList);
    }
}
