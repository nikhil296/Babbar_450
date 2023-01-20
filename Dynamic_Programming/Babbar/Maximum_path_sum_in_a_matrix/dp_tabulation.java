// Time : O(n ^ 2), Space : O(1), since used the same matrix.
package Dynamic_Programming.Babbar.Maximum_path_sum_in_a_matrix;
public class dp_tabulation {
    static int maximumPath(int N, int Matrix[][]) {
        if(N > 1) {
            for(int i = 1; i < N; i++) {
                for(int j = 0; j<N; j++) {
                    int max = 0;
                    if(j == 0) {
                        max = Math.max(Matrix[i-1][j], Matrix[i-1][j+1]);
                    } else if(j == N-1) {
                        max = Math.max(Matrix[i-1][j-1], Matrix[i-1][j]);
                    } else {
                        max = Math.max(Matrix[i-1][j-1], Math.max(Matrix[i-1][j], Matrix[i-1][j+1]));
                    }
                    Matrix[i][j] += max;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<N; i++)
            ans = Math.max(ans, Matrix[N-1][i]);
        return ans;
    }
}
