package utils;

import java.io.*;
import java.util.*;

public class OutputWriter {
 // takes an arraylist and writes each element into the output file as a new line
    public static void save(String machine, String modul, ArrayList<String> outList) throws IOException {
        String outputFile;
        switch (machine) {
            case "Linux":
                outputFile = "/tmp/rosalind_data/rosalind_" + modul + "_out.txt";
                 break;
            case "Windows":
            default:
                outputFile = "c:\\Temp\\rosalind_data\\rosalind_" + modul + "_out.txt";
                break;
        }
        try (PrintWriter outFile = new PrintWriter(new FileWriter(outputFile))) {
            for (int i=0; i<outList.size(); i++) {
                outFile.println(outList.get(i));
            }
        }
    }
}