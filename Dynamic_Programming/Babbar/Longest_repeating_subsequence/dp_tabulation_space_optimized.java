// Time : O(n ^ 2), Space :O(n).
package Dynamic_Programming.Babbar.Longest_repeating_subsequence;
public class dp_tabulation_space_optimized {
    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        int dp[][] = new int[2][n+1];
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if((i != j) && (str.charAt(i-1) == str.charAt(j-1))) {
                    dp[i%2][j] = dp[(i-1) % 2][j-1] + 1;
                } else {
                    dp[i%2][j] = Math.max(dp[(i-1) % 2][j], dp[i%2][j-1]);
                }
            }
        }
        return dp[n%2][n];
    }
}
