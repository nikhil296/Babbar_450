// Time : O(n * log n), Space : O(n).
package Dynamic_Programming.Babbar.Array_removals;
import java.util.*;
public class sorting_approach {
    int removals(int[] arr, int n, int k) {
        if(n == 1) return 0;
        Arrays.sort(arr);
        int ans = 0;
        // below loop. runs for -> O(n) time only, its better that dp_tabulation approach.
        for(int i = 0, j = 0; i<n && j<n;) {
            if(i == j) {
                j++;
            }
            if(j<n && arr[j] - arr[i] <= k) {
                if(j-i > ans) {
                    ans = j-i;
                }
                j++;
            } else {
                i++;
            }
        }
        return (n - (ans + 1));
    }
}
