package problems.old_to_be_rewritten;

import utils.Converter;
import java.io.*;
import java.util.*;

public class rosalind_mrna {
	public static void main(String[] args) throws IOException {
		
		// input and output files ==================================
		String inputFile = "rosalind_mrna.txt";
		String outputFile = "rosalind_mrna_out.txt";
		
		// parse input file ========================================
		ArrayList<String> inList = new ArrayList<String>();
		inList = FileHandler.parse(inputFile);

		// the goodstuff comes here ================================		
		String proteinStr = inList.get(0);
		int varNum = 0;
		// already counting in the 3 variations of the stop codon. It can be done as all we do from here on is multiplication
		long allVar = 3;
		System.out.println("String: " + proteinStr); // debug 
		
		for (int i=0; i < proteinStr.length(); ++i){
			varNum = Converter.getVarNum(proteinStr.charAt(i));
			allVar = (allVar * varNum)%1000000;
			System.out.println(proteinStr.charAt(i) +" varNum: "+ varNum +" allVar:"+ allVar ); // debug 
		}
		
		// specify the output here =================================
		String strOut = Long.toString(allVar);

		// save the output to a file ===============================
		FileHandler.save(outputFile, strOut);
		
	}
}