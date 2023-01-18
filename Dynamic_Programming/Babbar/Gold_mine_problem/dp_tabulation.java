// Time : O(n * m), Space : O(n * m).
package Dynamic_Programming.Babbar.Gold_mine_problem;
public class dp_tabulation {
    static boolean isPossible(int ti, int n) {
        return (ti>=0 && ti<n);
    }
    static int maxGold(int n, int m, int M[][]) {
        int dp[][] = new int[n][m];
        int x[] = {-1, 0, 1};
        int ans = Integer.MIN_VALUE;
        for(int j = m-1; j>=0; j--) {
            for(int i = 0; i<n; i++) {
                if(j == m-1) {
                    dp[i][j] = M[i][j];
                }else {
                    for(int k = 0; k<3; k++) {
                        int ti = i + x[k];
                        if(isPossible(ti, n)) {
                            dp[i][j] = Math.max(dp[i][j], dp[ti][j+1]);
                        }
                    }
                    dp[i][j] += M[i][j];
                }
                if(j == 0) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
