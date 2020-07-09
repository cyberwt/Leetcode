package string.matrix;

/**
 *
 * Error:
 *
 * 1. row          +      column
 *   top->bottom       left->right
 *
 * 2. distinguish if(left>right || top>bottom) break
 *
 *
 * T:O(N^2) S:O(N^2)
 * 7/4/20.
 */
public class _59_spiral_matrix_II {
    public int[][] generateMatrix(int n) throws  IllegalArgumentException {

        if(n <= 0){
            return null;
        }
        int[][] matrix = new int[n][n];

        int left = 0, right = n-1, top =0, bottom=n-1;
        int val =1;
        while(top <=  bottom && left <= right){

            for(int i=left; i<=right; i++){
                matrix[top][i] = val;
                val++;
            }
            top++;
            if(top > bottom || left>right){
                break;
            }

            for(int j=top; j<=bottom;j++){
                matrix[j][right] =val;
                val++;
            }
            right--;
            if(top > bottom || left>right){
                break;
            }

            for(int m=right; m>=left;m--){
                matrix[bottom][m]=val;
                val++;
            }
            bottom--;
            if(top > bottom || left>right){
                break;
            }

            for(int k=bottom; k>=top; k--){
                matrix[k][left]=val;
                val++;
            }
            left++;


        }
        return matrix;
    }

}
