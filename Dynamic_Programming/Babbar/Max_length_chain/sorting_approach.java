// Time : O(n log n), Space : O(1).
// Same as "Activity Selection Problem".
package Dynamic_Programming.Babbar.Max_length_chain;
import java.util.*;
public class sorting_approach {
    class Pair {
        int x, y;
        Pair(int a, int b) {
            x = a; y = b;
        }
    } 
    int maxChainLength(Pair arr[], int n) {
        Arrays.sort(arr, (Pair a, Pair b)->(a.y - b.y));
        int j = 0, len = 1;
        for(int i = 1; i<n; i++) {
            if(arr[i].x > arr[j].y) {
                j = i;
                len++;
            }
        }
        return len;
    }
}
