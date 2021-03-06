package array.twoPinters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * E:
 * > 去重的三部:
 * 第一个i 元素不重: if(i != 0 && nums[i-1] == nums[i]) continue;
 * left, right 不重:
 * while(left<right && left > i+1 && nums[left] == nums[left-1]) left++;
 * while(left<right && right<nums.length-1 && nums[right] == nums[right+1]) right--;
 *
 *
 * > 得到结果后,还得推i++, j-- 的:
 * res.add(Arrays.asList(nums[left], nums[right], nums[i]));
 *
 *
 *
 * 2/25/21
 *
 * while(left<right && left > i+1 && nums[left] == nums[left-1])
 * 探讨的是上一个值，已经是一个标准了，被判断过了，我现在再追查一遍，就没必要了
 *
 *
 *  1. Jump over the next value  if(i != 0 && nums[i-1] == nums[i]) continue;
 *  2. Arrays.sort()
 *  3. while(left<right && left > i+1 && nums[left] == nums[left-1]) left++;
 *
 *
 *
 *  6/27/20.
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length <= 2){
            return res;
        }
        // Need to sort as the value
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                //我应该先判断，这个只是个好值，否则，后判断，left == right 这种情况就会被跳过
                while(left<right && left > i+1 && nums[left] == nums[left-1]) left++;
                while(left<right && right<nums.length-1 && nums[right] == nums[right+1]) right--;
                if(left == right) break;
                int val = nums[left] + nums[right] + nums[i];
                if(val == 0){
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left ++;
                    right--;
                }else if(val > 0){
                    right--;
                }else{
                    left++;
                }

            }

        }
        return res;
    }
}
