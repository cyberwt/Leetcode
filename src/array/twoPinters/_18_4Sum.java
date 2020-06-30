package array.twoPinters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Nth Sum
 * 基本步骤
 *
 * T:O(N^3), S:O(1)
 *
 * 6/27/20.
 */
public class _18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4){  //corner case
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i - 1] == nums[i]){   //avoid duplicated
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){   //avoid duplicated
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if(curr == target){
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++; right--;

                    }else if(curr > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }



}
