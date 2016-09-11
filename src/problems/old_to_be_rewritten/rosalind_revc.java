package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_revc {
	public static void main(String[] args) throws IOException {
		
		// input and output files =================
		String inputFile ="rosalind_revc.txt";
		String outputFile="rosalind_revc_out.txt";
		//=========================================
		
		// Input and output strings 
		String strIn = "";
		String strOut = "";
		
		// read the first line of the file
		Scanner inFile = new Scanner (new FileReader(inputFile));
		strIn = inFile.nextLine();
		
		// loop over the input string
		for (int i=strIn.length()-1; i>=0; --i) {
			switch (strIn.charAt(i)) {
				case 'A':
					strOut = strOut + 'T';
					break;
				case 'C':
					strOut = strOut + 'G';
					break;
				case 'G':
					strOut = strOut + 'C';
					break;
				case 'T':
					strOut = strOut + 'A';
					break;
			}
		}
		// write the output to the output file
		PrintWriter outFile = new PrintWriter(new FileWriter(outputFile));
		outFile.println(strOut);
		outFile.close();
	}
}