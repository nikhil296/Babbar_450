// Here we do an extra step to reverse the string and then perform normal LCS.
// Time : O(n ^ 2), Space : O(n ^ 2). we can optimize the space nad bring it down to O(n).
package Dynamic_Programming.Babbar.Longest_palindromic_subsequence;
public class Reverse_and_LCS {
    String reverse(String S, int i) {
        if(i == S.length()) {
            return "";
        }
        return reverse(S, i+1) + S.charAt(i);
    }
    static int lcs(int x, int y, String s1, String s2) {
        int dp[][] = new int[x+1][y+1];
        for(int i = 1; i<=x; i++) {
            for(int j = 1; j<=y; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
    public int longestPalinSubseq(String S) {
        // We just need to find the LCS of the given String "S" and reverse of the String "S`"
        String S2 = reverse(S, 0);
        return lcs(S.length(), S2.length(), S, S2);
    }
}
