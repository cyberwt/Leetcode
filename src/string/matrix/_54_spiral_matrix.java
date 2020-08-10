package string.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * 8.2 2S
 * 1. bug free还查一些
 * 记住要一直查 if(top > bottom || left>right)
 *
 * 2.且是要包含等号的，因为没有loop过的值是不算数，没有iterate过的
 *
 *
 * 理解在这个Matrix 里，从上到下，从左到右，框住的蛇形走位
 *
 * T:(N^2) S:(N)
 *
 * 6/30/20.
 */
public class _54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 大环境是个啥 上下左右环住
        List<Integer> res = new LinkedList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int top = 0, bottom = matrix.length-1;
        int left =0, right = matrix[0].length-1;

        while(top <=  bottom && left <= right){
            for(int i=left; i<= right; i++){
                res.add(matrix[top][i]);
            }

            top++;
            if(top > bottom || left>right){
                return res;
            }
            // when should we get out of the loop

            for(int i=top; i<=bottom ;i++){
                res.add(matrix[i][right]);
            }

            right--;

            if(top > bottom || left>right){
                return res;
            }
            for(int i=right; i>=left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom || left>right){
                return res;
            }
            for(int i=bottom; i>=top; i--){
                res.add(matrix[i][left]);
            }
            left++;

        }
        return res;
    }
}
