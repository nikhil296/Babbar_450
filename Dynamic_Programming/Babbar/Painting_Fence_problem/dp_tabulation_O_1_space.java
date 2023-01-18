// Time : O(n), Space : O(1).
package Dynamic_Programming.Babbar.Painting_Fence_problem;
public class dp_tabulation_O_1_space {
    long countWays(int n, int k) {
        if(n == 1) return k;
        long mod = (long)(1e9 + 7);
        long lastTwoSame = k * 1;
        long lastTwoDiff = (k * (k-1)) % mod;
        long total = (lastTwoSame + lastTwoDiff) % mod;
        for(int i = 3; i<=n; i++) {
            lastTwoSame = lastTwoDiff;
            lastTwoDiff = (total * (k-1)) % mod;
            total = (lastTwoSame + lastTwoDiff) % mod;
        }
        return total;
    }
}
