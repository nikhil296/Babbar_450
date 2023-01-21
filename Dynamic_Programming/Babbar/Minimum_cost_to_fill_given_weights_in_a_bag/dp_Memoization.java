// Time : O(n * w), Space : O(n * w).
package Dynamic_Programming.Babbar.Minimum_cost_to_fill_given_weights_in_a_bag;
import java.util.*;
public class dp_Memoization {
    int helper(int cost[], int n, int w, int dp[][]) {
        if(w==0) return 0;
	    if(n == 0) return (int)(1e9+7);
	    if(dp[n][w] != -1) {
	        return dp[n][w];
	    }
	    int excl = helper(cost, n-1, w, dp);
	    int incl = (int)(1e9+7);
	    if(n <= w && cost[n-1] != -1) {
	        incl = cost[n-1] + helper(cost, n, w-n, dp);
	    }
	    return dp[n][w] = Math.min(incl, excl);
    }
	public int minimumCost(int cost[], int N,int W) {
	    int dp[][] = new int[N+1][W+1];
	    for(int a[] : dp) {
	        Arrays.fill(a, -1);
	    }
	    int ans = helper(cost, N, W, dp);
	    return ans;
	}
}
