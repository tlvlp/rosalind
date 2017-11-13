package utils.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * @author tlvlp
 */
public class OutputWriter {
    private static final Logger log = LogManager.getLogger(OutputWriter.class);
    
    /**
     * Writes the contents of an ArrayList of Strings to a txt file.
     * @requires A valid filePath where the output txt can be saved
     * @requires ArrayList whose contents will be written into the output file
     * @effects  An output txt file with the contents of the input ArrayList
     *           (one line per item in their original order)
     * @param filePath
     * @param outList
     */
    public static void save(Path filePath, ArrayList<String> outList) {
        log.info("Writing output file: " + filePath.toString());
        try (PrintWriter outFile = 
                new PrintWriter(new FileWriter(filePath.toString()))) {
            for (int i=0; i<outList.size(); i++) {
                // if present: remove empty last line
                if (i<outList.size()-1) outFile.println(outList.get(i));        
                else outFile.print(outList.get(i));
            }
        } catch (IOException e) {
            log.error("Failed to write the output file "
                               + "to the following path: "
                               +filePath
                               +"\nReason: "
                               +e.getMessage()
                               +"\nTerminating run!", e);
            System.exit(0);
        }
    }
}