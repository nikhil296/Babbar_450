// Time : O(n ^ 2), Space : O(n).
package Dynamic_Programming.Babbar.Longest_subsequence_with_adj_diff_1;
public class dp_tabulation {
    static int longestSubsequence(int N, int A[]) {
        int dp[] = new int[N];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i<N; i++) {
            dp[i] = 1;
            for(int j = 0; j<i; j++) {
                if((int)(Math.abs(A[i] - A[j])) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
