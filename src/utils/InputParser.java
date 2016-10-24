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
    
    public static ArrayList<String> selector(String workDir, String module) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //gets the chosen parser from the problem class                
        String className = "problems." + module;   //the package name is hardcoded
        String fieldName = "parser";
        Class myClass = Class.forName(className);
        Field myField = myClass.getDeclaredField(fieldName);
        String parser = myField.get(null).toString();  
        
        //launches the parser chosen in the Setup part of the main method
        ArrayList<String> inList = new ArrayList<>();
            switch (parser) {
                case "fasta":
                    inList = parseFasta(workDir, module);
                    break;
                case "default":
                default:
                    inList = parseDefault(workDir, module);
            }
            return inList;
        }
    
    public static ArrayList<String> parseDefault(String workDir, String module) throws IOException {
    //stores each line of the input file as an arraylist item
        System.out.println("Parsig with: DEFAULT parser");
        System.out.println("Workig directory: " + workDir);
        System.out.println("Rosalind module: " + module);
        
        ArrayList<String> inList = new ArrayList<>();
        //Setting the path to the given folder under the current user's home/Documents directory
        String inputFile = workDir + "rosalind_" + module + ".txt";
        
        try (final Scanner inFile = new Scanner(new FileReader(inputFile))) {
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        }
        return inList;
    }

    public static ArrayList<String> parseFasta(String workDir, String module) throws IOException {        
    /* loads a FASTA file into an array list concatenating multi-line sequences.
    Every first line is a title and every second is the related sequence */
        System.out.println("Parsig with: FASTA parser");
        System.out.println("Workig directory: " + workDir);
        System.out.println("Rosalind module: " + module);
        
        //Setting the path to the given folder under the current user's home/Documents directory
        String inputFile = workDir + "rosalind_" + module + ".txt";
        
        ArrayList<String> inList;
        ArrayList<String> inListProc;
        try (Scanner inFile = new Scanner (new FileReader(inputFile))) {
            inList = parseDefault(workDir, module);
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
    
    
    
    
    
    /*
    
    OTHER METHODS    =======================================================
    
    */
    
    
    
    
    
    public static ArrayList<String> parseByDelimiter_Str(String strIn, Character delimiter) {
    //parses the input String into an ArrayList of Strings with a given delimiter
        ArrayList<String> outList = new ArrayList<>();
        String strColl = "";
        int listCnt = 0;     
        int strLen = strIn.length();
        
        for (int i=0; i<strLen; ++i) {
            //if reached the delimiter or the end of the string save the currently collected string to the current list item
            if (i == strLen-1) {
                strColl = strColl + strIn.charAt(i);
                outList.add(strColl);
                strColl = "";
            }if (strIn.charAt(i) == delimiter) {
                outList.add(strColl);
                strColl = "";
            } else {
                strColl = strColl + strIn.charAt(i);
            }    
        }
        return outList;
    }
    
    public static ArrayList<Integer> parseByDelimiter_Int(String strIn, Character delimiter) {
    //parses the input String into an ArrayList of Integers with a given delimiter
        ArrayList<Integer> outList = new ArrayList<>();
        String strColl = "";
        int listCnt = 0;     
        int strLen = strIn.length();
        
        for (int i=0; i<strLen; ++i) {
            //if reached the delimiter or the end of the string save the currently collected string to the current list item
            if (i == strLen-1) {
                strColl = strColl + strIn.charAt(i);
                outList.add(Integer.parseInt(strColl));
                strColl = "";
            }if (strIn.charAt(i) == delimiter) {
                outList.add(Integer.parseInt(strColl));
                strColl = "";
            } else {
                strColl = strColl + strIn.charAt(i);
            }    
        }
        return outList;
    }
}
