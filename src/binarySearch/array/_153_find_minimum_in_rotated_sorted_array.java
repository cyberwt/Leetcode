package binarySearch.array;

/**
 *
 * BS
 * nums[mid] 和 nums[start] 是什么样的比较关系
 * 看图，一直在向小悬崖推进
 *
 * 为什么 start = mid +1 ，多推了一个值 ，因为这个值是个大致，本来就取不到，且是为了解决
 * start,end 无法跳出循环的尴尬
 *
 *
 * 推到最后是start 跳出来的
 *
 * 8/11/20
 */
public class _153_find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
