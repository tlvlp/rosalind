package utils;

import java.io.*;
import java.util.*;

public class OutputWriter {
 // takes an arraylist and writes each element into the output file as a new line
    public static void save(String workDir, ArrayList<String> outList) throws IOException {
        //Setting the path to the given folder under the current user's home/Documents directory
        String outputFile = workDir;
        
        try (PrintWriter outFile = new PrintWriter(new FileWriter(outputFile))) {
            for (int i=0; i<outList.size(); i++) {
                outFile.println(outList.get(i));
            }
        }
    }
}