package problems.old_to_be_rewritten;

import utils.Converter;
import java.io.*;
import java.util.*;

public class rosalind_prot {
	public static void main(String[] args) throws IOException {
		
		// input and output files ==================================
		String inputFile = "rosalind_prot.txt";
		String outputFile = "rosalind_prot_out.txt";
		
		// parse input file ========================================
		ArrayList<String> inList = new ArrayList<String>();
		inList = FileHandler.parse(inputFile);

		// the goodstuff comes here ================================		
		
		String dna = inList.get(0);
		String codon = "";
		String proteinStr = "";
		
		// does not handle the stop codon!
		for (int i=0; i < dna.length()-3; i +=3 ){
			codon = dna.substring(i,i+3);
			proteinStr = proteinStr + Converter.getAminoAcid(codon);
		}
		
		// specify the output here =================================
		String strOut = proteinStr;

		// save the output to a file ===============================
		FileHandler.save(outputFile, strOut);
		
	}
}