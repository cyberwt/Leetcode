package Hash.hashtable;

import java.util.HashMap;

/**
 * M1: Hashmap
 * hashmap.put(value, frequency)
 *
 * M2:
 * set + 数学 会失效，因为 Integer.MAX_VALUE
 *
 *
 *
 *
 * 8/3/20.
 */
public class _137_single_number_II {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }

        }
        return -1; // 这句不会执行
    }
}
