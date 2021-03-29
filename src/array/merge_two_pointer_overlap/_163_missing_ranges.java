package array.merge_two_pointer_overlap;

import java.util.ArrayList;
import java.util.List;

 /**
  * >前提条件
  * input:
  * . valid
  *   . null
  *   . all positive integers
  * . invalid
  * > get intervals
  * . if(nums[i+1] > nums[i] +1) not enough, if nums[i+1] = nums[i] = Integer.MAX_VALUE wii break the rules
  * > so when we manipulate the numbers, use:
  * nums[i+1] > nums[i] +1
  * nums[i+1] > nums[i] +1
  *
  *
  * 2/13/21 3/15
  *
  *
 *  比原来的方法好在:
 *  1. 不用判断字符串是否为空
 *
 *  2. 没必要 头尾比lower, upper 时放在for里面比
 *
 *  3. 不动lower, upper的值以防越界
 *
 *  且若要动 nums的值 就： nums[i+1] != nums[i] && nums[i+1] > nums[i] +1 不越界
 *
 *  8/15/20.
 */
public class _163_missing_ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){

            result.add(formRange(lower,upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower){
            result.add(formRange(lower,nums[0]-1));

        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(formRange(nums[i]+1, nums[i+1]-1));
            }
        }

        // 3rd step
        if (nums[nums.length-1] < upper){
            result.add(formRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    public String formRange(int low, int high){

        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
