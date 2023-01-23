// Time : O(n ^ 2), Space : O(n ^ 2).
package Dynamic_Programming.Babbar.Count_Palindromic_subsequences;
public class dp_tabulation {
    long countPS(String str) {
        int n = str.length();
        long mod = (long)(1e9 + 7);
        long dp[][] = new long[n][n];
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0; i+gap < n; i++) {
                int j = i + gap;
                if(gap == 0) {
                    dp[i][j] = 1;
                } else if(gap == 1) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j))?3:2;
                } else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) ? 
                                  (dp[i][j-1] + dp[i+1][j] + 1)%mod
                                  : ((dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1])%mod + mod)%mod;
                }
            }
        }
        return dp[0][n-1] % mod;
    }
}
