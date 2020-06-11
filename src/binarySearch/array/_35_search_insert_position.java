package binarySearch.array;

/**
 *
 *   Binary Search
 *
 *   Error:
 *   溢出点，还是没弄全懂
 *   Thought:
 *   一定是start > end 时溢出
 *
 *   end -> target -> start
 *
 *   target 值一定在 nums[start] nums[end] 之间
 *
 *   target 一定替代了 start 的位置 作为被找到的中间值
 *
 *
 *
 *
 * 6/10/20.
 */
public class _35_search_insert_position {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start =0, end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            System.out.println("start: " + start +" mid: " + mid +" end: " + end );

            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >target){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }

        return start;
    }


    public static void main(String[] args) {
        _35_search_insert_position solution = new _35_search_insert_position();
        int[] nums = {3,7,9};
        int res = solution.searchInsert(nums,10);
        System.out.println(res);
    }

}
