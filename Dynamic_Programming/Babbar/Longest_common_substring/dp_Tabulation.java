// Time : O(n * m), Space : O(m) or we can make it as "O(min(n, m))".
package Dynamic_Programming.Babbar.Longest_common_substring;
public class dp_Tabulation {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][] = new int[2][m+1];
        // dp[i][j] = longest substring including "i'th" & "j'th" chars of S1 and S2.
        int ans = 0;
        for(int i = 0; i<=n; i++) {
            for(int j = 0; j<=m; j++) {
                if(i == 0 || j == 0) {
                    dp[i%2][j] = 0;
                } else {
                    dp[i%2][j] = 0;
                    if(S1.charAt(i-1) == S2.charAt(j-1)) {
                        dp[i%2][j] = dp[(i+1)%2][j-1] + 1;
                        ans = Math.max(ans, dp[i%2][j]);
                    }
                }
            }
        }
        return ans;
    }
}
