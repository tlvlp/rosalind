package utils;

import java.io.*;
import java.util.*;
import data.*;
import java.nio.file.Path;

/**
 * A list of parsers
 * @author tlvlp
 */
public class FileInputParser {
     
    /**
     * Stores each line of the input file in a ArrayList of Strings
     * @requires Input txt file at the given filePath
     * @return   ArrayList of Strings where each line of the input txt is a separate, consecutive list item.
     * @param filePath
     */
    public static ArrayList<String> parseDefault(Path filePath) {
        ArrayList<String> inList = new ArrayList<>();
        try {
            System.out.println("Parsig input file with: DEFAULT parser");
            Scanner inFile = new Scanner(new FileReader(filePath.toString()));
            System.out.println("Input file:  " + filePath);                     //replaced by an error message if the file is not found.
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found on the following path:\n"+filePath+"\nTerminating run!");
            System.exit(0);
        }
        return inList;
    }
    
    /**
     * Parses the output of the parseDefault into an ArrayList of Strings.
     * @requires ArrayList of Strings (the output of the default parser)
     * @return   ArrayList of Strings where every first line is a header and every second is the related sequence
     * @param inList
     */
    public static ArrayList<String> parseFastaToArrayList(ArrayList<String> inList) {        
        System.out.println("Parsig with: FASTA to ArrayList parser");
        ArrayList<String> inListProc = new ArrayList<>();
        int cnt = 0;                                                            // copy over to the other list concatenating the multi-line sequences
        String collector = "";
        for (int i=0; i<inList.size(); i++) {
            if (inList.get(i).startsWith(">")) {                                //get the header
                inListProc.add(cnt, inList.get(i));
                cnt++;
            }
            else {                                                              //collect the multi-line sequence into one string
                collector = collector + inList.get(i);
                if (i == inList.size()-1) {                                     //stop collection at the end of the input list
                    inListProc.add(cnt, collector);
                    collector = "";
                    cnt++;
                }
                if (i < inList.size()-1 && inList.get(i+1).startsWith(">")) {   //stop collection at the end of the sequence
                    inListProc.add(cnt, collector);
                    collector = "";
                    cnt++;
                }
            }
        } 
        return inListProc;
    }
    
    /**
     * Parses the output of the parseDefault into an ArrayList of Fasta objects
     * @requires ArrayList of Strings (the output of the default parser)
     * @return   ArrayList of Fasta objects
     * @param inList
     */
    public static ArrayList<Fasta> parseFastaToFasta(ArrayList<String> inList) {        
        System.out.println("Parsig with: FASTA to FASTA(Object) parser");
        ArrayList<Fasta> inListFasta =  new ArrayList<>();
        for (int i=0; i<inList.size();) {
            Fasta thisFasta = new Fasta();
            thisFasta.setHeader(inList.get(i));                                              //get the header
            i++;
            boolean breaker = true;
            while (breaker){                                                                 //collect the multi-line sequence into one string
                if (i < inList.size()-1 && inList.get(i+1).startsWith(">")) breaker = false; //stop collection at the end of the sequence
                if (i == inList.size()-1) breaker = false;                                   //stop collection at the end of the input list
                thisFasta.sequenceAdd(inList.get(i));
                i++;
            }
            inListFasta.add(thisFasta); 
        }
        return inListFasta;
    }
}
