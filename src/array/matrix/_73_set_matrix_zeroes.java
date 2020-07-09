package array.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * M1:
 * Code 思路清楚，用set判定，是否要做空
 * T:O(M*N) S:O(N)
 *
 *
 * M2:
 * 用矩阵的边界代存信息
 * 它标记位直接用第一行和第一列，由于第一行和第一列不一定会被置为 0，
 * 所以需要用 isCol 变量来标记第一列是否需要置为 0，
 * 用 matrix[0][0] 标记第一行是否需要置为 0。
 * 它是将用 0 表示当前行（列）需要置 0，这一点也很巧妙，相比我上边的算法就不需要初始化标记位了。
 *
 * T:O(M*N) S:O(1)
 *
 * 7/6/20.
 */
public class _73_set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i = 0; i < R; i++) {
            //判断第 1 列是否需要置为 0
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            //找 0 的位置，将相应标记置 0
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //根据标志，将元素置 0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //判断第一行是否需要置 0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        //判断第一列是否需要置 0
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
