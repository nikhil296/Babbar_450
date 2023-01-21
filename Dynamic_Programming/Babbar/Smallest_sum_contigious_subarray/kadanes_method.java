// This problem is based on "Kadane's Algorithm". 
        // its just we have to find minimum sum instead of maximum.
// Time : O(n), Space : O(1).
package Dynamic_Programming.Babbar.Smallest_sum_contigious_subarray;
public class kadanes_method {
    static int smallestSumSubarray(int a[], int size) {
        int sum = 0, minSum = Integer.MAX_VALUE;
        for(int i = 0; i<size; i++) {
            sum += a[i];
            minSum = Math.min(sum, minSum);
            if(sum > 0) sum = 0;
        }
        return minSum;
    }
}
