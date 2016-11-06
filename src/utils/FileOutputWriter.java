package utils;

import java.io.*;
import java.util.*;

public class FileOutputWriter {
 // takes an arraylist and writes each element into the output file as a new line
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
}