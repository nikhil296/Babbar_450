// Time : O(n ^ 2), Space : O(1).
package Dynamic_Programming.Babbar.Longest_Palindromic_Substring;
public class Order_n_2_approach {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        String lps = "";
        for(int i = 0; i<n; i++) {
            // For odd length answers.
            int l = i-1, r = i+1;
            int count = 1;
            String temp = s.substring(i, i+1);
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                count += 2;
                temp = s.substring(l, r+1);
                l--; r++;
            }
            if(count > ans) {
                ans = count;
                lps = temp;
            }
            // For even length answers.
            l = i; r = i+1;
            count = 0;
            temp = "";
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                count += 2;
                temp = s.substring(l, r+1);
                l--; r++;
            }
            if(count > ans) {
                ans = count;
                lps = temp;
            }
        }
        return lps;
    }
}
