package com.utils.file;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * @author tlvlp
 */
public class OutputWriter {
    
    /**
     * Writes the contents of an ArrayList of Strings to a txt file.
     * @throws java.io.IOException
     * @requires A valid filePath where the output txt can be saved
     * @requires ArrayList whose contents will be written into the output file
     * @effects  An output txt file with the contents of the input ArrayList (one line per item in their original order)
     * @param filePath
     * @param outList
     */
    
    
    public static void save(Path filePath, ArrayList<String> outList) {  
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath.toString()))) {
            for (int i=0; i<outList.size(); i++) {
                if (i<outList.size()-1) outFile.println(outList.get(i));        // if present: remove empty last line
                else outFile.print(outList.get(i));
            }
        } catch (IOException e) {
            System.err.println("Failed to write the output file to the following path: "
                               +filePath+
                               "\nReason: "
                               +e.getMessage()+
                               "\nTerminating run!");
            System.exit(0);
        }
        System.out.println("Output file: " + filePath.toString());
    }
    






    /*
    public static void save(String filePath, ArrayList<String> outList) throws IOException {
        //Setting the path to the given folder under the current user's home/Documents directory        
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath))) {
            for (int i=0; i<outList.size(); i++) {
                //conditional check to avoid println creating an extra empty line at the end of the output file that Rosalind interprets as error.
                if (i<outList.size()-1) outFile.println(outList.get(i));
                else outFile.print(outList.get(i));
            }
        }
    }
    */

}