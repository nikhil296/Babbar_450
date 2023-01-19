// Time : O(n), Space : O(n).
package Dynamic_Programming.Babbar.Max_sum_without_adjacent_2;
public class dp_tabulation {
    int findMaxSum(int arr[], int n) {
        int dp[] = new int[n+1];
        dp[1] = arr[0];
        if(n > 1) dp[2] = arr[0] + arr[1];
        if(n > 2) dp[3] = Math.max(dp[2], Math.max(arr[2] + dp[1], arr[2] + arr[1] + dp[0]));
        
        for(int i = 4; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(arr[i-1] + dp[i-2], arr[i-1] + arr[i-2] + dp[i-3]));
        }
        return dp[n];
    }
}
