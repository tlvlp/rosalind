import utils.execution.ProblemExecution;
import utils.file.InputReader;
import utils.file.OutputWriter;
import java.nio.file.*;
import java.util.*;
import com.typesafe.config.*;

/**
 * @author tlvlp
 */
public class Rosalind {

    /**
     * Runs one selected Rosalind problem module at a time.
     * 
     * It is intended to be used directly from an IDE!
     *
     * 1. Reads the resources/application.conf configuration file
     * 2. Parses an input txt file that is a problem specific dataset
     *    downloaded from Rosalind
     * 3. Runs the parsed data through the selected problem module.
     * 4. Writes the results to an output file
     *    that can be uploaded to Rosalind for evaluation.
     */
    public static void main(String[] args) throws Exception {

        //Read problem id from application.conf
        Config conf = ConfigFactory.load();
        String problemID  = conf.getString("rosalind.problem_id");

        Path filePathIn, filePathOut;

        System.out.println("inpath: "+conf.getString("rosalind.input_path"));
        System.out.println("outpath: "+conf.getString("rosalind.output_path"));
        
        //Input path
        if(conf.getString("rosalind.input_path").equals("default")) {
            filePathIn = Paths.get(System.getProperty("user.home")
                    + "/Documents/rosalind_data/rosalind_" + problemID + ".txt");
        } else {filePathIn = Paths.get(conf.getString("rosalind.input_path"));}


        //Output path
        if(conf.getString("rosalind.output_path").equals("default")) {
            filePathOut = Paths.get(System.getProperty("user.home")
                    + "/Documents/rosalind_data/rosalind_" + problemID + "_out.txt");
        } else {filePathOut = Paths.get(conf.getString("rosalind.output_path"));}


        System.out.println("Run starting with problem module: [ " 
                           + problemID+" ]");
        
        //Read input file
        ArrayList<String> inList = InputReader.read(filePathIn);
        System.out.println("Reading input..");
        
        //Execute selected problem
        ArrayList<String> outList = ProblemExecution.run(problemID, inList);
        System.out.println("Writing output to file");
        
        //Write output to file
        OutputWriter.save(filePathOut, outList);                                       
        System.out.println("Run complete.");
    }
}