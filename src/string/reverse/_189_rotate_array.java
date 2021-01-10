package string.reverse;

/**
 * 找规律，能不能构成你要的字符串
 * 这一半rotate, 另一半再rotate
 * 再全局rotete
 * Created by weitong on 8/19/20.
 */
public class _189_rotate_array {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
