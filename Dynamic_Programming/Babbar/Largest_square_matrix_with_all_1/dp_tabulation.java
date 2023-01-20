// Time : O(n * m), Space : O(1). since we used the original matrix given.
package Dynamic_Programming.Babbar.Largest_square_matrix_with_all_1;
public class dp_tabulation {
    static int maxSquare(int n, int m, int mat[][]){
        int max = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(i == 0 || j == 0) {
                    max = Math.max(mat[i][j], max);
                } else if(mat[i][j] == 1) {
                    mat[i][j] = 1 + Math.min(mat[i-1][j], Math.min(mat[i-1][j-1], mat[i][j-1]));
                    max = Math.max(mat[i][j], max);
                }
            }
        }
        return max;
    }
}
