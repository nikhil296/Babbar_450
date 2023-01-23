// Time : O(n), Space : O(n).
// It works for both "Even and Odd length Palindromic substring answers".
package Dynamic_Programming.Babbar.Longest_Palindromic_Substring;
public class Manachers_algorithm {
    public int longestPalindrome(String s) {
        int n = s.length();
        char str[] = new char[2*n + 1];
        for(int i = 0; i<=2*n; i++) {
            if(i%2 == 0) str[i] = '$';
            else str[i] = s.charAt(i/2);
        }
        int ans = Integer.MIN_VALUE;
        int dp[] = new int[2*n + 1];
        int l = 0, r = 0;
        for(int i = 0; i<=2*n; i++) {
            while(l>=0 && r<=2*n && str[l] == str[r]) {
                l--; r++;
            }
            dp[i] = r-l+1;
            if(r == 2*n) break;
            
            int newCenter = r + ((i%2 == 0)?1:0);
            for(int j = i+1; j<=r; j++) {
                dp[j] = Math.min(dp[i - (j-i)], 2 * (r-j) + 1);
                if(j + dp[i - (i-j)]/2 == r) {
                    newCenter = j;
                    break;
                }
            }
            i = newCenter;
            l = i - dp[i]/2;
            r = i + dp[i]/2;
        }
        for(int i = 0; i<=2*n; i++) {
            ans = Math.min(ans, dp[i]/2);
        }
        return ans;
    }
}
