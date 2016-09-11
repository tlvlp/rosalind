package problems.old_to_be_rewritten;

import java.io.*;
import java.util.*;

public class rosalind_fibd {
	public static void main(String[] args) throws IOException {
		
		// input and output files =================
		String inputFile ="rosalind_fibd.txt";
		String outputFile="rosalind_fibd_out.txt";
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
		rabbit paris at start = 1
		n - number of months
		m - rabits die after m month 
		return = total number of rabbit pairs after n months
		*/
		
		// parsing the input string for n and m
		String nStr = "";
		String mStr = "";
		Boolean sep = false;
		for (int i=0; i< strIn.length(); ++i) {
			if (strIn.charAt(i) == ' ') sep = true;
			else if (sep) mStr = mStr + strIn.charAt(i);
			else if (!sep) nStr = nStr + strIn.charAt(i);
		}
		int n = Integer.parseInt(nStr);
		int m = Integer.parseInt(mStr);
		
		// calculating + storing population numbers in a long array
		long[] popMonth = new long[n];
		for (int i=0; i < popMonth.length; ++i) {
			//if (m <=2) the rabbits are fucked
			// while all bunnys are still alive
			if (i < m){
				if (i <= 1) {
					popMonth[i] = 1; 
					System.out.println(popMonth[i]); //debug
				}
				if (i > 1) {
					popMonth[i] = popMonth[i-1] + popMonth[i-2]; 
					System.out.println(popMonth[i]); //debug
				}
			}
		
			// DEATH. DEATH EVERYWHERE. - i can't figure out why it does not work with else instead of the last if
			else {
				popMonth[i] = popMonth[i-1] + popMonth[i-2] - popMonth[i-m]; 
				System.out.println(popMonth[i]); //debug
			}
		}
		
		//=========================================
		
		strOut = Long.toString(popMonth[n-1]);

		//=========================================
		// write the result to the output file and save it
		PrintWriter outFile = new PrintWriter(new FileWriter(outputFile));
		outFile.println(strOut);
		outFile.close();
	}
}