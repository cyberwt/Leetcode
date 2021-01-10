package array.manip;

/**
 * M1:
 * 一直iterate, 但格式优雅，纯单调情况也包括，都会即使退出
 *
 * M2:
 * 二分，为什么成立，就找那个破除规矩的点
 *
 * 8/15/20.
 */
public class _162_find_peak_element {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //第一次下降
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        //一直上升
        return nums.length - 1;
    }

    public int findPeakElement2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start!=end) {
            int mid = (start + end) >>> 1;
            if(nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }else {
                end = mid-1;
            }
        }
        return start;
    }
}
