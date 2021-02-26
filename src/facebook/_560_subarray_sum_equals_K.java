package facebook;

import java.util.HashMap;

/**
 *
 * Brute Force - write it down:
 * > T:O(N^2) S:O(1)
 * M2:
 * HashMap<Sum, Frequency>
 * Error:
 * 现存一个 map.add(0,1) --- 得到是前n的
 *
 *
 * 2/20/21.
 */
public class _560_subarray_sum_equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int tem = 0;
        map.put(0,1);
        for(int i=0;i<nums.length; i++){
            tem += nums[i];
            if(map.containsKey(tem-k)){
                res += map.get(tem-k);
            }
            // ! 这个值
            map.put(tem,map.getOrDefault(tem,0)+1);
        }
        return res;
    }
}
