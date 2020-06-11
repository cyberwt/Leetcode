package binarySearch.array;

/**
 * Binary Tree
 *
 * 理解能够砍的点 所以这里的等于，是让他溢出的意思
 * if(nums[mid] >= target){
 *     end = mid-1;
 * } 意味着  nums[end] 的值最后一定比target 小了，因为end=mid-1 了，而此时 nums[start] == target
 *
 *
 *
 * 6/11/20.
 */
public class _34_find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        //
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0){
            return res;
        }
        int start = 0, end=nums.length-1;
        while(start <= end){
            int mid = start + (end -start)/2;
            System.out.println("start="+start+" mid="+mid+" end="+end);
            if(nums[mid] >= target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        if(start == nums.length || nums[start] != target) return res;

        res[0] = start;

        start = 0;
        end=nums.length-1;

        while(start <= end){
            int mid = start + (end -start)/2;
            if(nums[mid] <= target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        res[1] = end;
        return res;
    }

    public static void main(String[] args) {
        _34_find_first_and_last_position_of_element_in_sorted_array solution = new _34_find_first_and_last_position_of_element_in_sorted_array();
        int[] nums = {3,7,7,7,9,10};
        int[] res = solution.searchRange(nums,7);
        System.out.println(res[0] + " "+ res[1]);
    }
}
