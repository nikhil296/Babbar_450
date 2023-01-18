// Time : O(n), Space : O(n).
package Dynamic_Programming.Babbar.Friends_pairing_problem;
public class dp_tabulation {
    public long countFriendsPairings(int n) {
        if(n == 1) return 1;
        long mod = (long)(1e9 + 7);
        long dp[] = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++) {
            dp[i] = (dp[i-1] + (i-1) * dp[i-2]) % mod;
        }
        return dp[n];
    }
}
