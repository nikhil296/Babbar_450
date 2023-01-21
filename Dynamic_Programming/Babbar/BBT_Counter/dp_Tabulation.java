// Time : O(h), Space : O(h).
package Dynamic_Programming.Babbar.BBT_Counter;
public class dp_Tabulation {
    static long countBT(int h){
        // A 'Balanced Binary Tree' is a tree where 
        //      ==> abs(h(left subtree) - h(right subtree)) = {-1 or 0 or 1}.
        // we don't need to worry about the number of nodes.
        long mod = (long)(1e9 + 7);
        long dp[] = new long[h + 1];
        dp[0] = dp[1] = 1; // Number of balanced binary trees with {0 or 1} nodes is = 1;
        
        for(int i = 2; i<=h; i++) {
            dp[i] = (dp[i-1] * ((2 * dp[i-2])%mod + dp[i-1])%mod) % mod;
        }
        return dp[h];
    }
}
