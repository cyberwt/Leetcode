package array.manip;

import java.util.HashMap;

/**
 * M1:
 * 放hashmap ,比较 frequency,用到 map.getOrDefault
 *
 * M2: Moore 投票法
 *  if(pre!= nums[i]) 用 count， 把pre的投出去
 *
 * 8/16/20.
 */
public class _169_majority_element {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int before = map.getOrDefault(nums[i], 0);
            if (before == n / 2) {
                return nums[i];
            }
            map.put(nums[i], before + 1);
        }
        //随便返回一个
        return -1;
    }

    public int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int pre=nums[0];
        int count =1;
        for(int i=1; i<nums.length;i++){

            if(pre!= nums[i]){
                count--;
                if(count ==0){
                    count =1;
                    pre = nums[i];
                }
            }else{
                count++;
            }
        }

        return pre;
    }
}
