/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author tlvlp
 */
public class InputParser {
    
    public static ArrayList<String> selector(String filePath, String module) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //get the required parser from the problem class                
        String className = "problems." + module;   //the package name is hardcoded
        String fieldName = "parser";
        Class myClass = Class.forName(className);
        Field myField = myClass.getDeclaredField(fieldName);
        String parser = myField.get(null).toString();  
        
        //launche the parser selected in the Setup part of the main method
        ArrayList<String> inList = new ArrayList<>();
            switch (parser) {
                case "fasta":
                    inList = parseFasta(filePath);
                    break;
                case "default":
                default:
                    inList = parseDefault(filePath);
            }
            return inList;
        }
    
    public static ArrayList<String> parseDefault(String filePath) throws IOException {
    //stores each line of the input file as an arraylist item
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
    
    public static ArrayList<String> parseFasta(String filePath) throws IOException {        
    /* loads a FASTA file into an array list concatenating multi-line sequences.
    Every first line is a title and every second is the related sequence */
        System.out.println("Parsig with: FASTA parser");
        System.out.println("Workig directory: " + filePath);
        
        //Setting the path to the given folder under the current user's home/Documents directory        
        ArrayList<String> inList;
        ArrayList<String> inListProc;
        try (Scanner inFile = new Scanner (new FileReader(filePath))) {
            inList = parseDefault(filePath);
            inListProc = new ArrayList<>();
            //use the original parser first
        }
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
    
    public static ArrayList<String> parseFastanew_WORK_IN_PROGRESS(String filePath) throws IOException {        
    /* loads a FASTA file into an array list concatenating multi-line sequences.
    Every first line is a title and every second is the related sequence */
        System.out.println("Parsig with: FASTA parser");
        System.out.println("Input file path: " + filePath);
        
        //Setting the path to the given folder under the current user's home/Documents directory        
        ArrayList<String> inList = new ArrayList<>();
        try (final Scanner inFile = new Scanner(new FileReader(filePath))) {
            while (inFile.hasNextLine()) {
                String thisline = inFile.nextLine();
                String collector = "";
                //checking for the fasta header line symbol '>'
                if (thisline.startsWith(">")) {
                    //if the collector is not empty, add the contents to the list
                    if (!collector.isEmpty()) {
                        inList.add(collector);
                        collector = "";
                    }
                    inList.add(thisline);
                }
                // base sequence
                else {
                    collector = collector + thisline;
                    //stop collection at the end of the file
                    if (!inFile.hasNextLine()) {
                            inList.add(collector);
                            collector = "";
                    }
                }
            }
        }
        
        return inList;
    }
}
