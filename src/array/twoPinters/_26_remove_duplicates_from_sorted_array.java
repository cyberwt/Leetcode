package array.twoPinters;

/**
 *  用后针，实际走，前针旨在有效的时候更新
 *
 *  Two pointers: ++pre 和 cur 的兑换
 *
 *  S: O(1) T:O(N)
 *
 *
 * 6/7/20
 */
public class _26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        // CC need to do a length check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        // j=1 as runner to move the non-duplicate stuff forward
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args){
        _26_remove_duplicates_from_sorted_array solution = new _26_remove_duplicates_from_sorted_array();
        int[] test_case = {1,1,1,1,2,2,2,3};
        int res = solution.removeDuplicates( test_case);
        System.out.println(res);
    }

}

