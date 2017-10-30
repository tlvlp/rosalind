package utils.file;

import java.io.*;
import java.util.*;
import java.nio.file.Path;

/**
 * @author tlvlp
 */
public class InputReader {
     
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
            System.out.println("Parsig input file with: DEFAULT parser");
            Scanner inFile = new Scanner(new FileReader(filePath.toString()));
            System.out.println("Input file:  " + filePath);  
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found on the following path:"
                    + "\n"+filePath+"\nTerminating run!");
            System.exit(0);
        }
        return inList;
    }
}
