package binarySearch.array;

import hashmap._30_substring_with_concatenation_of_all_words;

import java.util.List;

/**
 * Binary Search
 *
 * 巧取 单调增空间，然后把值夹到一个 空间里
 *
 * Error:
 * 必须！带上等号的，无论是
 *     while(start <= end)
 * 还是 nums[mid]<=nums[end] 以防漏值，或进入死循环
 *
 * S:O(1) T:O(logN)
 *
 * 6/9/20.
 */
public class _33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start =0, end=nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid;
            // 夹住单调，且要取等
            if(nums[start] <= nums[mid]){
                if(target< nums[mid] && target>=nums[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            // 夹住单调，且要取等
            if(nums[mid]<=nums[end]){
                if(target>nums[mid] && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

        }
        return -1;
    }

}
