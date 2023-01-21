// Time : O(n), Space : O(1).
package Dynamic_Programming.Babbar.Kadanes_algorithm;
public class order_n {
    long maxSubarraySum(int arr[], int n){
        long sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
