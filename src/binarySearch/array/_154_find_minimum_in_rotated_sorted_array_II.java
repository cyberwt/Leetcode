package binarySearch.array;

/**
 * 比较的时候，缝隙 为什么是这样的，
 * 只比 nums[mid] 和 nums[end] 理解 153
 *
 * 只做一件事，end--。因为 mid 和 end 相等，所以我们直接把 end 抛弃一定不会影响结果的。
 *
 *
 * 8/11/20.
 */
public class _154_find_minimum_in_rotated_sorted_array_II {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //
        int start=0, end = nums.length-1;
        // 注意什么时候要退出，什么时候+-1

        while(start < end){
            int mid = start+(end-start)/2;
            // 唯一一个位置破坏全！递增型
            if(nums[mid]> nums[end]){
                start = mid+1;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else{
                end--;
            }

        }
        return nums[end];
    }
}
