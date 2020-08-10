package Hash.hastset;

import java.util.HashSet;

/**
 * M1:
 * 基本hashset调用
 *
 * M2:
 * set 与数学  2*( a+b+c+d) - (a+a+b+b+c+d+d) =c
 *
 * M3：
 * 异或 val ^= nums[i]
 *
 *  0 ⊕ a = a
 *  a ⊕ a = 0
 * 8/3/20.
 */
public class _136_single_number {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for(int val: nums){
            if(!set.contains(val)){
                set.add(val);
            }else{
                set.remove(val);
            }
        }

        for(int val: set){
            return val;
        }

        return 0;
    }
}
