// Time : (N * W), Space : O(W).
package Dynamic_Programming.Babbar.Knapsack_with_duplicate_items;
public class dp_Tabulation {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int dp[][] = new int[2][W+1];
        for(int i = 0; i<=N; i++) {
            for(int j = 0; j<=W; j++) {
                if(i == 0 || j == 0) {
                    dp[i%2][j] = 0;
                } else {
                    // we include the case where we don't include cur item.
                    dp[i%2][j] = dp[(i+1)%2][j];
                    if(wt[i-1] <= j) {
                        // since we can take the same item infinite times so.
                        // after including the current item e check if
                        // for the remaining weight = (j - wt[i-1]),
                        // do we get the maximum value with (i-1) items or (i) items.
                        // ie. "dp[(i+1)%2][j-wt[i-1]]". or. "dp[i%2][j-wt[i-1]]"
                        int incl = Math.max(val[i-1] + dp[(i+1)%2][j-wt[i-1]], 
                                            val[i-1] + dp[i%2][j-wt[i-1]]);
                        dp[i%2][j] = Math.max(dp[i%2][j], incl);
                    }
                }
            }
        }
        return dp[N%2][W];
    }
}
