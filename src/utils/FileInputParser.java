/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.util.*;
import data.*;

/**
 * @author tlvlp
 */
public class FileInputParser {
     
    /**
     * Stores each line of the input file in a String Array List
     * @param filePath
     * @return
     * @throws IOException
     */
    public static ArrayList<String> parseDefault(String filePath) throws IOException {
    //
        System.out.println("Parsig with: DEFAULT parser");
        System.out.println("Input file: " + filePath);
        
        ArrayList<String> inList = new ArrayList<>();
        //Setting the path to the given folder under the current user's home/Documents directory
        try (final Scanner inFile = new Scanner(new FileReader(filePath))) {
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        }
        return inList;
    }
    
    /**
     * Parses the output of the parseDefault into an ArrayList of Strings. Every first line is a header and every second is the related sequence
     * @param inList
     * @return
     * @throws IOException
     */
    public static ArrayList<String> parseFastaToArrayList(ArrayList<String> inList) throws IOException {        
        System.out.println("Parsig with: FASTA to ArrayList parser");
        ArrayList<String> inListProc = new ArrayList<>();
        // copy over to the other list concatenating the multi-line sequences
        int cnt = 0;
        String collector = "";
        for (int i=0; i<inList.size(); i++) {
            // title
            if (inList.get(i).startsWith(">")) {
                inListProc.add(cnt, inList.get(i));
                cnt++;
            }
            // base sequence
            else {
                collector = collector + inList.get(i);
                //stop collection
                if (i == inList.size()-1) {
                    inListProc.add(cnt, collector);
                    collector = "";
                    cnt++;
                }
                if (i < inList.size()-1 && inList.get(i+1).startsWith(">")) {
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
     * @param inList
     * @return
     * @throws IOException
     */
    public static ArrayList<Fasta> parseFastaToFasta(ArrayList<String> inList) throws IOException {        
        System.out.println("Parsig with: FASTA to FASTA(Object) parser");
        ArrayList<Fasta> inListFasta =  new ArrayList<>();
        //collect the input to a list of fasta objects
        for (int i=0; i<inList.size();) {
            Fasta thisFasta = new Fasta();
            //add the header
            thisFasta.setHeader(inList.get(i));
            i++;
            //collect the sequence part
            boolean breaker = true;
            while (breaker){
                //break out of the collection loop if at the end of the sequence or the whole input list or 
                if (i < inList.size()-1 && inList.get(i+1).startsWith(">")) breaker = false;
                if (i == inList.size()-1) breaker = false;
                thisFasta.sequenceAdd(inList.get(i));
                i++;
            }
            //save Fasta to the list
            inListFasta.add(thisFasta); 
        }
        return inListFasta;
    }
}
