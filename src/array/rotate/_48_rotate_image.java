package array.rotate;

import java.util.Arrays;

/**
 *
 * Array Rotate: 只需要对 ！一半 的元素进行操作
 *
 * S:O(1) T: O(N)
 *
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 *
 *
 * /*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 *
 *
 *
 * 6/14/20.
 */
public class _48_rotate_image {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int tem = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tem;
            }
        }
        //!!!  loop转一半就够了
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length/2; j++){
                int tem = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = tem;
            }
        }
        return;
    }

    public static void main(String[] args){
        _48_rotate_image solution = new _48_rotate_image();
        int[][] test_case = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate( test_case);
        for (int[] row : test_case)
            System.out.println(Arrays.toString(row));
    }
}
