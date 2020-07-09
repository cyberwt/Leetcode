package binarySearch.array;

/**
 * 其实我又忘了，何时二分法能找到解
 *
 * 这种退出，其实是能直接得到的解的
 *
 *
 * 7/6/20.
 */
public class _74_search_a_2D_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分法 展平结果
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int count = row*col;
        int low = 0, high=count-1;
        int mid;
        while(low<=high){
            mid = low+ (high-low)/2;
            int r1 = mid/col;
            int c1 = mid%col;
            int val = matrix[r1][c1];
            if(val>target){
                high = mid-1;
            }else if(val < target){
                low = mid+1;
            }else{
                return true;
            }


        }
        return false;
    }

    public static void main(String[] args) {
        _74_search_a_2D_matrix solution = new _74_search_a_2D_matrix();
        int[][] nums = {{1, 2}, {3, 4}};
        boolean res = solution.searchMatrix(nums,3);
        System.out.println(res);
    }
}
