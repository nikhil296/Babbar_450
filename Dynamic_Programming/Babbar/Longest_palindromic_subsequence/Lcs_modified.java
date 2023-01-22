// In this method we dont actually reverse the string, but modify the LCS function
// such that, it starts comparing the 2 strings in way that --> it compares the 1'st char of S1
// and the n'th char of S2.

// Time : O(n ^ 2), Space : O(n ^ 2). we can optimize the space nad bring it down to O(n).
package Dynamic_Programming.Babbar.Longest_palindromic_subsequence;
public class Lcs_modified {
    static int lcs(int x, int y, String s1, String s2) {
        int dp[][] = new int[x+1][y+1];
        for(int i = 1; i<=x; i++) {
            for(int j = y-1; j>=0; j--) {
                if(s1.charAt(i-1) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
                }
            }
        }
        return dp[x][0];
    }
    public int longestPalinSubseq(String S) {
        // We just need to find the LCS of the given String "S" and reverse of the String "S`"
        return lcs(S.length(), S.length(), S, S);
    }
}
