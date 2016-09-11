package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_subs {
	public static void main(String[] args) throws IOException {
		
		// input and output files ==================================
		String inputFile = "rosalind_subs.txt";
		String outputFile = "rosalind_subs_out.txt";
		
		// parse input file ========================================
		ArrayList<String> inList = new ArrayList<String>();
		inList = FileHandler.parse(inputFile);

		// the goodstuff comes here ================================		
		String dna = inList.get(0);
		String dnaSub = inList.get(1);
		int dnaSubLen = dnaSub.length();
		String dnaSubPos = "";
		
		for (int i=0; i < dna.length()-dnaSubLen; ++i) {
			if (dna.substring(i, i + dnaSubLen).equals(dnaSub)) {
				// counting with i+1 as the first pos is 1 according to the spec. 
				dnaSubPos = dnaSubPos + " " + (i+1);
				System.out.println(dnaSubPos); //debug
			}
		}
		
		
		
		// specify the output here =================================
		String strOut = dnaSubPos;

		// save the output to a file ===============================
		FileHandler.save(outputFile, strOut);
		
	}
}