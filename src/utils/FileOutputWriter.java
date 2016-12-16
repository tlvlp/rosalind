package utils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * @author tlvlp
 */
public class FileOutputWriter {
    
    /**
     * Writes the contents of an ArrayList of Strings to a txt file.
     * @requires A valid filePath where the output txt can be saved
     * @requires ArrayList whose contents will be written into the output file
     * @effects  An output txt file with the contents of the input ArrayList (one line per item in their original order)
     * @param filePath
     * @param outList
     * @throws IOException
     */
    public static void save(Path filePath, ArrayList<String> outList) throws IOException {   
        PrintWriter outFile = new PrintWriter(new FileWriter(filePath.toString()));
        for (int i=0; i<outList.size(); i++) {
            if (i<outList.size()-1) outFile.println(outList.get(i)); // if present: remove empty last line
            else outFile.print(outList.get(i));
        }
        System.out.println("Output file: " + filePath.toString());
    }
}