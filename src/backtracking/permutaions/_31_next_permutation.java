package backtracking.permutaions;

import java.util.Arrays;

/**
 *
 *

 Error:
 1. Arrays.sort(nums, inclusiceIndex, exclusiveIndex)
 2. 从后往前，第一个衰落点， 然后挑出后面一堆中，第一个比他大的，与他交换，然后重新sort一下。
 3.原理: 如果一直是升序，那就是sorted的了，找到第一个局部最小，当作切入入口
 4. 不是直接和旁边值交换，而是，剩下的串中，第二大的

 T:O(1) S:O(1)
 *
 *
 * 3/28/21.
 */
public class _31_next_permutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int index = nums.length -1;
        for(int i=index-1; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == nums.length -1){
            Arrays.sort(nums);
            return;
        }
        // not directly switch, but find next one who is bigger than nums[index]

        int point = nums.length-1;
        for(int i=nums.length-1; i>index;i--){
            if(nums[i] > nums[index]){
                point = i;
                break;
            }
        }


        int tem = nums[index];
        nums[index] = nums[point];
        nums[point] = tem;
        Arrays.sort(nums, index+1, nums.length);
        return;
    }
}

