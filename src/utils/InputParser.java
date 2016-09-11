/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.util.*;

/**
 *
 * @author tlvlp
 */
public class InputParser {
    
    //
    public static ArrayList<String> selector(String machine, String module, String parser) throws IOException {
        ArrayList<String> inList = new ArrayList<>();
        switch (parser) {
            case "fasta":
                inList = parseFasta(machine, module);
                break;
            case "default":
            default:
                inList = parse(machine, module);
        }
        return inList;
    }
    
    //stores each line of the input file as an arraylist item
    public static ArrayList<String> parse(String machine, String module) throws IOException {
        System.out.println("Parsig with: default parser - machine: "+machine+" module: "+module);//debug
        ArrayList<String> inList = new ArrayList<String>();
        String inputFile = "";
        switch (machine) {
            case "Windows":
                System.out.println(module);
                inputFile = "c:\\Temp\\rosalind_data\\rosalind_" + module + ".txt";
                break;
            case "Linux":
                inputFile = "/tmp/rosalind_data/rosalind_" + module + ".txt";
                break;
        }
        try (final Scanner inFile = new Scanner(new FileReader(inputFile))) {
            inList = new ArrayList<>();
            while (inFile.hasNextLine()) {
                inList.add(inFile.nextLine());
            }
        }
        return inList;
    }

    /* loads a FASTA file into an array list concatenating multi-line sequences.
    Every first line is a title and every second is the related sequence */
    public static ArrayList<String> parseFasta(String machine, String module) throws IOException {
        System.out.println("\"Parsig with: parseFasta - machine: "+machine+" module: "+module);//debug
        String inputFile = null;
        switch (machine) {
            case "Windows":
                inputFile = "c:\\Temp\\rosalind_data\\rosalind_" + module + ".txt";
                break;
            case "Linux":
                inputFile = "/tmp/rosalind_data/rosalind_" + module + ".txt";
                break;
        }
        ArrayList<String> inList;
        ArrayList<String> inListProc;
        try (Scanner inFile = new Scanner (new FileReader(inputFile))) {
            inList = parse(machine, module);
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
}
