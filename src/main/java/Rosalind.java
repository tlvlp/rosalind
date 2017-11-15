
import utils.execution.ProblemExecution;
import utils.file.InputReader;
import utils.file.OutputWriter;
import java.nio.file.*;
import java.util.*;
import com.typesafe.config.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author tlvlp
 */
public class Rosalind {
    private static final Logger log = LogManager.getLogger(Rosalind.class);

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
        log.info("Config: Rosalind problem: " + problemID);
        log.info("Config: Input file path: "+conf.getString("rosalind.input_path"));
        log.info("Config: Output file path: "+conf.getString("rosalind.output_path"));

        Path filePathIn, filePathOut;
        //Input path
        if(conf.getString("rosalind.input_path").equals("default")) {
            filePathIn = Paths.get(System.getProperty("user.home")
                    + "/Documents/rosalind_" + problemID + ".txt");
        } else {filePathIn = Paths.get(conf.getString("rosalind.input_path"));}
        //Output path
        if(conf.getString("rosalind.output_path").equals("default")) {
            filePathOut = Paths.get(System.getProperty("user.home")
                    + "/Documents/rosalind_" + problemID + "_out.txt");
        } else {filePathOut = Paths.get(conf.getString("rosalind.output_path"));}

        //Read input file
        log.info("Reading input");
        ArrayList<String> inList = InputReader.read(filePathIn);
        
        //Execute selected problem
        log.info("Running module: " + problemID);
        ArrayList<String> outList = ProblemExecution.run(problemID, inList);
        
        //Write output to file
        OutputWriter.save(filePathOut, outList);
        log.info("Run complete");
    }
}