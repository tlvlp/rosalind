package utils;

import java.io.*;
import java.util.*;

/**
 * Takes an ArrayList and writes each element into the output file as a new line
 * @author tlvlp
 */
public class FileOutputWriter {
    public static void save(String filePath, ArrayList<String> outList) throws IOException {   
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath))) {
            for (int i=0; i<outList.size(); i++) {
                if (i<outList.size()-1) outFile.println(outList.get(i)); // if present: remove empty last line
                else outFile.print(outList.get(i));
            }
        }
    }
}