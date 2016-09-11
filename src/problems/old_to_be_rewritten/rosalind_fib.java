package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_fib {
	public static void main(String[] args) throws IOException {
		
		// input and output files =================
		String inputFile ="rosalind_fib.txt";
		String outputFile="rosalind_fib_out.txt";
		//=========================================
		
		// Input and output strings 
		String strIn = "";
		String strOut = "";
		
		// read the first line of the file and store in strIn
		Scanner inFile = new Scanner (new FileReader(inputFile));
		strIn = inFile.nextLine();
		
		//=========================================
		/* notess
		f[n] = F[n-1] + F[n-2]
		rabbit paris at = 1
		n - number of months
		k - new rabbit paris per month 
		return = total number of rabbit pairs 
		*/
		
		// parsing the input string for n and k
		String nStr = "";
		String kStr = "";
		Boolean sep = false;
		for (int i=0; i< strIn.length(); ++i) {
			if (strIn.charAt(i) == ' ') sep = true;
			else if (sep) kStr = kStr + strIn.charAt(i);
			else if (!sep) nStr = nStr + strIn.charAt(i);
		}
		int n = Integer.parseInt(nStr);
		int k = Integer.parseInt(kStr);
		
		// calculating + storing population numbers in a long array
		long[] popMonth = new long[n];
		for (int i=0; i < popMonth.length; ++i) {
			if (i <= 1){
				popMonth[i] = 1; System.out.println(popMonth[i]);}
			else {
			 popMonth[i] = popMonth[i-1] + popMonth[i-2]*k; System.out.println(popMonth[i]);}
		}
		
		//=========================================
		
		strOut = Long.toString(popMonth[n-1]);

		//=========================================
		// write the output to the output file
		PrintWriter outFile = new PrintWriter(new FileWriter(outputFile));
		outFile.println(strOut);
		outFile.close();
	}
}