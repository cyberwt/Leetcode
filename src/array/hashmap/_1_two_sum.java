package array.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 典型 hashmap 时间换空间
 * T:O(N) S:O(N)
 *
 *
 * Brute Force: T:O(N^2) S:O(1)
 *
 *
 * 6/21/20.
 */
public class _1_two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");

    }


    public static void main(String[] args){
        _1_two_sum solution = new _1_two_sum();
        int[] pos = {1,2,3};
        int[] res = solution.twoSum( new int[]{1,2,3,4},6);
        System.out.println(Arrays.toString(res));
    }
}
