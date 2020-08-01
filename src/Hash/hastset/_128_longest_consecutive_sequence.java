package Hash.hastset;

import java.util.HashSet;

/**
 * 其实不难，只要放入set，然后依次向下用while循环
 *
 * 有一个方便解是 先判断他之前的输在不在里买呢，就会省出其他要判断的值
 *
 *
 * 7/31/20.
 */
public class _128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        HashSet set = new HashSet();

        for(int val: nums){
            set.add(val);
        }
        int res = 1;
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            System.out.println(i);
            int count =1;
            int sign = nums[i]+1;
            while(set.contains(sign)){
                count ++;
                sign++;
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
