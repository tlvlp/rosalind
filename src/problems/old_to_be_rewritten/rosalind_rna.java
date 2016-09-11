package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_rna {
	public static void main(String[] args) throws IOException {
		
		// input and output files =================
		String inputFile ="rosalind_rna.txt";
		String outputFile="rosalind_rna_out.txt";
		//=========================================
		
		// Input and output strings 
		String strIn = "";
		String strOut = "";
		
		// read the first line of the file
		Scanner inFile = new Scanner (new FileReader(inputFile));
		strIn = inFile.nextLine();
		
		// loop over the input string
		for (int i=0; i<strIn.length(); ++i) {
			switch (strIn.charAt(i)) {
				case 'A':
				case 'C':
				case 'G':
					strOut = strOut + strIn.charAt(i);
					break;
				case 'T':
					strOut = strOut + 'U';
					break;
			}
		}
		// write the output to the output file
		PrintWriter outFile = new PrintWriter(new FileWriter(outputFile));
		outFile.println(strOut);
		outFile.close();
	}
}