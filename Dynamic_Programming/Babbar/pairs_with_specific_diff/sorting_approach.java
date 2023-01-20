package Dynamic_Programming.Babbar.pairs_with_specific_diff;
import java.util.*;
public class sorting_approach {
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {
        Arrays.sort(arr);
        int sum = 0;
        for(int i = N-1; i>0; ) {
            if(arr[i] - arr[i-1] < K) {
                sum += arr[i] + arr[i-1];
                i = i-2;
            } else {
                i--;
            }
        }
        return sum;
    }
}
