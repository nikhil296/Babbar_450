// Time : O(n), Space : O(n).
package Dynamic_Programming.Babbar.Maximum_diff_of_0s_nd_1s_in_string;
public class dp {
    int maxSubstring(String S) {
        int max = 0, cur_sum = 0;
        for(int i = 0; i<S.length(); i++) {
            if(S.charAt(i) == '1') {
                cur_sum -= 1; 
            } else {
                cur_sum += 1;
            }
            if(cur_sum < 0) cur_sum = 0;
            max = Math.max(cur_sum, max);
        }
        return (max == 0) ? -1 : max;
    }
}
