package array.count;

import java.util.Arrays;

/**
 * M1: 直接两遍loop, 记下 zero_count one_count
 *
 * M2: Dp 初始附dummy值，然后不断跟上新增的值，有其对应的count
 *
 * 7/6/20.
 */
public class _75_sort_colors {
    public void sortColors(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                n2++;
                nums[n2] = 2;
                n1++;
                nums[n1] = 1;
                n0++;
                nums[n0] = 0;
            } else if (nums[i] == 1) {
                n2++;
                nums[n2] = 2;
                n1++;
                nums[n1] = 1;
            } else if (nums[i] == 2) {
                n2++;
                nums[n2] = 2;
            }

            System.out.println(Arrays.toString(nums));

        }
    }
}
