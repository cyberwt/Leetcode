package math.expression;

/**
 *
 1. 以m,k,n为序
 if (A[i][k] != 0) 和 if (B[k][j] != 0)
 巧妙的省出了sparse matrix 的计算

 *
 * 3/30/21.
 */
public class _311_sparse_matrix_multiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}
