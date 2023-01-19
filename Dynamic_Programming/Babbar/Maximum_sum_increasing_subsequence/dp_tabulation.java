// Time : O(n ^ 2), Space : O(n).
package Dynamic_Programming.Babbar.Maximum_sum_increasing_subsequence;
public class dp_tabulation {
    public int maxSumIS(int arr[], int n) {  
	    int dp[] = new int[n];
	    int ans = Integer.MIN_VALUE;
	    for(int i = 0; i<n; i++) {
	        dp[i] = arr[i];
	        for(int j = 0; j<i; j++) {
	            if(arr[j] < arr[i]) {
	                dp[i] = Math.max(dp[i], dp[j] + arr[i]);
 	            }
	        }
	        ans = Math.max(ans, dp[i]);
	    }
	    return ans;
	} 
}
