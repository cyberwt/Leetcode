package array.swap;

import java.util.HashSet;

/**
 *  M1: 有空间限制时，想到 交换值-> 直到满足
 *  Trick:
 *  nums[i] <=> nums[nums[i]-1] //第 nums[i] 个位置的下标是 nums[i] - 1
 *
 *  T:O(N) S:O(1)
 *
 *  M2: 用Set捆绑
 *
 *  6/15/20.
 */
public class _41_first_missing_positive {

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length ==0){
            return 1;
        }

        int len = nums.length;
        for(int i=0; i<nums.length; i++){
            while(nums[i]>0 && nums[i]<= len && (nums[i] != nums[nums[i]-1])){
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0;i<len;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return len+1;
    }

    public void swap(int[] nums, int index1, int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }

    // Set 求解
    public int firstMissingPositive2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            set.add(num);
        }

        for(int i=1; i<= nums.length; i++){
            if(set.add(i)){
                return i;
            }
        }
        return nums.length+1;
    }

}
