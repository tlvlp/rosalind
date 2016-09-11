package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_hamm {
	public static void main(String[] args) throws IOException {
		
		// input and output files ==================================
		String inputFile = "rosalind_hamm.txt";
		String outputFile = "rosalind_hamm_out.txt";
		
		// parse input file ========================================
		ArrayList<String> inList = new ArrayList<String>();
		inList = FileHandler.parse(inputFile);

		// the goodstuff comes here ================================		
		int inputLength = inList.get(0).length();
		int hammingDist = 0;
		
		for (int i = 0; i < inputLength; ++i) {
			// if the two string differ in the same position, increment Hamming Distance
			if (inList.get(0).charAt(i) != inList.get(1).charAt(i))
				++hammingDist;
		}
		
		
		// specify the output here =================================
		String strOut = Integer.toString(hammingDist);

		// save the output to a file ===============================
		FileHandler.save(outputFile, strOut);
		
	}
}