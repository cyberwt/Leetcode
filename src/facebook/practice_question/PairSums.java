package facebook.practice_question;

import java.util.HashMap;
import java.util.Map;

/**
 * E:
 * 想错了，1. hashmap 更直观
 *
 * 2。 当遇到复合体哦阿吉娜的时候，remove一面就够了，否则会对不出结果
 *  2   3  2,3 移一个，否则，直接破环平衡
 *  2   3
 *  2
 *
 * 算sum pair问题时，还是用 hashmap吧，又直观又好理解， in case has some corner case
 *
 * T:O(N) S:O(N)
 *
 * 4/6/21.
 */
public class PairSums {
    public static int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int value : arr) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for (Integer key : map.keySet()) {
            while (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                int addend = k - key;
                if (map.containsKey(addend)) {
                    count += map.get(addend);
                }
            }
        }
        return count;
    }
}
