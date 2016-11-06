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
        String slash = System.getProperty("file.separator");
        
        //Settings =============================================================
                      
        //Rosalind problem code eg. revc, prot..
        problem  = "mprt";
        
        //full path for input file
        filePathIn = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + problem + ".txt";
        
        //full path for output file
        filePathOut = System.getProperty("user.home")+slash+"Documents"+slash+"rosalind_data"+slash+"rosalind_" + problem + "_out.txt";
        
        //======================================================================        
        
        //parse the input file
        ArrayList<String> inList = FileInputParser.parseDefault(filePathIn);
        
        //execute the selected module
        ArrayList<String> outList = ModuleExecuter.launch(problem, inList);
        
        //save the output to file
        FileOutputWriter.save(filePathOut, outList);
    }
}
