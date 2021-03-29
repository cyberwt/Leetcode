package dynamicProgram.matrix;

/**
 *
 * 和303 放在一起就理解的更好了
 *
 * int[][] sum represents the area of(i,j) = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
 *
 * E1:
 * > Start from sum[r+1][c+1] because in this way, we don't need to consider when i,j =0
 *
 * E2:
 * > Method sumRegion means: everything should + 1 first
 *
 * E3:
 * > When we calculate the area, don't count the values not in there
 *
 *  =  sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1]
 *
 * T:O(1) S:O(M*N)
 *
 * 3/18/21.
 */
public class _304_range_sum_query_2d {
    int[][] sum;
    public _304_range_sum_query_2d(int[][] matrix) {
        if (matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    public int sumRegion(int r1, int c1, int r2, int c2) {
        r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
        return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
    }

}
