// Time : O(n), Space : O(1).
package Dynamic_Programming.Babbar.Assembly_line_scheduling;
public class dp_tabulation_in_Order_1_space {
    public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
        int line1 = e[0] + a[0][0], line2 = e[1] + a[1][0];
        for(int i = 1; i<n; i++) {
            int first = Math.min(line1 + a[0][i], line2 + T[1][i] + a[0][i]);
            int second = Math.min(line2 + a[1][i], line1 + T[0][i] + a[1][i]);
            line1 = first;
            line2 = second;
        }
        line1 += x[0];
        line2 += x[1];
        return Math.min(line1, line2);
    }
}
