package utils;

import java.io.*;
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
    public static void save(String filePath, ArrayList<String> outList) throws IOException {   
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath))) {
            for (int i=0; i<outList.size(); i++) {
                if (i<outList.size()-1) outFile.println(outList.get(i)); // if present: remove empty last line
                else outFile.print(outList.get(i));
            }
        }
    }
}