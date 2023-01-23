// Time : O(n), Space :O(1).
package Dynamic_Programming.Babbar.Longest_alternating_subsequence;
public class best {
    public int AlternatingaMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        int inc = 1, dec = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                // whaterver the length of decreasing subsequence is till "i-1" index, 
                // just add 1 to it.
                inc = dec + 1; // and this becomes the length of increasing subsequence.
            } else if(nums[i] < nums[i-1]) {
                // we do the above check to avoid the condition where we increase the
                // length of subsequence when (nums[i] == nums[i-1])
                
                // whaterver the length of increasing subsequence is till "i-1" index, 
                // just add 1 to it.
                dec = inc + 1; // and this becomes the length of decreasing subsequence.
            }
        }
        return Math.max(inc, dec);
    }
}
