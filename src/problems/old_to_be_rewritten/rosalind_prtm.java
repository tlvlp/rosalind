package problems.old_to_be_rewritten;

import utils.Converter;
import java.io.*;
import java.util.*;

public class rosalind_prtm {
	public static void main(String[] args) throws IOException {
		
		// input and output files ==================================
		String inputFile = "rosalind_prtm.txt";
		String outputFile = "rosalind_prtm_out.txt";
		
		// parse input file ========================================
		ArrayList<String> inList = new ArrayList<String>();
		inList = FileHandler.parse(inputFile);

		// the goodstuff comes here ================================		
		String proteinStr = inList.get(0);
		double currentMass = 0.0;
		double allMass = 0.0;
		System.out.println("String: " + proteinStr); // debug 
		
		for (int i=0; i < proteinStr.length(); ++i){
			currentMass = Converter.getAminoAcidMass(proteinStr.charAt(i));
			allMass = allMass + currentMass;
			System.out.println(proteinStr.charAt(i) +" mass: "+ currentMass +" total:"+ allMass ); // debug 
		}
		
		// specify the output here =================================
		String strOut = Double.toString(allMass);

		// save the output to a file ===============================
		FileHandler.save(outputFile, strOut);
		
	}
}