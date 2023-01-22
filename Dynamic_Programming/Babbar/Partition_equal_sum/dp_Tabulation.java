// Time : O(N * Sum), Space : O(Sum).
package Dynamic_Programming.Babbar.Partition_equal_sum;
public class dp_Tabulation {
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        if(sum % 2 == 1) 
            return 0;
        sum = sum/2;
        boolean dp[][] = new boolean[2][sum+1];
        for(int i = 0; i<=N; i++) {
            for(int j = 0; j<=sum; j++) {
                if(j == 0) {
                    // we first check for 'j', bcz we want to keep dp[0][0] = true;
                    dp[i%2][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else {
                    dp[i%2][j] = dp[(i+1)%2][j];
                    if(arr[i-1] <= j) {
                        dp[i%2][j] = dp[i%2][j] || dp[(i+1)%2][j-arr[i-1]]; 
                    }
                }
            }
        }
        if(dp[N%2][sum]) return 1;
        return 0;
    }
}
