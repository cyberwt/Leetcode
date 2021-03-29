package array.count;

import java.util.Arrays;

/**
 *
 * M0:
 * Count sort, one loop to record the frequency of 0, 1, 2
 *
 * M1:
 *
 * Count red++, blue-- when encounter 0,1,2 swap(nums, i, j)
 *
 *
 * 3/13/21
 *
 * 1)left side of array always contains 0s
 * 2)right side of array always contains 2's.
    If somehow we are able to maintain the above invariants, after 1 pass, we will end up
   with a sorted array.
 *
 * 1/28/21
 *
 * 9.29
 * 根本不懂了m1, m2，写的是什么
 *
 * M1:
 * 可能还会让人理解，往后一直拍
 *
 * M3:
 * 积极switch 大法，转到该变的arr上
 *
 *
 *
 *
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
    public void sortColors2(int[] nums) {
        if(nums == null || nums.length ==0){
            return;
        }
        int left =0, right = nums.length-1;
        for(int i=0; i<= right; i++){
            if(nums[i] == 0){
                swap(nums,i,left++);
            }else if(nums[i] == 2){
                swap(nums,i--,right--);
            }
        }
        return;
    }

    public void swap(int[] nums, int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
