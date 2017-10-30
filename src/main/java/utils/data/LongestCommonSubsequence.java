package utils.data;

/**
 * @author tlvlp
 */
public class LongestCommonSubsequence {

    /**
     * Returns the longest common subsequence of two strings
     * source(since my solution has failed):
     * @see https://rosettacode.org/wiki/Longest_common_subsequence#Dynamic_Programming_3
     * @param str1
     * @param str2
     * @requires Two strings
     * @return   A string that is the longest common subsequence of the two strings
     */
    public static String get(String str1, String str2) {
        int[][] lcsArr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            // row 0 and column 0 are initialized to 0 already
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    lcsArr[i + 1][j + 1] = lcsArr[i][j] + 1;
                } else {
                    lcsArr[i + 1][j + 1] = Math.max(lcsArr[i + 1][j], lcsArr[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder(); // read the substring out from the matrix
        for (int x = str1.length(), y = str2.length(); x != 0 && y != 0;) {
            if (lcsArr[x][y] == lcsArr[x - 1][y]) {
                x--;
            } else if (lcsArr[x][y] == lcsArr[x][y - 1]) {
                y--;
            } else {
                assert str1.charAt(x - 1) == str2.charAt(y - 1);
                sb.append(str1.charAt(x - 1));
                x--;
                y--;
            }
        }
        return sb.reverse().toString();
    }
}
