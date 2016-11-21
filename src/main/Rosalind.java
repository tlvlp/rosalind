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
        String filePathIn, filePathOut, problem;
        String l = System.getProperty("file.separator");
        
        /* Rosalind problem code eg. mprot ===================================== */
        
        problem  = "lcsq";   // <---------------- THE FUN SWITCH
        
        /* ===================================================================== */
        
        /* Full path for input file */
        filePathIn = System.getProperty("user.home")+l+"Documents"+l+"rosalind_data"+l+"rosalind_" + problem + ".txt";
        /* Full path for output file */
        filePathOut = System.getProperty("user.home")+l+"Documents"+l+"rosalind_data"+l+"rosalind_" + problem + "_out.txt";

        /* Parse the input file */
        ArrayList<String> inList = FileInputParser.parseDefault(filePathIn);
        /* Execute the selected module */
        ArrayList<String> outList = ModuleExecuter.launch(problem, inList);
        /* Save the output to file */
        FileOutputWriter.save(filePathOut, outList);
    }
}
