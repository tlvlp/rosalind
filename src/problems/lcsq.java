package problems;
import java.io.IOException;
import java.util.*;

/**
 * @author tlvlp
 */
public class lcsq {

    /**
     * Takes two DNA strings and
     * Returns the longest common subsequence
     * 
     * @param inList
     * @return
     * @throws java.io.IOException
     */
    public static ArrayList<String> solve(ArrayList<String> inList) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        ArrayList<String> inListFasta = utils.FileInputParser.parseFastaToArrayList(inList);
        outList.add(largestCommonSubsequence(inListFasta.get(1), inListFasta.get(3)));
        System.out.println(outList);
        return outList;
    }
    
    /**
     * Returns the largest common subsequence of two strings
     * source(since my solution has failed): 
     * https://rosettacode.org/wiki/Longest_common_subsequence#Dynamic_Programming_3
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static String largestCommonSubsequence(String str1, String str2) {
        int[][] lcsArr = new int[str1.length()+1][str2.length()+1];
        // row 0 and column 0 are initialized to 0 already
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    lcsArr[i+1][j+1] = lcsArr[i][j] + 1;
                } else {
                    lcsArr[i+1][j+1] = Math.max(lcsArr[i+1][j], lcsArr[i][j+1]);
                }
            }
        }                
        // read the substring out from the matrix
        StringBuilder sb = new StringBuilder();
        for (int x = str1.length(), y = str2.length(); x != 0 && y != 0; ) {
            if (lcsArr[x][y] == lcsArr[x-1][y]) {
                x--;
            } else if (lcsArr[x][y] == lcsArr[x][y-1]){
                y--;
            } else {
                assert str1.charAt(x-1) == str2.charAt(y-1);
                sb.append(str1.charAt(x-1));
                x--;
                y--;
            }
        }
        return sb.reverse().toString();
    }
}