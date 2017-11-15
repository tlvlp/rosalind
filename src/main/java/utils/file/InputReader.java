package utils.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.nio.file.Path;

/**
 * @author tlvlp
 */
public class InputReader {
    private static final Logger log = LogManager.getLogger(InputReader.class);
     
    /**
     * Stores each line of the input file in a ArrayList of Strings.
     * Part of the main workflow: every input file is parsed with this method.
     * @requires Input txt file at the given filePath
     * @return   ArrayList of Strings where each line of the input txt 
     *           is a separate, consecutive list item.
     * @param filePath
     */
    public static ArrayList<String> read(Path filePath) {
        ArrayList<String> inList = new ArrayList<>();
        try {
            log.info("Parsig input file: " + filePath);
            Scanner inFile = new Scanner(new FileReader(filePath.toString()));
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            log.error("Input file was not found. Terminating run!",e);
            System.exit(0);
        }
        return inList;
    }
}
