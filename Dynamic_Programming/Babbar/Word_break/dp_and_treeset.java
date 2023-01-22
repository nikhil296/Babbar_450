// Time : O(n^2), Space : O(length(B)).
package Dynamic_Programming.Babbar.Word_break;
import java.util.*;
public class dp_and_treeset {
    public static int wordBreak(String A, ArrayList<String> B ) {
        TreeSet<String> map = new TreeSet<>();
        for(int i = 0; i<B.size(); i++) {
            map.add(B.get(i));
        }
        int n = A.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true; // we mark true for empty string.
        for(int i = 1; i<=n; i++) {
            for(int j = 0; j<i; j++) {
                if(dp[j] && map.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if(dp[n]) return 1;
        return 0;
    }
}
